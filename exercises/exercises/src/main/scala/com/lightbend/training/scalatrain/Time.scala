package com.lightbend.training.scalatrain

case class Time(hours: Int = 0, minutes: Int = 0) {

  require(hours >= 0 && hours <= 23, "hours must be within 0 and 23")
  require(minutes >= 0 && minutes <= 59, "minutes must be within 0 and 59")

  val asMinutes: Int = hours * 60 + minutes

  def minus(that: Time): Int = asMinutes - that.asMinutes

  def -(that: Time): Int = minus(that)

  override lazy val toString: String = f"$hours%02d:$minutes%02d"
}

object Time {
  def fromMinutes(minutes: Int): Time = {
    val hours = minutes / 60
    new Time(hours, minutes % 60)
  }
}