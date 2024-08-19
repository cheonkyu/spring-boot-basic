package simple.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.slf4j.LoggerFactory

@SpringBootApplication
class AppApplication
inline fun <reified T> T.logger() = LoggerFactory.getLogger(T::class.java)!!

fun main(args: Array<String>) {
	runApplication<AppApplication>(*args)
}
