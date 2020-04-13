package com.lightbend.training.scalatrain

class Time(val hours: Int = 0, val minutes: Int = 0) {
  // TODO Verify that hours is within 0 and 23
  // TODO Verify that minutes is within 0 and 59

  require(hours >= 0 && hours <= 23, "hours must be within 0 and 23")
  require(minutes >= 0 && minutes <= 59, "minutes must be within 0 and 59")

  val asMinutes: Int = hours * 60 + minutes

  def minus(that: Time): Int = asMinutes - that.asMinutes

  def -(that: Time): Int = minus(that)
}

object Time {
  def fromMinutes(minutes: Int): Time = {
    val hours = minutes / 60
    new Time(hours, minutes % 60)
  }
}