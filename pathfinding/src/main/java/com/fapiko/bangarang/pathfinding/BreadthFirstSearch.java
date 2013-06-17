package com.fapiko.bangarang.pathfinding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {

	private List constructPath(Node node) {

		LinkedList path = new LinkedList();
		while (node.pathParent != null) {
			path.addFirst(node);
			node = node.pathParent;
		}

		return path;

	}

	public List search(Node startNode, Node goalNode) {

		// list of visited nodes
		LinkedList closedList = new LinkedList();

		// list of nodes to visit (sorted)
		LinkedList openList = new LinkedList();
		openList.add(startNode);
		startNode.pathParent = null;

		while (!openList.isEmpty()) {
			Node node = (Node)openList.removeFirst();
			if (node == goalNode) {
				// path found!
				return constructPath(goalNode);
			} else {
				closedList.add(node);

				// add neighbors to the open list
				Iterator i = node.neighbors.iterator();
				while (i.hasNext()) {
					Node neighborNode = (Node)i.next();
					if (!closedList.contains(neighborNode) && !openList.contains(neighborNode)) {
						neighborNode.pathParent = node;
						openList.add(neighborNode);
					}
				}
			}
		}

		// no path found
		return null;

	}

}
