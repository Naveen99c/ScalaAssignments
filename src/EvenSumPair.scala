import scala.io.StdIn._

//11.Given an array of integers, write a program to find the number of pairs with even sum.
//  Example:
//  Given Input: [1, 2, 3, 4]
//  Number of even pairs: 2 [Note: (1, 3) and (2, 4)]
//  Given Input: [6, 7, 1, 3, 2, 5, 4]
//  Number of even pairs: 9

object EvenSumPair extends App {
  def combinationOfPair(n:Int):Int={
    (n*(n-1))/2 // This is the number of combinations formula if there are n elements and 2 should be selected (nC2)
  }

  print("Enter Array of elements separated by space:")
  val arr=readLine().split(" ").map(_.toInt)
  //To form even sum pair, even should be paired with even and odd should be pair with odd
  //so total number of even pair with be (even)C2+(odd)C2
  val oddEven=arr.groupBy(_%2==0)
  val evenPair=combinationOfPair(oddEven(true).length)+combinationOfPair(oddEven(false).length)
  print("Number of even sum pair:"+evenPair)
}
