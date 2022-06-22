package com.example.goposapp

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Food {
    @Id
    var id: Long = 0
    var name: String? = null
    var price: String? = null

}