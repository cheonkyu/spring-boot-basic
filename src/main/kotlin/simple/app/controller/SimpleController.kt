package simple.app.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired

@RestController
class SimpleController(){
    @GetMapping("ping")
    fun ping(): String{
        return "pong"
    }
}