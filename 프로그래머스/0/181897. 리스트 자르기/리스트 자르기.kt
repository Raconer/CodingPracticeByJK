class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        return when(n){
            4 -> num_list.slice(slicer[0]..slicer[1]).indices.filter { (it)%slicer[2] == 0 }.map { num_list[slicer[0]+it] }.toIntArray()
            3 -> num_list.slice(slicer[0]..slicer[1]).toIntArray()
            2 -> num_list.slice(slicer[0]..num_list.size-1).toIntArray()
            1 -> num_list.slice(0..slicer[1]).toIntArray()
            else -> intArrayOf()
        }
    }
}