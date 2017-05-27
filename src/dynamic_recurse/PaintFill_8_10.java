package dynamic_recurse;

public class PaintFill_8_10 {

	static int count;
	
	private static void colorMe(int r, int c, int color, int a[][]){
		if(a == null || a.length == 0){
			return;
		}
		
		a[r][c] = color;
		count ++;
		
		// Mistake: There is no need for separate visited boolean array, we can just rely on color
		// We may need it if some pixels are already of that color
		
		// Go in all four direction if not already visited node
		if(r-1 >= 0 && a[r-1][c] != color){
			colorMe(r-1,c,color,a);
		}
		if(r+1 < a.length && a[r+1][c] != color){
			colorMe(r+1,c,color,a);
		}
		if(c-1 >= 0 && a[r][c-1] != color){
			colorMe(r,c-1,color,a);
		}
		if(c+1 < a[r].length && a[r][c+1] != color){
			colorMe(r,c+1,color,a);
		}
	}
	
	public static void main(String[] args) {
		int a[][] = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		boolean visited[][] = new boolean[a.length][a[0].length];
		
		colorMe(2,2,8,a);
		
		for(int row[] : a){
			for(int c: row){
				System.out.print(c + " ");
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		System.out.println(count);
		
	}
}
