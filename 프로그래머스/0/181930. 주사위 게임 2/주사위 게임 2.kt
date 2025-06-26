class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        val r = arrayOf(a == b, b == c, c== a).count { it }.let { size ->
        val length = (size + 1).coerceAtMost(3)
        var result = 1.0
        (0 until length).forEachIndexed { index, i ->
            val i = index + 1.0
            result *= (Math.pow(a.toDouble(), i) + Math.pow(b.toDouble(), i) + Math.pow(c.toDouble(), i))
        }
        result
        }
        return r.toInt()
    }
}