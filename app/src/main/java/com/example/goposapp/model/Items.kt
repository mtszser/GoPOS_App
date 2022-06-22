package com.example.goposapp.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Items(
    @Id
    var id: Long = 0,
    var name: String? = null,
    var price: String? = null,
)
