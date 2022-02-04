//8.Given an array of integers, write a program to replace its elements with the maximum element on the right side from their respective positions.
//  Note: If the element is equal to the maximum element on the right, replace it with 0.
//  Example:
//  Original Array: [2, 5, 1, 6, 3, 4]
//  Output: [6, 6, 6, 0, 4, 0]

import scala.collection.mutable._
import scala.io.StdIn._

object MaxElementReplace extends App {
  //print("Enter array of elements separated by space:")
  //var arr:Buffer[Int]=readLine().split(" ").map(_.toInt).toBuffer //uncomment this line for console input
  var arr=Buffer[Int](2,5,1,6,3,4)
  var i=arr.length-1
  while(i>=0){
    var j=i-1
    while(j>=0 && arr(j)<arr(i)) {
        arr(j) = arr(i)
        j -= 1
    }
    arr(i)=0
    i=j
  }
  print(arr.mkString(","))
}
