package test.vo

data class TestCaseList(
    var list: ArrayList<TestCaseResult>? = null
){
    private var index:Int = 1

    fun add(expected:Any, actual:Any){
        if(list == null) list = ArrayList()

        list!!.add(TestCaseResult(index++, expected, actual))

    }
}
