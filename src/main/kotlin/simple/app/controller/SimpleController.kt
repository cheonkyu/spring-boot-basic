package simple.app.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired

import simple.app.logger

@RestController
class SimpleController(){
    val log = logger()

    @GetMapping("ping")
    fun ping(): String{
        log.info("call ping pong")
        return "pong"
    }
}