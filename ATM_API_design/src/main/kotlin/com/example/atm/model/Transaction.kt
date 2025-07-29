package com.example.atm.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "transaction")
data class Transaction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null,

    var type: String = "",

    var amount: Long = 0,

    var createdAt: LocalDateTime = LocalDateTime.now()
)
