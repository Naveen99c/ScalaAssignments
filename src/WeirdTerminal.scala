import scala.io.StdIn._
//Weird Terminal
//  Problem Statement – Here is a weird problem in Susan’s terminal.
//  He can not write more than two words each line, if she writes more than two, it takes only 2 words and the rest are not taken.
//  So she needs to use enter and put the rest in a new line. For a given paragraph,
//  how many lines are needed to be written in Susan’s terminal?
//Input Format:
//  A string as the text to input in the terminal
//Sample Input:
//  How long do you have to sit dear ?
//Sample Output:
//  4
//Explanation:
//  The writing will be:
//  How long
//  Do you
//  Have to
//  Sit dear ?

object WeirdTerminal extends App {
  def lineFinder(paragraph:String):Int={
    val words=paragraph.split(" ")
    var lines=0
    var wordInLine=0
    var i=0
    while(i<words.length){
      if(words(i).exists(_.isLetter)) {
        wordInLine+=1
        if(wordInLine==1)
          lines+=1
        print(words(i)+" ")
      }
      else
        print(words(i)+" ")
      if(wordInLine==2){
        wordInLine=0
        if(!words(i+1).exists(_.isLetter)) {
          print(words(i+1))
          i+=1
        }
        println
      }
      i+=1
    }
    lines
  }
  print("Enter paragraph:")
  val paragraph=readLine()
  //val paragraph="How long do you have to sit dear ?"
  print("\nLines required:"+lineFinder(paragraph))
}
