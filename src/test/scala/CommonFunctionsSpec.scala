package test.scala

/**
  * Created by ravi on 1/10/17.
  */


import com.bot.utils.CommonFunctions
import org.scalatest._
import java.util.{Date, TimeZone}
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.text.SimpleDateFormat

class CommonFunctionsSpec extends FlatSpec{

  val sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
  val ddf = new SimpleDateFormat("dd-MM-yyyy");

  "Date Functions " should "Give me current date" in {
    assert(CommonFunctions.date == new Date())
  }
  it should "Give me TimeStamp for PST" in {
    val timestamp = sdf.format(new Date())
    assertResult(timestamp)(CommonFunctions.timestampForTimezone())

  }

  it should "Give me TimeStamp for IST" in {
    sdf.setTimeZone(TimeZone.getTimeZone("IST"))
    val timestamp = sdf.format(new Date())
    assertResult(timestamp)(CommonFunctions.timestampForTimezone("IST"))

  }

  it should "Give me today date" in {
    assert(CommonFunctions.today == CommonFunctions.timestampForTimezone().split(" ")(0))
  }

  it should "Give me tomorrow date" in{
    val day = ddf.format(new Date())
    val cc = day.split("-")(0)
    val cur = day.replaceFirst(cc , (cc.toInt+1).toString)
    assert(CommonFunctions.tomorrow == cur)

  }

  it should "Give me date after 5days" in{
    val day = ddf.format(new Date())
    val cc = day.split("-")(0)
    val cur = day.replaceFirst(cc , (cc.toInt+5).toString)
    assert(CommonFunctions.daysToAdd(5) == cur)

  }

}
