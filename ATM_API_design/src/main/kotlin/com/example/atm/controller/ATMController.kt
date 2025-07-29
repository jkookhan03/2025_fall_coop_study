package com.example.atm.controller

import com.example.atm.service.ATMService
import org.springframework.web.bind.annotation.*

data class TransactionRequest(
    val userId: Long,
    val amount: Long
)

@RestController
@RequestMapping("/api/atm")
class ATMController(private val atmService: ATMService) {

    @PostMapping("/deposit")
    fun deposit(@RequestBody request: TransactionRequest): String {
        atmService.deposit(request.userId, request.amount)
        return "입금 완료"
    }

    @PostMapping("/withdraw")
    fun withdraw(@RequestBody request: TransactionRequest): String {
        atmService.withdraw(request.userId, request.amount)
        return "출금 완료"
    }
}
