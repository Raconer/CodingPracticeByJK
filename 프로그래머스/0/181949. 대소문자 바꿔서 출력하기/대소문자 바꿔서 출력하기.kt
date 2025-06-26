fun main(args: Array<String>) {
    val alphabet = 32
    val s1 = readLine()!!
    s1.forEach{ ch ->
        val chCode = ch.toInt()
        if(65 <= chCode && chCode <= 96){
            print(ch + alphabet)
        } else {
            print(ch - alphabet)
        }
    }
}