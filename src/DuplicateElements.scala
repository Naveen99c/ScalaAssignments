import scala.collection.mutable._
import scala.io.StdIn._
//4.	Program to print only duplicate elements in an Integer Array using Scala
object DuplicateElements extends App{
  print("Enter list of numbers separated by space: ")
  var inputList:Array[Int]=readLine().split(" ").map(_.toInt)
  var dict=Map[Int,Int]()
  print("Duplicate elements: ")
  for(i<-inputList)
    if(dict.contains(i))
      print(i+" ")
    else
      dict(i)=1
}
