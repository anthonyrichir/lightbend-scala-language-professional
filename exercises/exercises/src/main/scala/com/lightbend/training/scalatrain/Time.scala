package com.lightbend.training.scalatrain

import play.api.libs.json.{JsValue, Json}

import scala.util.Try

case class Time(hours: Int = 0, minutes: Int = 0) extends Ordered[Time] {

  require(hours >= 0 && hours <= 23, "hours must be within 0 and 23")
  require(minutes >= 0 && minutes <= 59, "minutes must be within 0 and 59")

  val asMinutes: Int = hours * 60 + minutes

  def minus(that: Time): Int = asMinutes - that.asMinutes

  def -(that: Time): Int = minus(that)

  override lazy val toString: String = f"$hours%02d:$minutes%02d"

  override def compare(that: Time): Int = this.asMinutes - that.asMinutes

  def toJson(): JsValue = Json.toJson(this)

  def fromJson(jsValue: JsValue): Time = Try(jsValue.asOpt[Time]).getOrElse(Time)
}

object Time {
  def fromMinutes(minutes: Int): Time = {
    val hours = minutes / 60
    new Time(hours, minutes % 60)
  }
}