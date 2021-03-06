package com.fapiko.bangarang.bsptree;

public class Node {
	Node left;
	Node right;
	int value;

	public Node(int value) {
		this.value = value;
	}

	public Node insertSorted(int value) {
		return insertSorted(this, value);
	}

	public Node insertSorted(Node node, int value) {

		if (value < node.value) {
			if (node.left != null) {
				return insertSorted(node.left, value);
			} else {
				node.left = new Node(value);
				return node.left;
			}
		} else if (value > node.value) {
			if (node.right != null) {
				return insertSorted(node.right, value);
			} else {
				node.right = new Node(value);
				return node.right;
			}
		}
		else {
			// do nothing - value already in tree
			return node;
		}

	}

	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println(node.value);
			printInOrder(node.right);
		}
	}

	public void printFrontToBack(Node node, int camera) {
		if (node == null) return;
		if (camera < node.value) {
			// print in order
			printFrontToBack(node.left, camera);
			System.out.println(node.value);
			printFrontToBack(node.right, camera);
		}
		else if (camera > node.value) {
			// print in reverse order
			printFrontToBack(node.right, camera);
			System.out.println(node.value);
			printFrontToBack(node.left, camera);
		}
		else {
			// order doesn't matter
			printFrontToBack(node.left, camera);
			printFrontToBack(node.right, camera);
		}
	}

}
