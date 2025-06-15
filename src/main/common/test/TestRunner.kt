package test

import Constants
import test.vo.TestCaseList
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.hasAnnotation
import kotlin.system.measureNanoTime

object TestRunner {


    @JvmStatic
    fun run(clazz: Class<*>){
        val method = clazz.declaredMethods.firstOrNull {
            it.name === Constants.TEST_MEHTOD_NAME
        }?:run{
            println("${Constants.NOT_ANNOTATION_MSG} ${clazz.simpleName}")
            return
        }

        println("[TEST START] : ${clazz.simpleName}")

        try {
            val instance = clazz.constructors.first().newInstance()

            (method.invoke(instance) as? TestCaseList)?.let {  resultList ->
                this.check(resultList)
            }

        } catch (e: Exception) {
            println("❌ 실행 실패: ${e.message}")
            e.printStackTrace()
        }
    }

    fun run(clazz: KClass<*>) {
        val method = clazz.members.firstOrNull {
            it.name == Constants.TEST_MEHTOD_NAME
        } ?: run {
            println("${Constants.NOT_ANNOTATION_MSG} ${clazz.simpleName}")
            return
        }

        println("[TEST START] : ${clazz.simpleName}")

        try {
            val constructor = clazz.constructors.first()
            val instance = constructor.call()

            val result = method.call(instance)
            (result as? TestCaseList)?.let { resultList ->
                this.check(resultList)
            }

        } catch (e: Exception) {
            println("❌ 실행 실패: ${e.message}")
            e.printStackTrace()
        }
    }

    private fun check(resultList:TestCaseList){
        resultList.list?.forEach {  result ->
            // 개별 테스트 케이스에 대해 실행 시간 측정
            val start = System.nanoTime()
            val actualResult = result.actual
            val end = System.nanoTime()
            val elapsedMs = (end - start) / 1_000_000.0

            println("""
                ================== 🧪 테스트 케이스(${result.index}) ==================
                🟢 예상  : ${result.expected.toString().padEnd(30)}
                🔵 결과  : ${actualResult.toString().padEnd(30)}
                ⏱ 시간  : ${"%.3f ms".format(elapsedMs).padEnd(30)}
                ✅ 결과  : ${if (result.expected == actualResult) "✅ SUCCESS" else "❌ FAIL"}
                =====================================================
            
            """.trimIndent())
        }?:run{
            println("테스트 케이스가 없습니다.")
        }
    }
}