import scala.io.StdIn._

//3.print triangle pattern using Scala
// #
// ##
// ###
// ####
// #####

object Pattern {
  def main(args: Array[String]): Unit = {
    print("Enter the number of rows in pattern:")
    var n = readInt()
    for (i <- 1 to n) {
      for (j <- 1 to i)
        print("#")
      println("")
    }
  }
}