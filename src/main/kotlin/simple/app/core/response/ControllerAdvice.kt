package simple.app.core.response

import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

/**
 * 전역적으로 모든 컨트롤러에서 반환되는 응답을 가로채서 처리
 *
 * basePackages : 어노테이션이 적용될 패키지 지정
 * basePackageClasses : 특정 클래스의 패키지 지정
 */
@RestControllerAdvice(
    basePackages = ["simple.app.controller"],
)
class ControllerAdvice : ResponseBodyAdvice<Any> {

    /**
     * 어떤 응답이 가로채져야 하는지 결정
     * returnType이 void 타입이 아닌 경우에만 Advice 적용하려면
     * `return returnType.parameterType != Void.TYPE`
     */
    override fun supports(
        returnType: MethodParameter,
        converterType: Class<out HttpMessageConverter<*>>
    ): Boolean {
        return MappingJackson2HttpMessageConverter::class.java.isAssignableFrom(converterType)
        || StringHttpMessageConverter::class.java.isAssignableFrom(converterType)
    }
        

    /**
     * 컨트롤러가 반환한 응답 본문을 실제로 가로채서 처리
     */
    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        return when (body) {
            is String -> 
                Response(
                    status = 200,
                    data = body,
                    error = null
                ).toString()
            else -> Response(
                status = 200,
                data = body,
                error = null
            )
        }
    }
}