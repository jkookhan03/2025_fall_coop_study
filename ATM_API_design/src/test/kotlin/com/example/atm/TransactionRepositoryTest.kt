package com.example.atm

import com.example.atm.model.Transaction
import com.example.atm.model.User
import com.example.atm.repository.TransactionRepository
import com.example.atm.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import kotlin.test.assertEquals

@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    lateinit var transactionRepository: TransactionRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun `거래 저장과 조회가 정상 동작한다`() {
        // given
        val user = userRepository.save(User(username = "john", password = "pass", balance = 500))
        val tx = Transaction(amount = 200, type = "DEPOSIT", user = user, createdAt = LocalDateTime.now())

        // when
        val savedTx = transactionRepository.save(tx)
        val foundTx = transactionRepository.findById(savedTx.id).get()

        // then
        assertEquals(200, foundTx.amount)
        assertEquals("DEPOSIT", foundTx.type)
        assertEquals(user.id, foundTx.user?.id)
    }
}
