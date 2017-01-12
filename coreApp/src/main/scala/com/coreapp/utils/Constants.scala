package com.coreapp.utils

import java.text.SimpleDateFormat

/**
  * Created by ravi on 1/11/17.
  */
object Constants {

  val formattedDate = new SimpleDateFormat("dd-MM-yyyy")
  val formattedTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
  val timezone = "PST"
  val dateregex = "\\d{2}-\\d{2}-\\d{4}"
  val timeregex = "\\d{2}:\\d{2}:\\d{2}"


}
