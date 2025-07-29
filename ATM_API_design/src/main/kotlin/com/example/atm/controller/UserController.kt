package com.example.atm.controller

import com.example.atm.model.User
import com.example.atm.repository.UserRepository
import org.springframework.web.bind.annotation.*

data class CreateUserRequest(
    val username: String,
    val password: String
)

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository) {

    @PostMapping("/create")
    fun createUser(@RequestBody request: CreateUserRequest): User {
        val user = User(username = request.username, password = request.password, balance = 0)
        return userRepository.save(user)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User {
        return userRepository.findById(id).orElseThrow()
    }
}
