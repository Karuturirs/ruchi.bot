/**
  * Created by ravi on 1/9/17.
  */

import com.bot.utils.CommonFunctions

import scala.io.StdIn.{readInt, readLine}

object ruchi extends App {

  remindme

  def remindme():Unit ={
    val desc = readLine("Hello, What should I remind you about?\n")
    val when = readLine("On which Date?\n").toLowerCase
    var day:String = when match{
      case "today" => CommonFunctions.today()
      case "tomorrow" => CommonFunctions.tomorrow()
      case _ =>{
        val datemsg = "Not a proper input \nPlease enter Date in dd-mm-yyyy format:"
        CommonFunctions.userInputValidate(when,"\\d{2}-\\d{2}-\\d{4}",datemsg)
      }

    }
    val timemsg = "Not a proper input \nPlease enter Time in HH:MM:SS format:"
    val time = CommonFunctions.userInputValidate(readLine("At what Time(HH:MM:SS)?\n"),"\\d{2}:\\d{2}:\\d{2}",timemsg)
    val con = s"I will remind you on $day ,$time Regarding $desc\n  Can I Confirm, Yes|No?\n"
    val check = readLine(con).toLowerCase()

    check match {
      case "yes"  | "ok" => println("THANKS. Saved your reminder")
      case  _ => println("your reminder not saved. Try again if you need.")
    }
  }
}
