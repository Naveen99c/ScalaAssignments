import scala.collection.mutable._
import scala.io.StdIn._
//9.Given an array of string, write a program to find the word in the array which appears the maximum number of times.
//  Example:
//  Input: [Algorithms, String, Integer, Integer, Algorithms, String, Integer, Algorithms, String, Algorithms]
//  Most frequent word: Algorithms

object MaxFrequencyWord extends App{
  //print("Enter array of words separated by space:")
  //val words=(readLine()+",").split(" ")
  val words=Array("Algorithms","String","Integer","Integer","Algorithms","String","Integer","Algorithms","String","Algorithms")
  var frequency=Map[String,Int]()
  var mx:Int=1
  if(words.isEmpty) print("Array is Empty")
  else {
    for (i <- words)
      if (frequency.contains(i)) {
        frequency(i) += 1
        if (frequency(i) > mx)
          mx = frequency(i)
      } else
        frequency(i) = 1
    println("Maximum frequency:")
    for(i<-frequency.keys)
      if(frequency(i)==mx)
        println(i)
  }
}
