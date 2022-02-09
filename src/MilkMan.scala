import scala.io.StdIn._
//22.	Milk Man and His Bottles - A Milkman serves milk in packaged bottles of varied sizes.
//  The possible size of the bottles are {1, 5, 7 and 10} litres.
//  He wants to supply the desired quantity using as fewer bottles as possible irrespective of the size.
//  Your objective is to help him find the minimum number of bottles required to supply the given demand for milk.
//  Input Format: The first line contains the number of test cases N. Next N lines, each contains a positive integer Li which corresponds to the demand of milk.
//  Output Format: For each input Li, print the minimum number of bottles required to fulfill the demand.

object MilkMan extends App {
  //Until 20 the smaller number combinations some times yield a better result than using 10 e.g. 14= 10*1+1*4 or 7*2 in which 7*2 is minimum
  //so upto 20 the values are calculated manually. for anything above 20 using 10s yield better result
  def reminderBottleFinder(liters:Int):Int= liters match{
    case 1|5|7|10=>1
    case 2|6|8|11|12|14|15|17=>2
    case 3|9|13|16|18|19=>3
    case 4=>4

  }
  def bottleFinder(liters:Int):Int={
    if(liters<20)
      reminderBottleFinder(liters)
    else
      ((liters-10)/10)+reminderBottleFinder(10+liters%10)
  }
  print("Enter the number of liters:")
  val liters=readInt()
  print("Minimum no. of bottle:"+bottleFinder(liters))
}
