package com.example.atm.controller

import com.example.atm.service.ATMService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/atm")
class ATMController(private val atmService: ATMService) {

    @PostMapping("/deposit")
    fun deposit(@RequestParam userId: Long, @RequestParam amount: Long) {
        atmService.deposit(userId, amount)
    }

    @PostMapping("/withdraw")
    fun withdraw(@RequestParam userId: Long, @RequestParam amount: Long) {
        atmService.withdraw(userId, amount)
    }
}
