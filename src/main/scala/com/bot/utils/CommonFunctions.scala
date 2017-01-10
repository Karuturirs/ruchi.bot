package com.bot.utils

/**
  * Created by ravi on 1/9/17.
  */

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Calendar
import java.util.TimeZone


object CommonFunctions {

  val formattedDay = new SimpleDateFormat("dd-MM-yyyy")
  val formattedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
  val timezone = "PST"

  def now(timezone:String="PST"): String ={
    date(timezone).toString
  }


  def date(timezone:String="PST"):Date={
    formattedDate.setTimeZone(TimeZone.getTimeZone(timezone))
    new Date()
  }


  def today(timezone:String="PST"):String ={
    formattedDay.format(date(timezone));
  }

  def tommorrow(timezone:String="PST"):String={
    val tomorrow = daysToAdd(1)
    println("Tomorrows date is " + tomorrow);
    tomorrow

  }

  def daysToAdd(n:Int):String={
    val c = Calendar.getInstance()
    c.add(Calendar.DATE, n);  // number of days to add
    formattedDay.format(c.getTime())
  }


}
