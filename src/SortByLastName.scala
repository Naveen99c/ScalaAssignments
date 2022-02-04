
//7.	Sort Names by their Last Names. {"Daenerys Targaryen","Jon Snow","Tyrion Lannister","Joffrey Baratheon"}
import scala.io.StdIn._
object SortByLastName extends App{
  //print("Enter array of names separated by comma:")
  //val name=readLine().split(",")              //For console Input
  val name=List[String]("Daenerys Targaryen","Jon Snow","Tyrion Lannister","Joffrey Baratheon")

  //sorts by ignoring case of last name. If case sensitivity is required remove toUpperCase

  val sortedName=name.sortBy(_.split(" ")(1).toUpperCase)
  print(sortedName.mkString(","))
}
