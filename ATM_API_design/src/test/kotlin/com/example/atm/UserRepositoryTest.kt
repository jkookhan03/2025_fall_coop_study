package com.example.atm

import com.example.atm.model.User
import com.example.atm.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun `사용자 저장과 조회가 정상 동작한다`() {
        // given
        val user = User(username = "testuser", password = "1234", balance = 1000)

        // when
        val saved = userRepository.save(user)
        val found = userRepository.findById(saved.id).get()

        // then
        assertEquals("testuser", found.username)
        assertEquals(1000, found.balance)
    }
}
