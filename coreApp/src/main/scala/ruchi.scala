/**
  * Created by ravi on 1/9/17.
  */

import com.coreapp.db.cassandra.{CassandraConnectionUri, Helper}
import com.coreapp.utils.{CommonFunctions, Constants}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn.{readInt, readLine}


object ruchi extends App {

  remindme("rbox","sankar005ravi@gmail.com")

  def remindme(id:String,email:String):Unit ={
    val desc = readLine("Hello "+id.toUpperCase+", What should I remind you about?\n")
    val when = readLine("On which Date?\n").toLowerCase
    var day:String = when match{
      case "today" => CommonFunctions.today()
      case "tomorrow" => CommonFunctions.tomorrow()
      case _ =>{
        val datemsg = s"Not a proper input \nPlease enter Date in ${Constants.DATE_FORMAT} format:"

        CommonFunctions.userInputValidate(when,Constants.DATE_REGEX,datemsg)
      }

    }
    val timemsg = s"Not a proper input \nPlease enter Time in HH:mm format:"
    val time = CommonFunctions.userInputValidate(readLine(s"At what Time(HH:mm)?\n"),"\\d{2}:\\d{2}",timemsg)
    val con = s"${id.toUpperCase}, I will send a reminder to $email regarding: ${desc}  at $day $time  \n  Can I Confirm, Yes|No?\n"
    val check = readLine(con).toLowerCase()

    check match {
      case "yes"  | "ok" => {
        println("THANKS. Saved your reminder")
        val conf = ConfigFactory.load("remindme")
        val uri = CassandraConnectionUri(conf.getString("core.db.cassandra.uri"))
        val session = Helper.createSessionAndInitKeyspace(uri)
        session.execute("Insert into remindme ")
      }
      case  _ => println("your reminder not saved. Try again if you need.")
    }
  }
}
