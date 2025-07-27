package com.example.atm.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Transaction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne val user: User,
    val type: String, // "DEPOSIT", "WITHDRAW"
    val amount: Long,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
