package simple.app.core.response

data class Response<T>(
    val status: Int,                                    // HTTP 상태 코드
    val data: T?,                                       // 실제 데이터
    val error: ResopnseError?,                          // error
)

data class ResopnseError(
    val code: Int,
    val message: String
)