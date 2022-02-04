import scala.io.StdIn._

//12.	Write a program to add the digits of the given number until the number becomes a single digit number.
//    Example:
//    Input: 256, Output: 4
//    256 -> 13 -> 4

object MakeSingleDigit extends App {
  print("Enter a number:")
  var n:Int=readInt()
  while(n>9){
    var sum=0
    for(i<-n.toString)
      sum+=i.toInt-48
    n=sum
  }
  print("Output:"+n)
}
