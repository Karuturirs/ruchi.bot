package com.coreapp.utils

/**
  * Created by ravi on 1/10/17.
  */



import org.scalatest._
import java.util.{Date, TimeZone}
import java.text.SimpleDateFormat

class CommonFunctionsSpec extends FlatSpec{

  val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  val ddf = new SimpleDateFormat("yyyy-MM-dd");

  "Date Functions " should "gives me current date" in {
    assert(CommonFunctions.date == new Date())
  }
  it should "gives me TimeStamp for PST" in {
    val timestamp = sdf.format(new Date())
    assertResult(timestamp)(CommonFunctions.timestampForTimezone())

  }

  it should "gives me TimeStamp for IST" in {
    sdf.setTimeZone(TimeZone.getTimeZone("IST"))
    val timestamp = sdf.format(new Date())
    assertResult(timestamp)(CommonFunctions.timestampForTimezone("IST"))

  }

  it should "gives me today date" in {
    assert(CommonFunctions.today == CommonFunctions.timestampForTimezone().split(" ")(0))
  }

  it should "gives me tomorrow date" in{
    val day = ddf.format(new Date())
    val cc = day.split("-")
    val cur = cc(0)+"-"+cc(1)+"-"+(cc(2).toInt+1).toString
    assert(CommonFunctions.tomorrow == cur)

  }

  it should "gives me date after 5days" in{
    val day = ddf.format(new Date())
    val cc = day.split("-")
    val cur = cc(0)+"-"+cc(1)+"-"+(cc(2).toInt+5).toString
    assert(CommonFunctions.daysToAdd(5) == cur)

  }

  it should "gives me date object instance" in{
    assert(CommonFunctions.toDate("2017-01-12 01:00:00" , "yyyy-MM-dd HH:mm:ss").isInstanceOf[Date])
  }

  it should "gives me date in millisec" in {
    assertResult("1421950856000".toLong)(CommonFunctions.dateInMillsec("2015-01-22 10:20:56" , "yyyy-MM-dd HH:mm:ss"))
  }

  it should "gives me differnce of two dates in millisecs" in {
    assertResult(-60000)(CommonFunctions.timeDifference("2015-01-22 10:20:00" , "2015-01-22 10:21:00" , "yyyy-MM-dd HH:mm:ss"))
  }

}
