import scala.io.StdIn._
import scala.collection.mutable._
import scala.util.control.Breaks._
//13.	Given a string containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘ and ‘]’, determine if the input string is valid.
//  Example:
//  ()()([]({}))[] valid: true
//  ()({]) valid: false
//  []{}() valid: true
//  [(}{)] valid: false

object BracketValidator extends App{
  print("Enter the brackets string:")
  val brackets=readLine()
  var checker=Map('{'->0,'['->0,'('->0)
  breakable{
    for(i<-brackets)
      {
        i match{
          case '{'|'['|'(' =>checker(i)+=1;
          case ')'=> if(checker('(')>0) checker('(')-=1 else {print("Valid: False");break;}
          case '}'=> if(checker('{')>0) checker('{')-=1 else {print("Valid: False");break;}
          case ']'=> if(checker('[')>0) checker('[')-=1 else {print("Valid: False");break;}
        }
      }
      if(checker.equals(Map('{'->0,'['->0,'('->0)))
        print("Valid: True")
      else
        print("Valid:False")
  }
}
