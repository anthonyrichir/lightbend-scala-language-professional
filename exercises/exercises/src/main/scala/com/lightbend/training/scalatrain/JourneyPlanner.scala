package com.lightbend.training.scalatrain

class JourneyPlanner(val trains: Set[Train]) {

  val stations: Set[Station] = trains.flatMap(train => train.stations)

  def trainsAt(station: Station): Set[Train] = trains.filter(_.stations.contains(station))

  def stopsAt(station: Station): Set[(Time, Train)] = {
    for {
      train <- trains
//      timeAndStation <- train.schedule if timeAndStation._2 == station
//    } yield timeAndStation._1 -> train
      (t, s) <- train.schedule if s == station
    } yield t -> train
  }

  def isShortTrip(from: Station, to: Station): Boolean = {
    //    trains.exists(train =>
    //      train.stations.dropWhile(station => station != from).drop(1).take(2).contains(to)
    //    )

    trains.exists(train => train.stations.dropWhile(station => station != from) match {
      case `from` +: `to` +: _ => true
      case `from` +: _ +: `to` +: _ => true
      case _ => false
    })
  }
}
