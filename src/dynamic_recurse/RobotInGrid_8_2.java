package dynamic_recurse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RobotInGrid_8_2 {
	private static class Location{
		int r;
		int c;
		Location parent;
		Location(int r, int c, Location parent){
			this.r = r;
			this.c = c;
			this.parent = parent;
		}
		
		// Mistake: Must implement for equality in hashset
		public boolean equals(Object l_o){
		 if(!(l_o instanceof Location)){
		       return false;
		  }
		
		 Location l = (Location) l_o;
		 
		 if(l.r == r && l.c == c ){
			 return true;
		 }
			
			return false;
		}
		
		
	}
	
	private static List<Location> findPath(int a[][]){
		if(a == null || a.length == 0 || a[0].length == 0){
			return null;
		}
		
		int r = a.length;
		int c = a[0].length;
		
		boolean visited[][] = new boolean[r][c]; // Mistake -> Initialized as int array
		List <Location> path = new ArrayList<Location>();
		List <Location> bfs = new ArrayList<Location>();
		int i = 0 ; 
		bfs.add(new Location(0,0,null));
		visited[0][0] = true;
		boolean pathFound = false;
		
		while(i < bfs.size()){
			Location l = bfs.get(i);
			// Move right 
			if( (l.c + 1 < c) && (a[l.r][l.c + 1] == 1) && visited[l.r][l.c + 1] == false){
				Location l_r = new Location(l.r,l.c+1,l);
				bfs.add(l_r);
				if(l_r.r == r-1 && l_r.c == c-1){
					pathFound = true;
					break;
				}
				visited[l.r][l.c + 1] = true;
			}
			// Move down
			if( (l.r + 1 < r) && (a[l.r + 1] [l.c] == 1) && visited[l.r + 1][l.c] == false){
				Location l_d = new Location(l.r+1 ,l.c , l);
				bfs.add(l_d);
				if(l_d.r == r-1 && l_d.c == c-1){
					pathFound = true;
					break;
				}
				visited[l.r + 1][l.c] = true;
			}
			i++; // Mistake: Forgot to increment 
		}
		
		if(!pathFound){
			return null;
		}
		
		Location node = bfs.get(bfs.size()-1);
		
		while(node != null){
			path.add(node);
			node = node.parent;
		}
		
		return path;
	}
	
	
	
	
	static boolean recurseFindPath(int a[][], Location l, List <Location> path, boolean visited[][]){
		
		if(l.r == 0 && l.c == 0){
			// We are at origin
			return true;
		}
		
		if(visited[l.r][l.c]){
			// Do not recurse again a visited node
			return false;
		}
		
		visited[l.r][l.c]= true; 
		
		boolean foundRoute = false;
		
		if(l.c - 1 >= 0 && a[l.r][l.c-1] == 1){
			Location l_c = new Location(l.r, l.c-1,null);
			boolean leadToSource = recurseFindPath(a,l_c,path,visited);
			if(leadToSource){
				path.add(l_c);
				foundRoute = true;
				return true; 
				// If we found the path no need to explore any other route, just return from here
			}
			
			// If we did not found the path, we need to explore other route, we will not return from here 
		}
		
		if(l.r -1 >= 0 && a[l.r-1][l.c] == 1){
			Location l_r = new Location(l.r-1,l.c,null);
			boolean leadToSource = recurseFindPath(a,l_r,path,visited);
			if(leadToSource){
				path.add(l_r);
				foundRoute = true;
				return true;
				// If we found the path no need to explore any other route, just return from here
			}
		}
		
		return foundRoute;
	}
	
	
	
	
	public static void main(String args[]){
		int a [][] = new int[][]{ 		 
				 {1,1,1,0},
				 {0,0,1,0},
				 {0,1,1,1},
				 {1,1,1,1},
				 };
		
		List <Location> path = findPath(a);
		
		for (Location l : path) {
			System.out.println(l.r +"   "+ l.c);
		}
		
		System.out.println("--------------------");
		
		path = new ArrayList<Location>();
		
		int r = a.length;
		int c = a[0].length;
		
		recurseFindPath(a,new Location(r-1,c-1,null),path,new boolean[r][c]);
		
		for (Location l : path) {
			System.out.println(l.r +"   "+ l.c);
		}
		
		/*
		 {1100},
		 {0100},
		 {0110},
		 {0011},
		 */
		/*
		 {1,1,1,0},
		 {0,0,1,0},
		 {0,1,1,1},
		 {1,1,1,1},
		*/
	}
	
}
