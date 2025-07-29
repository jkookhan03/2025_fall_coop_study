package com.example.atm.model

import jakarta.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var username: String = "",

    var password: String = "",

    var balance: Long = 0
)
