window.onload = function() {
    $(".delete-btn").click((e) => {
        e.currentTarget.closest('.row-article').remove();
        var btn = $(e.currentTarget);
        var itemId = btn.attr("data-delete-id");
        $.post("/item-delete/" + itemId, () => {});
    });

    $(".checkmark").click((e) => {
        var btn = $(e.currentTarget);
        var itemId = btn.attr("data-item-id");
        btn.attr("disabled", "disabled");
        $.post("/item-bought/" + itemId, () => {});
    });
};