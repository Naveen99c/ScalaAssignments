import scala.collection.mutable._
import scala.io.StdIn._

//16.	Interval is defined as [start, end]- the start of the interval to the end of the interval. Given the list of Intervals write an algorithm to find the maximum number of intervals overlapping at any point in time.
//    Example:
//    Given Intervals: [[0,2], [3,7], [1,5], [7,8], [4,6]]
//    Maximum overlapping: 3
//    Explanation: Interval (4, 5) is overlapping 3 given intervals [3,7], [1,5], [4,6]
//    Given Intervals: [[0,5], [6,8], [1,7]]
//    Maximum overlapping: 2
//    Explanation:Interval (1,5) is overlapping in 2 intervals [0,5],[1,7]


object MaxIntervalOverlap extends App{
  def maxOverlapCounter(intervals:ListBuffer[(Int,Int)]):Int={
    val frequency=Map[Int,Int]()
    for(interval<-intervals)
      for(j<-interval._1 to interval._2)
        if(frequency.contains(j))
          frequency(j)+=1
        else
          frequency(j)=1
    frequency.values.max
  }

  val intervals=ListBuffer[(Int,Int)]()
  print("Enter the number of intervals:")
  val n=readInt()
  for(i<-1 to n){
    print(s"Enter interval $i(space separated):")
    val temp =readLine().split(" ").map(_.toInt)
    intervals+=((temp(0),temp(1)))
  }
  //val intervals=List((0,2),(3,7),(1,5),(7,8),(4,6))
  //val intervals=List((0,5),(6,8),(1,7))

  print(s"Maximum overlapping:${maxOverlapCounter(intervals)}")
}
