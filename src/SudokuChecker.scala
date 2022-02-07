import scala.io.StdIn._
import scala.collection.mutable._

//14.	Given a filled sudoku, write a program to check if sudoku is valid or following all of its rules.
//    SUDOKU rules:
//	Each column contains all of the digits from 1 to 9 only once.
//	Each row contains all of the digits from 1 to 9 only once.
//	Each of the nine 3×3 sub-grid contains all of the digits from 1 to 9 only once.

object SudokuChecker extends App{
  def rowChecker(sudoku:Array[Array[Int]]):Boolean={
    for(i<-sudoku)
      if(i.toSet.size!=9)
        return(false)
    true
  }
  def columnChecker(sudoku:Array[Array[Int]]):Boolean= {
    for(i<-0 until 9) {
      val temp=ListBuffer[Int]()
      for(j<-0 until 9)
        temp+=sudoku(j)(i)
      if(temp.toSet.size!=9)
        return(false)
    }
    true
  }
  def gridChecker(sudoku:Array[Array[Int]]):Boolean= {
    val grid=Map[Int,Set[Int]]()
    for(key<-1 to 9)
      grid(key)=Set[Int]()
    for(i<-0 until 9) {
      for(j<-0 until 9) {
        sudoku(i)(j) match{
          case a if(i<3 && j<3)=>grid(1)+=a
          case a if(i<6 && j<3)=>grid(2)+=a
          case a if(i<9 && j<3)=>grid(3)+=a
          case a if(i<3 && j<6)=>grid(4)+=a
          case a if(i<6 && j<6)=>grid(5)+=a
          case a if(i<9 && j<6)=>grid(6)+=a
          case a if(i<3 && j<9)=>grid(7)+=a
          case a if(i<6 && j<9)=>grid(8)+=a
          case a if(i<9 && j<9)=>grid(9)+=a

        }
      }
      }
    for(key<-1 to 9)
      if(grid(key).size!=9)
        return(false)
    true
    }
  //  Uncomment the below multiline comment for console input
/*  var sudoku=Array.ofDim[Int](9,9)
  println("Enter the sudoku row wise")
  for(i<-0 until 9) {
    var mistake=false
    var temp=new Array[Int] (9)
    do {
      mistake=false
      print(s"Enter ${i+1} row as space separated Integers:")
      temp = readLine().split(" ").map(_.toInt)
      if(temp.size!=9 || !temp.forall(_.toString.length==1)) {
        println("A row should contain 9 single digit numbers")
        mistake=true
      }
    }while(mistake)
    sudoku(i)=temp
  }*/
  //If console input is enabled, comment the below static input
  var sudoku=Array[Array[Int]]( Array(5,3,4,6,7,8,9,1,2),
                                Array(6,7,2,1,9,5,3,4,8),
                                Array(1,9,8,3,4,2,5,6,7),
                                Array(8,5,9,7,6,1,4,2,3),
                                Array(4,2,6,8,5,3,7,9,1),
                                Array(7,1,3,9,2,4,8,5,6),
                                Array(9,6,1,5,3,7,2,8,4),
                                Array(2,8,7,4,1,9,6,3,5),
                                Array(3,4,5,2,8,6,1,7,9) )


  if(rowChecker(sudoku)&&columnChecker(sudoku)&&gridChecker(sudoku))
    print("Valid Sudoku")
  else
    print("Invalid Sudoku")
}
