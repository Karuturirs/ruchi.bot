package com.coreapp.utils

/**
  * Created by ravi on 1/9/17.
  */


import java.util.Date
import java.util.Calendar
import java.util.TimeZone

import scala.io.StdIn.readLine


object CommonFunctions {



  /**Gives the date object
  *
  * @return Date object ex: Tue Jan 10 18:11:38 PST 2017
  **/
  def date():Date={
    new Date()
  }

  /** Get the current Timestamp and time(ex:11-01-2017 08:43:02) for the timezone that you specify(ex: IST)
    *
    * @param timezone: pass what timezone, by default gives PST
    * @return string of Timestamp ex: 11-01-2017 08:43:02
    */
  def timestampForTimezone(timezone:String="PST"):String={
    println("Timezone is:"+timezone)
    Constants.formattedTimestamp.setTimeZone(TimeZone.getTimeZone(timezone))
    Constants.formattedTimestamp.format(date)
  }

  /** Gives you today date
    *
    * @return String of today date ex:10-01-2017 (dd-MM-yyyy)
    */

  def today():String ={
    Constants.formattedDate.format(date())
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
    Constants.formattedDate.setTimeZone(TimeZone.getTimeZone(timezone))
    Constants.formattedDate.format(c.getTime())
  }

  /*
  def validate(content:String, regex:String): Boolean =  if(content.matches(regex)) true else false
  def datevalidate:(String, String) => Boolean = validate
  */

  /** A recursive function that check the content with the regex string  for the user input and
    * returns the message to the user to enter proper content recursively
    *
    * @param content : Input string that needs to be matched
    * @param regex : matches pattern string
    * @param msg : msg to display to user for re-entering the input content
    * @return : content if matched
    */
  @annotation.tailrec
  def userInputValidate(content:String , regex:String, msg:String):String={
    if(content.matches(regex))content
    else{
      val reinputdata = readLine(msg+"\n")
      userInputValidate(reinputdata,regex,msg)
    }
  }

}
