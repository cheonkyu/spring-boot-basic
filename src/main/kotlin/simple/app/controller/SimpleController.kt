package simple.app.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType

import simple.app.logger

@RestController
class SimpleController(){
    val log = logger()

    @GetMapping("ping", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun ping(): String{
        log.info("call ping pong")
        return "pong".toString()
    }

    @GetMapping("ping1")
    fun pingInt1(): Int{
        log.info("call pingInt1")
        return 1
    }

    @GetMapping("ping2")
    fun pingMap2(): Map<String, String>{
        return mapOf("message" to "ping")
    }

    @GetMapping("ping/error")
    fun pingError(): Map<String, String>{
        val _error =  1 / 0
        return mapOf("message" to "ping")
    }
}