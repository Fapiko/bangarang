package com.fapiko.bangarang.bsptree;

import org.junit.Test;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NodeTest extends TestCase {

	@Test
	public void testInsertSorted() {

		Node node = new Node(5);
		node.insertSorted(7);
		node.insertSorted(4);

		assertEquals(5, node.value);
		assertEquals(7, node.right.value);
		assertEquals(4, node.left.value);

	}

	@Test
	public void testPrintInOrder() {

		ByteArrayOutputStream systemOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(systemOut));

		Node root = new Node(5);
		root.insertSorted(7);
		root.insertSorted(4);
		root.insertSorted(10);

	    root.printInOrder(root);

		assertEquals("4\n5\n7\n10\n", systemOut.toString());

	}

}
