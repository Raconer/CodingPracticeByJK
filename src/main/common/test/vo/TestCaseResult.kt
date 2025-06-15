package test.vo

data class TestCaseResult(
    val index:Int? = null, // 테스트 케이스 번호
    val expected:Any,  // 정답
    val actual:Any,    // 결과 값
)