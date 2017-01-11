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


  /**Gives the date opject
  *
  * @return Date object ex: Tue Jan 10 18:11:38 PST 2017
  **/
  def date():Date={
    new Date()
  }

  /** get the current Timestamp and time(ex:11-01-2017 08:43:02) for the timezone that you specify(ex: IST)
    *
    * @param timezone: pass what timezone, by default gives PST
    * @return string of Timestamp ex: 11-01-2017 08:43:02
    */
  def timestampForTimezone(timezone:String="PST"):String={
    println("Timezone is:"+timezone)
    formattedDate.setTimeZone(TimeZone.getTimeZone(timezone))
    formattedDate.format(date)
  }

  /** Gives you today date
    *
    * @return String of today date ex:10-01-2017 (dd-MM-yyyy)
    */

  def today():String ={
    formattedDay.format(date());
  }

  /**Gives tomorrow date
    *
    * @return : String of tomorrow date
    */
  def tomorrow():String={
    val tomorrow = daysToAdd(1)
    println("Tomorrows date is " + tomorrow);
    tomorrow
  }


  /** Adds n days to today date and gives you date after n days
    *
    * @param n : no of days to add
    * @param timezone : the timezone that you need
    * @return : String of date ex:10-01-2017 (dd-MM-yyyy)
    */
  def daysToAdd(n:Int,timezone:String="PST"):String={
    val c = Calendar.getInstance()
    c.add(Calendar.DATE, n);  // number of days to add
    formattedDay.setTimeZone(TimeZone.getTimeZone(timezone))
    formattedDay.format(c.getTime())
  }

}
