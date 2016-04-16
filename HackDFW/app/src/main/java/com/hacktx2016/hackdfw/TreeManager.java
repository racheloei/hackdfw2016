package com.hacktx2016.hackdfw;
import java.util.ArrayList;

public class TreeManager {

	KdTree<Event> tree;
	SquareEuclideanDistanceFunction distance;
	public TreeManager() {
		tree = new KdTree<Event>(2);
		distance = new SquareEuclideanDistanceFunction();
	}

	void addEvent(double latitude, double longitude, String title, String description, int rating) {
		double[] point = { latitude, longitude };
		Event event = new Event(title, description, rating);
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