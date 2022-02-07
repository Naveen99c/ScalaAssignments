import scala.io.StdIn._
import scala.collection.mutable._

//15.	Given a playlist that contains the list of intervals with the start time, end time and program id. Write a program to validate whether the playlist is valid or not based on certain conditions.
//The playlist will be considered invalid if any of the following is true –
//
//	If any two programs overlap.
//	If there is any gap between two intervals.
//	If the duration of any program is less than 10.
//	If the duration of any program is greater than 200.
//	If the duration of any program is negative.
//	If the start time or end time of any program is negative.
//If none of the above is true then play list is valid else playlist is not valid. In the case of an invalid playlist, also print the reason with program id.
//Example:
//  Playlist = [[111, 0, 10],[222, 100, 300],[333, 300, 350],[444, 10, 30],[555, 30, 100]]
//Note: [id, start_time, end_time]
//Output: Given playlist is valid
//  Playlist: [[111, 0, 10],[444, 10, 15],[555, 13, 17],[333, 20, 100],[222, 150, 350], [666, 350, -450]]
//Output:
//  Given playlist is NOT valid due to following reasons -
//  Program Id: 444 has duration less than 10
//  Program Id: 444 and Id: 555 are overlapping
//  Program Id: 555 has duration less than 10
//  Program Id: 555 and Id: 333 are having gap
//  Program Id: 333 and Id: 222 are having gap
//  Program Id: 666 has negative times
//  Program Id: 666 has negative duration
//  Program Id: 666 has duration less than 10

object PlayListValidator extends App {
  def validator(programList: ListBuffer[(Int,Int,Int)]): Unit = {
    val sortedList = programList.sortBy(_._2)
    var gapChecker = sortedList(0)._2
    var result = true
    for (i <- 0 until sortedList.length) {
      if (sortedList(i)._2 != gapChecker) {
        if (result == true) println("Given playlist is NOT valid due to following reasons -")
        result = false
        if (gapChecker > sortedList(i)._2)
          println(s"Program ID:${sortedList(i - 1)._1} and ID:${sortedList(i)._1} are overlapping")
        if (gapChecker < sortedList(i)._2)
          println(s"Program ID:${sortedList(i - 1)._1} and ID:${sortedList(i)._1} are having gap")
      }
      if (sortedList(i)._3-sortedList(i)._2 < 10) {
        if (result == true) println("Given playlist is NOT valid due to following reasons -")
        result = false
        println(s"Program ID:${sortedList(i)._1} has duration less than 10")
      }
      if (sortedList(i)._3-sortedList(i)._2 > 200) {
        if (result == true) println("Given playlist is NOT valid due to following reasons -")
        result = false
        println(s"Program ID:${sortedList(i)._1} has duration more than 200")
      }
      if (sortedList(i)._3-sortedList(i)._2< 0) {
        if (result == true) println("Given playlist is NOT valid due to following reasons -")
        result = false
        println(s"Program ID:${sortedList(i)._1} has negative duration")
      }
      if (sortedList(i)._2 < 0 || sortedList(i)._3 < 0) {
        if (result == true) println("Given playlist is NOT valid due to following reasons -")
        result = false
        println(s"Program ID:${sortedList(i)._1} has negative time")
      }
      gapChecker = sortedList(i)._3
    }
    if(result==true)
      println("Given playlist is valid")
  }

  //Uncomment the below multi line comment for console input
  /*val programList=ListBuffer[(Int,Int,Int)]()
  print("Enter the number of programs:")
  val n=readInt()
  for(i<-1 to n) {
    print(s"Enter program $i details(Id,Start time,End time) space separated:")
    val temp=readLine().split(" ").map(_.toInt)
    programList+=((temp(0),temp(1),temp(2)))
  }*/

  val programList=ListBuffer((111, 0, 10),(222, 100, 300),(333, 300, 350),(444, 10, 30),(555, 30, 100))
  //val programList=ListBuffer((111, 0, 10),(444, 10, 15),(555, 13, 17),(333, 20, 100),(222, 150, 350),(666, 350, -450))
  validator(programList)
}

