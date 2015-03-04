package com.paulhayman.schoolbrowser.models;

public class Node {

	private Character data;
	private Node parent;
	private Node[] children;
	
	public Node(){
		this.children = new Node[2];
	}

	public Character getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeftChild() {
		return children[0];
	}
	
	public Node getRightChild() {
		return children[1];
	}
	
	public void setLeftChild(Node left){
		children[0] = left;
	}
	
	public void setRightChild(Node right){
		children[1] = right;
	}
}
