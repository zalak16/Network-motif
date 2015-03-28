package com.randomGraph.edu;
import java.util.Random;


public class GenerateGraph
{
	AdjacencyList adjacencyList = new AdjacencyList();
	
	Graph generateRandomGraph(Graph target)
	{
		Graph randomGraph = new Graph(target.getSize());
		randomGraph = new Graph(target.getSize());
		generateRandomGraph(target, randomGraph);
		
		return randomGraph;
	}
	
	//this maintains number of edges and vertices of original graph
	void generateRandomGraph(Graph target, Graph randomGraph)
	{
		adjacencyList.createAdjacencyList(randomGraph);
		long countEdges = 0;
			
		while(countEdges < target.getEdgesCount())
		{
			int to = getRandomVertex(target.getSize());
			int from = getRandomVertex(target.getSize());
			
			if((to == from) || (checkEdgeExistence(randomGraph, to, from)))
			{
				continue;
			}
			else
			{
				adjacencyList.setEdges(randomGraph, to, from);
				countEdges++;
				//System.out.println(countEdges);
			}
		}
	
		adjacencyList.setNumberOfEdges(randomGraph);
		
	}
	
	
	boolean checkEdgeExistence(Graph graph, int to, int from)
	{
		return graph.getAdjacencyList().get(to).contains(from);
	}
	
	int getRandomVertex(int n)
	{
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		return random.nextInt(n);
	}
	
	
	int getVertexDegree(int v, Graph g)
	{
		return g.getAdjacencyList().get(v).size();
	}
}
