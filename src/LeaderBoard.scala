import scala.collection.mutable._
import scala.io.StdIn._
import scala.util.control.Breaks._

//An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:
//  -The player with the highest score is ranked number  on the leaderboard.
//  -Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
//Example:
//  ranked = [100, 90, 90, 80]
//  player = [70, 80, 105]
//  The ranked players will have ranks 1, 2, 2, and 3, respectively.
//  If the player’s scores are 70, 80 and 105, their rankings after each game are 4th, 3rd and 1st. Return [4, 3, 1].
//  Input:
//  ranked=[100 100 50 40 40 20 10]
//  player=[5 25 50 120]
//  Output:
//  [6,4,2,1]

object LeaderBoard extends App {
  def leaderBoard(ranked:Array[Int],player:Array[Int]):Array[Int]={
    val sortedScores=ranked.sortBy(-_)
    val leaderBoard=Map[Int,Int]()
    var prevScore=sortedScores(0)
    var currentRank=1
    var result=Array[Int]()
    for(i<-sortedScores) {
      if (prevScore > i) {
        currentRank += 1
        leaderBoard(i) = currentRank
      }
      else
        leaderBoard(i) = currentRank
      prevScore = i
    }
    for(i<-player){
      var flag=true
      breakable {
        for (j <- sortedScores)
          if (i >=j) {
            result ++= Array(leaderBoard(j))
            flag = false
            break
          }
      }
        if(flag)
          result++=Array(currentRank+1)
      }
    result
  }

//  print("Enter leader board score(ranked) space separated:")
//  val ranked=readLine().split(" ").map(_.toInt)
//  print("Enter leader player score(ranked) space separated:")
//  val player=readLine().split(" ").map(_.toInt)
  val ranked=Array(100,100,50,40,40,20,10)
  val player=Array(5,25,50,120)
  print("Player's Ranks:")
  leaderBoard(ranked,player).foreach(a=>print(s"$a "))
}
