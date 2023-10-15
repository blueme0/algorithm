fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val people = mutableListOf<Person>()

    repeat(N) {
        val (w, t) = br.readLine().split(" ").map { it.toInt() }
        people.add(Person(w, t))
    }
    for (p in people) {
        var count = 1
        for (other in people) {
            if (other.weight > p.weight && other.tall > p.tall) count++
        }
        print("$count ")
    }
}

data class Person(val weight: Int, val tall: Int)