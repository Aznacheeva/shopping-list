package com.example.shoppinglist;

import com.example.shoppinglist.controller.ItemsCreateController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class ShoppingListApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ItemsCreateController itemsCreateController;

	@Test
	public void loadingHeaderTest() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Список покупок")));
	}

	@Test
	@Sql(value = {"/create-item-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(value = {"/create-item-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void countItemsTest() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(xpath("/html/body/div[1]/div").nodeCount(1));
	}
}
