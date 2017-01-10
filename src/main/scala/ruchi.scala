/**
  * Created by ravi on 1/9/17.
  */

import scala.io.StdIn.{readLine,readInt}

object ruchi {

  def main(args: Array[String]): Unit = {

  }


  def remindme():Unit ={
    val desc = readLine("Hello, What should I remind you about?\n")
    val when = readLine("On which Date?\n").toLowerCase

    when match{
      case "today" =>
      case "tomorrow" =>
      case _ =>
    }
    val time = readLine("At what Time(HH:MM:SS)?\n")
    val con = s"I will remind you on $when ,$time Regarding $desc\n  Can I Confirm?\n"
    val check = readLine(con)

    check match {
      case "YES" | "yes" | "Yes" | "OK" | "Ok" | "ok" => println("THANKS. Saved your reminder")
      case  _ => println("your reminder not saved. Try again if you need.")
    }
  }
}
