import scala.collection.mutable._
import scala.io.StdIn._
//5.	Algorithm to sort elements in an Array using Scala
object Sorting {
  def selectionSort(arr:Buffer[Int]): Unit ={
    for(i<-0 to arr.length-1){
      var small=i
      for(j<-i+1 to arr.length-1){
        if(arr(small)>arr(j))
          small=j
      }
      val temp=arr(i)
      arr(i)=arr(small)
      arr(small)=temp
    }
  }
  def main(args:Array[String]): Unit ={
    print("Enter an array of elements seperated by space:")
    val arr=readLine().split(" ").map(_.toInt).toBuffer
    selectionSort(arr) //arr.sorted can also be used
    print("Sorted Array:"+arr.mkString(","))
  }
}
