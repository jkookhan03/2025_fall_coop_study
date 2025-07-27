package com.example.atm.service

import com.example.atm.model.Transaction
import com.example.atm.repository.TransactionRepository
import com.example.atm.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ATMService(
    private val userRepository: UserRepository,
    private val transactionRepository: TransactionRepository
) {
    @Transactional
    fun deposit(userId: Long, amount: Long) {
        val user = userRepository.findById(userId).orElseThrow()
        user.balance += amount
        transactionRepository.save(Transaction(user = user, type = "DEPOSIT", amount = amount))
    }

    @Transactional
    fun withdraw(userId: Long, amount: Long) {
        val user = userRepository.findById(userId).orElseThrow()
        if (user.balance < amount) throw IllegalArgumentException("잔액 부족")
        user.balance -= amount
        transactionRepository.save(Transaction(user = user, type = "WITHDRAW", amount = amount))
    }
}
