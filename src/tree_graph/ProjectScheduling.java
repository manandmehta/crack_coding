package tree_graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author mdmehta
 * 4.7 Project Order 
 * Given a list of projects and its dependencies find out in what order should be build the project
 * Also return error if no such order exist
 *
 */
public class ProjectScheduling {
	private static class Edge{
		String v1;
		String v2;
		
		private Edge(String v1, String v2){
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	
	List <String> verticeList;
	// Vertices still in recursion tree
	Set <String> discovered; 
	// Vertices we processed in recursion tree
	Set <String> processed;
	
	boolean cycleExist = false;
	
	Map<String, LinkedList<Edge>> adjcList ;
	Map<String, String> parentMap;
	
	private ProjectScheduling(){
		discovered = new HashSet<String>();
		processed = new HashSet<String>();
		adjcList = new HashMap <String,LinkedList<Edge>>();
		parentMap = new HashMap<String, String>();
	}
	
	private void initialize(List<String> verticeList, List <Edge> edgeList ){
		this.verticeList = verticeList;
		
		// Prepare adjacency list 
		for(Edge e : edgeList){
			LinkedList <Edge> l;
			if(adjcList.containsKey(e.v1)){
				l = adjcList.get(e.v1);
			}else{
				l = new LinkedList<Edge>();
				adjcList.put(e.v1, l);
			}
			l.add(e);
		}
		
		for(String v : verticeList){
			parentMap.put(v, null);
		}
	}
	
	private void scheduleProject(){
		
		// perform DFS search and find if there are any cycles in directed graph
		for (String v : verticeList) {
			if(processed.contains(v) == false && cycleExist == false){
				dfs(v);
			}
		}
		
		if(cycleExist){
			System.out.println("Project Cannot be Executed due to cycle");
		}else{
			
			/*
			 If no cycle exist we will call bfs from the roots of dfs trees to print out build order
			 * */
			
			// Clear out structure that we will reuse for bfs now
			discovered.clear();			
			for(String keyVertice : parentMap.keySet()){
				
				// Vertex whose parent is null is one of the root of DFS tree
				if(parentMap.get(keyVertice) == null){
					bfs(keyVertice);
				}
			}
		}		
	}
	
	
	private void bfs(String v){                                                     
		Queue <String> bfsqueue = new ArrayDeque <String>();
		
		bfsqueue.add(v);
		discovered.add(v);
		
		while(bfsqueue.isEmpty() == false){
			v = bfsqueue.remove();
			
			System.out.print(" " + v);
			
			LinkedList<Edge> edgeList= adjcList.get(v);
			if(edgeList != null){
				for(Edge edge: edgeList){
					if(discovered.contains(edge.v2) == false){
						bfsqueue.add(edge.v2);
						discovered.add(edge.v2);
					}
				}
			}
		} 
		
	}
	
	
	private void dfs(String v){
		
		// Mark the vertice as discovered
		discovered.add(v);
		
		LinkedList <Edge> edgeList = adjcList.get(v);
		if(edgeList != null){
			for(Edge e : edgeList){
				String v2 = e.v2;
				
				if(processed.contains(v2)){
					
					/* Consider the case a-> b -> c
					 * If dfs would have started as b, the parent of b would be null
					 * When we notice edge a->b we modify the parent b that a could be b's parent if it is null
					*/
					if(parentMap.get(v2) == null){
						parentMap.put(v2, v);
					}
					
					// We have already processed this vertex
					continue;
				}
				
				// Vertex v2 has been see before in this recursion tree 
				if(discovered.contains(v2)){
					System.out.println("CYCLE");
					cycleExist = true;
					printCycle(v, v2);
					return;
				}
				
				parentMap.put(v2, v);
				
				dfs(v2);
			}
		}
		// Remove vertice from discovered and move to processed list
		discovered.remove(v);
		processed.add(v);
	}
	
	private void printCycle(String vertex, String cycleStart){
		if(vertex.equals(cycleStart)){
			System.out.println(cycleStart);
			return;
		}
		
		String parent = parentMap.get(vertex);
		printCycle(parent, cycleStart);
		System.out.print(vertex + " ");
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    int v_num = scanner.nextInt(); // Number of vertices
	    int e_num = scanner.nextInt(); // Number of edges
	    
	    List <String> verticeList = new ArrayList <String>();
	    List <Edge> edgeList = new ArrayList<Edge>();
	    
	    for(int i = 0 ; i < v_num ; i++){
	    	verticeList.add(scanner.next());
	    }
	    
	    for(int i = 0 ; i < e_num ; i++){
	    	String v1 = scanner.next(); 
	    	String v2 = scanner.next();
	    	edgeList.add(new Edge(v1,v2));
	    }
	    
	    ProjectScheduling ps = new ProjectScheduling();
	    ps.initialize(verticeList, edgeList);
	    ps.scheduleProject();
	    System.out.println();
	 }
}

/*
6 5
a b c d e f 
a d
f b
b d
f a 
d c

 * */
