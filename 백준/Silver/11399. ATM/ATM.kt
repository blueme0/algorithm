fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val timePerPerson = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    timePerPerson.sort()

    var previousTime = 0
    var totalTime = 0

    for (t in timePerPerson) {
        totalTime += previousTime + t
        previousTime += t
    }

    print(totalTime)
}