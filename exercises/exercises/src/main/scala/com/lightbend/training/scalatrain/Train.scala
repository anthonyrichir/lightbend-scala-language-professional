package com.lightbend.training.scalatrain

case class Train(info: TrainInfo, schedule: Seq[(Time,Station)]) {
  require(schedule.size >= 2, "Schedule have at least 2 elements")

  val stations = schedule.map(_._2)
}
