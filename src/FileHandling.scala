import scala.io.Source
import java.io.FileWriter
//2.Remove Header and Trailer of File using Scala
object FileHandling extends App{
  val contents=Source.fromFile("TestFile").getLines().drop(1).toList
  val fw=new FileWriter("output.txt")
  for(i<-contents.take(contents.size-1))
    fw.write(i+"\n")
  fw.close()
}
