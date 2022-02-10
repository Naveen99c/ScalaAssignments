import scala.io.StdIn._

//24.	Rat in a maze problem using backtracking, Given a maze where 1 represent free space and 0 represented it is blocked.
// Print the path from 0,0 to n-1, n-1 if exists or print -1. Consider the maze given below.
// Example:
// Input-
//  row: 4
//  maze=[[1,0,0,0],
//       [1,1,0,0],
//       [0,1,1,0],
//       [0,0,1,1]]
//Output-
// Path Exist


object PathFinder {
  var result = false

  def finder(maze: Array[Array[Int]], memoization: Array[Array[Int]], current: (Int, Int), destination: (Int, Int)): Unit = {
    memoization(current._1)(current._2) = 1
    if (current == destination)
      result = true
    else {
      if (current._1 + 1<=destination._1 && maze(current._1 + 1)(current._2) == 1 && memoization(current._1 + 1)(current._2) != 1)
        finder(maze, memoization, (current._1 + 1, current._2), destination)
      if (current._2 + 1<=destination._2 && maze(current._1)(current._2 + 1) == 1 && memoization(current._1)(current._2 + 1) != 1)
        finder(maze, memoization, (current._1, current._2 + 1), destination)
      if (current._1 - 1 >= 0 && maze(current._1 - 1)(current._2) == 1 && memoization(current._1 - 1)(current._2) != 1)
        finder(maze, memoization, (current._1 - 1, current._2), destination)
      if (current._2 - 1 >= 0 && maze(current._1)(current._2 - 1) == 1 && memoization(current._1)(current._2) - 1 != 1)
        finder(maze, memoization, (current._1, current._2 - 1), destination)
    }
  }

  def main(args: Array[String]): Unit = {
    print("Enter the number rows in maze:")
    val n = readInt()
    val m = n
    var maze = new Array[Array[Int]](n)
    for (i <- 0 until n) {
      var invalid = false
      do {
        invalid = false
        print(s"Enter maze row ${i + 1} space separated:")
        val temp = readLine().split(" ").map(_.toInt)
        if (temp.length != m) {
          println(s"There should be only $n numbers per row")
          invalid = true
        }
        else maze(i) = temp
      } while (invalid)
    }
    finder(maze,Array.ofDim[Int](n,n),(0,0),(n-1,n-1))
    if(result==true)
      println("Path Exist")
    else
      println("No Path Exist")
  }
}
