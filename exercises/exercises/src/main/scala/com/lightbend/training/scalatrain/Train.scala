package com.lightbend.training.scalatrain

case class Train(info: TrainInfo, schedule: Seq[(Time, Station)]) {
  require(schedule.size >= 2, "Schedule have at least 2 elements")

  val stations = schedule.map(_._2)

  def timeAt(station: Station): Option[Time] = {
    //    schedule.find(timeAndStation => timeAndStation._2 == station).map(timeAndStation => timeAndStation._1)
    schedule.find {
      case (_, needle) => needle == station
    }.map {
      case (time, _) => time
    }
  }
}
