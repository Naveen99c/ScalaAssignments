//1.	Reversal of string in Scala using recursive function
import scala.io.StdIn._
import scala.annotation.tailrec
// 1.	Reversal of string in Scala using recursive function
object StringReverse {
  @tailrec
  def String_Reverse(str:String,rev:String=""):String={
    var ln=str.length
    if(ln>0)
      String_Reverse(str.slice(1,ln),str.charAt(0)+rev)
    else
      rev
  }
  def main(args:Array[String]): Unit ={
    print("Enter the string to be reverse:")
    val s:String=readLine()
    println("Output:"+String_Reverse(s))
  }

}
