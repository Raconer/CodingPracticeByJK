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
       /* if (!clazz.hasAnnotation<TestCase>()) {
            println("${Constants.NOT_ANNOTATION_MSG} ${clazz.simpleName}")
            return
        }

        println("🧪 테스트 시작: ${clazz.simpleName}")

        try {
            val instance = clazz.constructors.first().call()

            // 공통 Before

            var result: Any? = null
            val elapsed = measureNanoTime {
                val execMethod = clazz.declaredFunctions.firstOrNull { it.name == "execute" }
                    ?: error("execute() 메서드가 존재하지 않습니다")
                result = execMethod.call(instance)
            }

            // 공통 After

            println("🟢 결과: $result")
            println("⏱ 실행 시간: %.3f ms".format(elapsed / 1_000_000.0))

        } catch (e: Exception) {
            println("❌ 실행 실패: ${e.message}")
            e.printStackTrace()
        }

        println("==================================")*/
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