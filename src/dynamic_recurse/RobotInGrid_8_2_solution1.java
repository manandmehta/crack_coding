package dynamic_recurse;

import java.util.ArrayList;
import java.util.List;

public class RobotInGrid_8_2_solution1 {
	private static class Location{
		int r;
		int c;
		Location parent;
		Location(int r, int c, Location parent){
			this.r = r;
			this.c = c;
			this.parent = parent;
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
	
	public static void main(String args[]){
		int a [][] = new int[][]{ 		 
				 {1,1,0,0},
				 {0,1,0,0},
				 {0,1,1,0},
				 {0,0,1,1},};
		
		List <Location> path = findPath(a);
		
		for (Location l : path) {
			System.out.println(l.r +"   "+ l.c);
		}
		
		
		/*
		 {1100},
		 {0100},
		 {0110},
		 {0011},
		 */
	}
	
}
