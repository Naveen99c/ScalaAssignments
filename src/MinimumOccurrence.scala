import scala.io.StdIn._
import scala.collection.mutable._

//19. Minimum Occurrence – Given a sting , return the character that appears the minimum number of times in the string.
//    The string will contain only ascii characters, from the ranges (“a”-”z”,”A”-”Z”,0-9), and case matters .
//    If there is a tie in the minimum number of times a character appears in the string return the character that appears first in the string.
//    Input Format: Single line with no space denoting the input string.

object MinimumOccurrence extends App{
  def occurrenceCounter(str:String):Option[Char]={
    val dict=LinkedHashMap[Char,Int]()
    if(str.length==0)
      return None
    else {
      for(i<-str)
        if(dict.contains(i))
          dict(i)+=1
        else
          dict(i)=1
      var min=dict.values.min
      for((k,v)<-dict)
        if(v==min)
          return Some(k)

    }
    None
  }
  print("Enter a String:")
  val str=readLine()
  occurrenceCounter(str) match{
   case None =>print("Empty String")
   case Some(a) => print(s"Minimum frequency character:$a")
 }


}
