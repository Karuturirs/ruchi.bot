package com.coreapp.utils

import java.text.SimpleDateFormat

/**
  * Created by ravi on 1/11/17.
  */
object Constants {
  val DATE_FORMAT = "yyyy-MM-dd"
  val TIME_FORMAT = "HH:mm:ss"
  val FORMATTED_DATE = new SimpleDateFormat(DATE_FORMAT)
  val DATE_REGEX = "\\d{4}-\\d{2}-\\d{2}"
  val FORMATTED_TIMESTAMP = new SimpleDateFormat(DATE_FORMAT+" "+TIME_FORMAT)
  val TIME_REGEX = "\\d{2}:\\d{2}:\\d{2}"
  val TIMEZONE = "PST"


}
