package com.example.goposapp.model

data class Item(
    var id: String,
    var name: String,
    var description: String,
    var price: Price,
    var category: Category
)

data class ItemResponse(
    val data: List<Item>
)
