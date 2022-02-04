import scala.io.StdIn._
import scala.collection.mutable._
import scala.annotation.tailrec

//6.Binary Search in Scala (Iterative, Recursion, Tail Recursion Approaches)

object BinarySearch extends App {
  def binarySearchIterative(arr:Buffer[Int],searchElement:Int):Option[Int]={
    var left=0
    var right=arr.length-1
    while(left<=right){
      val mid=(left+right)/2
      if(arr(mid)==searchElement)
        return(Some(mid))
      else if(arr(mid)<searchElement)
        left=mid+1
      else
        right=mid-1
    }
    None
  }
  def binarySearchRecursion(arr:Buffer[Int],left:Int,right:Int,searchElement:Int):Option[Int]={
    if(left<=right){
      val mid=(left+right)/2
      if(arr(mid)==searchElement)
        Some(mid)
      else if(arr(mid)<searchElement)
        binarySearchRecursion(arr,mid+1,right,searchElement)
      else
       binarySearchRecursion(arr,left,mid-1,searchElement)
    }
    None
  }
  @tailrec
  def binarySearchTailRecursion(arr:Buffer[Int],left:Int,right:Int,searchElement:Int):Option[Int]={
    if(left<=right) return None
    val mid=(left+right)/2
    arr(mid) match {
      case searchElement => Some(mid)
      case e:Int if(e<searchElement) => binarySearchTailRecursion(arr,mid+1,right,searchElement)
      case e:Int if(e>searchElement) => binarySearchTailRecursion(arr,left,mid-1,searchElement)
    }

  }
  //Binary search only works if the array is sorted
  print("Enter an sorted array of elements separated by space:")
  val arr=readLine().split(" ").map(_.toInt).toBuffer
  print("Enter the element to be searched:")
  val se=readInt()
  print("Output(Iterative):")
  binarySearchIterative(arr,se) match {
    case Some(i) => println(s"Element found at index $i")
    case None => println("Element not found")
  }
  print("Output(Recursion):")
  binarySearchIterative(arr,se) match {
    case Some(i) => println(s"Element found at index $i")
    case None => println("Element not found")
  }
  print("Output(Tail Recursion):")
  binarySearchIterative(arr,se) match {
    case Some(i) => println(s"Element found at index $i")
    case None => println("Element not found")
  }
}
