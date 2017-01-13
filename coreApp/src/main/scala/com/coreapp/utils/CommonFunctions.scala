package com.coreapp.utils

/**
  * Created by ravi on 1/9/17.
  */


import java.text.SimpleDateFormat
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

  /** Get the current Timestamp and time(ex:yyyy-MM-dd 08:43:02) for the timezone that you specify(ex: IST)
    *
    * @param timezone: pass what timezone, by default gives PST
    * @return string of Timestamp ex: yyyy-MM-dd 08:43:02
    */
  def timestampForTimezone(timezone:String="PST"):String={
    println("Timezone is:"+timezone)
    Constants.FORMATTED_TIMESTAMP.setTimeZone(TimeZone.getTimeZone(timezone))
    Constants.FORMATTED_TIMESTAMP.format(date)
  }

  /** Gives you today date
    *
    * @return String of today date ex:(yyyy-MM-dd)
    */

  def today():String ={
    Constants.FORMATTED_DATE.format(date())
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
    * @return : String of date ex: (yyyy-MM-dd)
    */
  def daysToAdd(n:Int,timezone:String="PST"):String={
    val c = Calendar.getInstance()
    c.add(Calendar.DATE, n);  // number of days to add
    Constants.FORMATTED_DATE.setTimeZone(TimeZone.getTimeZone(timezone))
    Constants.FORMATTED_DATE.format(c.getTime())
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

  /** toDate function gives Date object for give date string and its format
    *
    * @param date : String of input date
    * @param format : String of input date format
    * @return : java.util.Date object
    */
  def toDate(date:String , format:String):Date = (new SimpleDateFormat(format)).parse(date)

  /** for given input date string and date format, gives date in millisecs
    *
    * @param date  : String of input date
    * @param format : String of input date format
    * @return : Long (date in millisecs)
    */
  def dateInMillsec(date:String , format:String):Long = toDate(date,format).getTime

  /** Difference of date1 and date2 in millisecs
    *
    * @param date1 : String of input date1
    * @param date2 : String of input date2
    * @param format : String of input date format
    * @return :   +ve Long(millisecs) then date1 > date2
    *             -ve Long(millisecs) then date1 < date2
    */
  def timeDifference(date1:String , date2:String ,format:String):Long = dateInMillsec(date1,format)- dateInMillsec(date2,format)

  /**Gives the millsecs from current time to input date
    *
    * @param date  : String of input date
    * @param format : String of input date format
    * @return : +ve Long (millisecs) then date is future
    *           -ve Long (millisecs) then date is past
    */
  def timeDiffFromNoW(date:String , format:String):Long =  dateInMillsec(date,format) - (new Date()).getTime

}
