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
		return findLevelsForValue(value);
	}

	private void buildTree(String treeStr) {
		
		Queue<Node> treeQueue = new LinkedList<Node>();
		treeQueue.add(treeRoot);
		
		for(int i = 0; i < treeStr.length(); i++){		
			char data = treeStr.charAt(i);
			if(data != ','){
				Node currentNode = treeQueue.remove();
				currentNode.setData(data);
				currentNode.setLeftChild(new Node());
				currentNode.setRightChild(new Node());
				treeQueue.add(currentNode.getLeftChild());
				treeQueue.add(currentNode.getRightChild());
			}
		}
	}
	
	private List<Integer> findLevelsForValue(int value) {
		
		List<Integer> levels = new ArrayList<Integer>();
		Queue<Node> treeQueue = new LinkedList<Node>();
		treeQueue.add(treeRoot);
		int nodeCount = 0;
		while(!treeQueue.isEmpty()){		
			Node currentNode = treeQueue.remove();
			nodeCount++;
			if(value == Character.getNumericValue(currentNode.getData())){
				//Find level of this node
			}
			treeQueue.add(currentNode.getLeftChild());
			treeQueue.add(currentNode.getRightChild());
		}
		return levels;
	}
	

}
