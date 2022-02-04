import scala.collection.mutable._
import scala.io.StdIn._

//10.Given a set of digits, write an algorithm to construct the largest number possible by appending the given digits.
//  Example:
//  Given Digits: [9, 1, 9, 2, 8, 4, 2]
//  largest number: 9984221

object LargestNumber extends App{
  print("Enter array of digits seperated by space:")
  val arr=readLine().split(" ")
  var mx=""
  if(arr.forall(_.length==1)){
    for(i<-arr.sortBy(-_.toInt))
      mx+=i
    println("Maximum number:"+mx)
  }
  else
    println("Please enter array of single digit numbers")
}
