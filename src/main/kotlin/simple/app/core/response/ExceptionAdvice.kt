package simple.app.core.response

import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

/**
 * 전역적으로 예외 처리
 */
@RestControllerAdvice
class ExceptionAdvice {

    // /**
    //  * 사용자 정의 예외(CustomException) 처리
    //  * 해당 예외가 발생할 경우, 미리 정의된 상태 코드와 메시지로 응답을 반환
    //  */
    // @ExceptionHandler(CustomException::class)
    // fun handleCustomException(e: CustomException, request: HttpServletRequest): ErrorResponse {
    // }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception, request: HttpServletRequest): Response<Any> {
        println("error:$e")
        return Response(
            status = 500,
            data = null,
            error = ResopnseError(
                code = 500,
                message = e.localizedMessage
            )
        )
    }
}