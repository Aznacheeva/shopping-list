package com.example.shoppinglist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Boolean isDone = false;

    public Item(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    @SuppressWarnings("UnusedDeclaration")
    public Item() {

    }

    @SuppressWarnings("UnusedDeclaration")
    public Long getId() {
        return id;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getText() {
        return text;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone() {
        isDone = !isDone;
    }
}
