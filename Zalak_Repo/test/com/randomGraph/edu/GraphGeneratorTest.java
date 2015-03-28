package com.randomGraph.edu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cern.jet.random.engine.RandomGenerator;

public class GraphGeneratorTest
{
	Graph input = new Graph(13);
	AdjacencyList adj = new AdjacencyList();
	GenerateGraph randomG = new GenerateGraph();
	int totalRandomGraph = 10;
	String filePath = "C:\\Zalak\\CSS 595 Project\\GitHub\\Zalak_Repo\\Output";
	File dir = new File(filePath);
	ArrayList<Graph> randomGraphList = new ArrayList<Graph>();
	void print(Graph g, String filename)
	{
		//String filename =  "Input.txt";
		File file = new File(dir, filename);
	
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			StringBuilder sb = new  StringBuilder();
			for(int i= 0; i< g.getSize(); i++)
			{
				List<Integer> list = g.getAdjacencyList().get(i);
				sb.append("\n");
				sb.append(i + " : ");
				for(int j = 0; j <list.size(); j++)
				{
					sb.append(list.get(j) + " -> ");
					//System.out.print(lst.get(j) + " -> ");
				}
			}
			
			for(int i =0; i< g.getVertexDegreeCount().length; i++)
			{
				sb.append("\n");
				sb.append(i + " : ");
				sb.append(Integer.toString(g.getVertexDegreeCount()[i]));
			}
			
			sb.append("\n");
			sb.append("Edges: ");
			sb.append(Long.toString(g.getEdgesCount()));
			bw.append(sb.toString());
			bw.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		/*for(int i=0; i < g.getVertexDegreeCount().length; i++)
		{
			System.out.print("\n" +  i + " : " + g.getVertexDegreeCount()[i]);
		}*/
		
		//System.out.println("\n Edges: " + g.getEdgesCount());
	}
	
	public static void main(String args[]) throws IOException
	{
		
		GraphGeneratorTest obj = new GraphGeneratorTest();
		obj.adj.createAdjacencyList(obj.input);
		obj.adj.getAdjacencyListValues("inputGraph1.txt", obj.input);
		obj.adj.setNumberOfEdges(obj.input);
		obj.print(obj.input, "Input.txt");
		
		System.out.println("\n-------------------------------------------------------------\n");
		long startTime = System.currentTimeMillis();
		
		for(int i= 0; i< obj.totalRandomGraph; i++)
		{
			Graph random = obj.randomG.generateRandomGraph(obj.input);
			obj.randomGraphList.add(random);

		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		for(int i= 0; i< obj.randomGraphList.size(); i++)
		{
			obj.print(obj.randomGraphList.get(i), ("Output" + i + ".txt"));			
		}
		
	}
}
