package com.randomGraph.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class AdjacencyList
{
	void createAdjacencyList(Graph graph)
	{
		for(int i=0; i< graph.getSize(); i++)
		{
			graph.getAdjacencyList().put(i,new LinkedList<Integer>());
		}
	}
	
	void getAdjacencyListValues(String filename, Graph graph) throws FileNotFoundException
	{
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext())
		{
			int vertex = scanner.nextInt();
			int adjacentEdge = scanner.nextInt();
			setEdges(graph, vertex, adjacentEdge);
		}
		scanner.close();
	}
	
	void setEdges(Graph graph, int to, int from)
	{
		if(to > graph.getSize() || from > graph.getSize())
		{
			System.out.println("Vertices does not exist " +  to + " " + from);
			
		}
		if(graph.getAdjacencyList().containsKey(to))
		{
			List<Integer> listAdjacentVertices = graph.getAdjacencyList().get(to);
			listAdjacentVertices.add(from);
		}
		
		if(graph.getAdjacencyList().containsKey(from))
		{
			List<Integer> listAdjacentVertices = graph.getAdjacencyList().get(from);
			listAdjacentVertices.add(to);
		}
	}
	
	List<Integer> getEdges(Graph graph, int to)
	{
		if(to > graph.getSize())
		{
			System.out.println("the vertices does not exists");
			return null;
		}
		return graph.getAdjacencyList().get(to);
		
	}
	
	void setGraphVertexDegree(Graph graph)
	{
		for(int i= 0; i<graph.getSize(); i++)
		{
			int degree = graph.getAdjacencyList().get(i).size();
			graph.getVertexDegreeCount()[degree]++;
		}
	}
	
	/*void setVertexDegree(Graph graph, int vertex)
	{
		int degree = graph.getAdjacencyList().get(vertex).size();
		graph.getVertexDegreeCount()[degree]++;
	}*/
	void setNumberOfEdges(Graph graph)
	{
		setGraphVertexDegree(graph);
		long edges = 0;
		for(int i= 0; i< graph.getVertexDegreeCount().length; i++)
		{
			long vertexDegree = graph.getVertexDegreeCount()[i];
			edges = edges + (i*vertexDegree);
			
		}
		System.out.println("Edges:" + edges);
		
		graph.setEdgesCount(edges/2);
	}
}
