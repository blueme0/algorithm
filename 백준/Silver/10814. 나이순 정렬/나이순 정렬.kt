fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val arr: ArrayList<Member> = ArrayList()

    repeat(N) {
        val line = br.readLine().split(" ")
        val m = Member(line[0].toInt(), line[1])
        arr.add(m)
    }
//    arr.sortWith(Comparator { o1, o2 -> o1.age - o2.age })
    val newArr = arr.sortedWith(Comparator { o1, o2 -> o1.age - o2.age })
    for (mem in newArr) {
        println(mem.age.toString() + " " + mem.name)
    }
}

data class Member(val age: Int, val name: String)