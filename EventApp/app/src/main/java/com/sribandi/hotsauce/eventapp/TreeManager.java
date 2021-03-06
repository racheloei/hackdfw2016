package com.sribandi.hotsauce.eventapp;
import java.util.ArrayList;

public class TreeManager {

	KdTree<Event> tree;
	SquareEuclideanDistanceFunction distance;
	public TreeManager() {
		tree = new KdTree<Event>(2);
		distance = new SquareEuclideanDistanceFunction();
	}

	void addEvent(double latitude, double longitude, String title, String description, int rating) {
		double[] point = { longitude, latitude };
		Event event = new Event(title, description, rating, longitude, latitude);
		tree.addPoint(point, event);
	}

	ArrayList<Event> getEvents(double currentLat, double currentLong, int numEvents) {
		double[] point = { currentLat, currentLong };
		NearestNeighborIterator<Event> iterator = tree.getNearestNeighborIterator(point, numEvents, distance);
		ArrayList<Event> list = new ArrayList<Event>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
}