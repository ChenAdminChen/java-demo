package com.example.testkotlin.controller

import com.example.testkotlin.entity.College
import com.example.testkotlin.entity.StuTea
import com.example.testkotlin.entity.User
import com.example.testkotlin.repository.StuTeaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.redis.core.RedisTemplate

@RestController
@RequestMapping("/student")
class StudenController {
//
//    @Autowired
//    lateinit var redisTemp: RedisTemplate


    @Autowired
    lateinit var stuTeaRepository: StuTeaRepository

    @GetMapping("/student")
    fun getStudent(): ResponseEntity<MutableList<StuTea>> {

        var stuTea = stuTeaRepository.findAll()
        var responseEntity = ResponseEntity(stuTea, HttpStatus.OK)


        return responseEntity
    }

    @GetMapping("/cache")
    fun cache(@RequestParam(value = "token") token: String): ResponseEntity<User> {

        return ResponseEntity(createCache(token), HttpStatus.OK)
    }

    @Cacheable(value = ["piDecimals"], key = "#token")
    fun createCache(token: String): User {
        var user = User()

        user.token = token
        user.name = token + "xxx"

        print("cache not ")
        return user
    }


}