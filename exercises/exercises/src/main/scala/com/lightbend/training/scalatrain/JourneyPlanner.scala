package com.lightbend.training.scalatrain

class JourneyPlanner(val trains: Set[Train]) {

    val stations: Set[Station] = trains.flatMap(train => train.stations)

    def trainsAt(station: Station): Set[Train] = trains.filter(_.stations.contains(station))

    def stopsAt(station: Station): Set[(Time,Train)] = {
        for {
            train <- trains
            timeAndStation <- train.schedule if timeAndStation._2 == station
        } yield timeAndStation._1 -> train
    }
}
