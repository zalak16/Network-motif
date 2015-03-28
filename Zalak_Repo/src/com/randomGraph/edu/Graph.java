package com.randomGraph.edu;

import java.util.*;
public class Graph
{
	private HashMap<Integer, LinkedList<Integer>> adjacencyList;  //lookup time for hashmap is O(1)
	private int size;
	private int vertexDegreeCount[];
	private long edgeCount; 
	public Graph(int n)
	{
		this.size = n;
		this.adjacencyList = new HashMap<Integer, LinkedList<Integer>>();
		this.vertexDegreeCount = new int[n + 1];
		this.edgeCount = 0;
	}
	
	
	public int[] getVertexDegreeCount()
	{
		return vertexDegreeCount;
	}


	public void setVertexDegreeCount(int[] vertexDegreeCount)
	{
		this.vertexDegreeCount = vertexDegreeCount;
	}


	public HashMap<Integer, LinkedList<Integer>> getAdjacencyList()
	{
		return adjacencyList;
	}
	
	public void setAdjacencyList(HashMap<Integer, LinkedList<Integer>> adjacencyList)
	{
		this.adjacencyList = adjacencyList;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}


	public long getEdgesCount()
	{
		return edgeCount;
	}


	public void setEdgesCount(long edges)
	{
		this.edgeCount = edges;
	}
	
	

}
