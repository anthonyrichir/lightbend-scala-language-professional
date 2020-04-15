package com.lightbend.training.scalatrain

class JourneyPlanner(val trains: Set[Train]) {

    val stations: Set[Station] = trains.flatMap(train => train.stations)

    def trainsAt(station: Station): Set[Train] = trains.filter(_.stations.contains(station))
}
