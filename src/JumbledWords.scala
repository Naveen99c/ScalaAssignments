import scala.io.StdIn._

//20.Jumble the words - Pattern to be followed is , pick a character from the first word and pick another character from the second word.
// Continue this process. Take two strings as input , create a new string by picking a letter from string1 and then from string2,
// repeat this until both strings are finished and maintain the subsequence. If one of the strings is exhausted before the other,
// append the remaining letters from the other string all at once.

object JumbledWords extends App{
  def jumble(str1:String,str2:String):String={
    var result=""
    var balance=""
    val minLength={if(str1.length<str2.length){balance+=str2.slice(str1.length,str2.length);str1.length;}
                   else {balance+=str1.slice(str2.length,str1.length);str2.length;}
                  }
    for(i<-0 until minLength) {
      result+=str1.charAt(i)
      result+=str2.charAt(i)
    }
    result+balance
  }
  print("Enter String 1:")
  val str1=readLine()
  print("Enter String 2:")
  val str2=readLine()
  print("Jumbled word:"+jumble(str1, str2))
}
