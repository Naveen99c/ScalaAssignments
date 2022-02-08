import scala.io.StdIn._
import scala.collection.mutable._

//21.	Maximum Attendance - A teacher wants to look at students’ attendance data.
//  Given that there is a class , and the teacher has the record of the students present on n days of the month,
//  find the maximum number of consecutive days on which all students were present in the class.
//  Example
//  m=4
//  n=7
//  data=[PPPP, PPPP ,PPPP ,PPAP ,AAPP ,PAPA ,AAAA]
//  There are 4 students and 7 days attendance data . There are only three days, at the beginning where all students are present. Student 3 is absent on the fourth day , and students 1 and 2 are absent on the fifth day , and students 2 and 4 are absent on the sixth day and all are absent on the last day.
//  The maximum number of consecutive days on which all the students were present in the class is 3 days long.


object MaximumAttendance extends App {
  def maxAttendanceFinder(attendance:List[String]):Int={
    var mx=0
    var count=0
    for(i<-attendance)
      if(i.toUpperCase.forall(_=='P')){
        count+=1
        if(count>mx)
          mx=count
      }
      else
        count=0
    mx
  }
  //Uncomment the below multi line comment for console input

  /*print("Enter the number of students in the class:")
  val m=readInt()
  print("Enter the number of days in attendance:")
  val n=readInt()
  var data=List[String]()
  for(i<-1 to n){
    var invalid=false
    do {
      invalid=false
      print(s"Enter day $i attendance:")
      val temp = readLine()
      if(temp.length!=m) {
        println(s"There are $m students in class")
        invalid=true
      }
      else data =data:++List(temp)
    }while(invalid)
  }*/

  //comment the below static input if console input is enabled
  val m=4
  val n=7
  val data=List("PAPP","PPPP","PPPP","PPPP","PAPP","PPPP","PPPP")
  print("Maximum Consecutive Attendance:"+maxAttendanceFinder(data))

}
