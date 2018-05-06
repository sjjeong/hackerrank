package climbing_the_leaderboard

import java.util.*

/*
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * Complete the climbingLeaderboard function below.
 */
fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {
    /*
     * Write your code here.
     */
    val distinctScores = scores.distinct()

    val results = mutableListOf<Int>()

    var loopEndIndex = distinctScores.size - 1
    loop@ for (aliceScore in alice) {
        for (index in loopEndIndex downTo 0) {
            val distinctScore = distinctScores[index]
            if (distinctScore > aliceScore) {
                results.add(index + 2)
                loopEndIndex = index
                continue@loop
            }
            if (distinctScore == aliceScore) {
                results.add(index + 1)
                loopEndIndex = index
                continue@loop
            }
        }
        results.add(1)
    }

    return results.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val scoresCount = scan.nextLine().trim().toInt()

    val scores = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val aliceCount = scan.nextLine().trim().toInt()

    val alice = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}
