package com.paulhayman.schoolbrowser.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.paulhayman.schoolbrowser.models.Node;

public class TreeServiceImpl implements TreeService{

	private Node treeRoot;
	
	@Override
	public List<Integer> getLevelsForValue(String treeStr, int value) {
		
		treeRoot = new Node();
		buildTree(treeStr);
		return listLevelsForValue(value);
	}

	private void buildTree(String treeStr) {
		
		Queue<Node> treeQueue = new LinkedList<Node>();
		treeQueue.add(treeRoot);
		
		for(int i = 0; i < treeStr.length(); i++){		
			Node currentNode = treeQueue.remove();
			char data = treeStr.charAt(i);
			if(data != ','){
				currentNode.setData(data);
				currentNode.setLeftChild(new Node());
				currentNode.setRightChild(new Node());
				treeQueue.add(currentNode.getLeftChild());
				treeQueue.add(currentNode.getRightChild());
				i++; 			//if char is node value skip comma
			}
		}
	}
	
	private List<Integer> listLevelsForValue(int value) {
		
		List<Integer> levels = new ArrayList<Integer>();
		Queue<Node> treeQueue = new LinkedList<Node>();
		treeQueue.add(treeRoot);
		
		while(!treeQueue.isEmpty()){
			
			Node currentNode = treeQueue.remove();
			Character data = currentNode.getData();
			if(data != null){
				if(value == Character.getNumericValue(data)){
					levels.add(getNodeLevel(currentNode));
				}
				treeQueue.add(currentNode.getLeftChild());
				treeQueue.add(currentNode.getRightChild());
			}		
		}
		return levels;
	}

	private int getNodeLevel(Node node) {
		
		int level = 1;
		Node currentNode = node;
		while(currentNode != null && currentNode.getParent() != null){
			level++;
			currentNode = currentNode.getParent();
		}
		return level;
	}
	

}
