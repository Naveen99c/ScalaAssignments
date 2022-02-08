import scala.io.StdIn._

//18.	Mr. Robot’s Password – Mr. Robot is making a website, in which there is a tab to create a password. As other websites, there are rules so that the password gets complex and none can predict the password for another. So he gave some rules like:
//  At least one numeric digit
//  At Least one Small/Lowercase Letter
//  At Least one Capital/Uppercase Letter
//  Must not have space
//  Must not have slash (/)
//  At least 6 characters
//  If someone inputs an invalid password, the code prints: “Invalid password, try again”. Otherwise, it prints: “password valid”.


object PasswordValidator extends App{
  print("Please Enter the password:")
  var valid=true
  do {
    val password = readLine()
    valid = true
    if (!password.exists(_.toString.matches("[0-9]")))
      valid = false
    else if (!password.exists(_.toString.matches("[a-z]")))
      valid = false
    else if (!password.exists(_.toString.matches("[A-Z]")))
      valid = false
    else if (password.exists(_ == ' '))
      valid = false
    else if (password.exists(_ == '/'))
      valid = false
    else if (password.length < 6)
      valid = false
    if (valid)
      print("Password Valid")
    else
      print("Invalid password, try again:")
  }while(!valid)
}
