package dynamic_recurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes_8_13 {
	
	public static void main(String[] args) {
		ArrayList <Box> boxes= new ArrayList<Box>();
		boxes.add(new Box(5,4,4)); // 0
		boxes.add(new Box(6,4,4)); // 1
		boxes.add(new Box(4,3,11)); //2
		boxes.add(new Box(4,3,2)); //3
		boxes.add(new Box(2,2,1)); //4 
		boxes.add(new Box(1,2,1)); //5
		
		System.out.println(maxBoxHeight(boxes));
	}
	
	private static int maxBoxHeight(ArrayList<Box> boxStack){
		
		// Sort by any of the h w l dimension
		Collections.sort(boxStack, new BoxComparator());
		int maxLength[] = new int[boxStack.size()];
		int stackDirection[] = new int[boxStack.size()];
		
		for(int i= 0; i < boxStack.size() ; i ++){
			// By default each box is as tall as itself
			maxLength[i] = boxStack.get(i).h;
			// By default each box is stacked on no one
			stackDirection[i] = -1;
		}
		
		
		for(int i= 1; i < boxStack.size() ; i ++){
			
			Box small = boxStack.get(i);
			
			for(int j = 0 ; j < i ; j++){
				// We will try to place small box i to all possible bigger boxes j
				Box big = boxStack.get(j);
				
				if(big.d > small.d && big.w > small.w && big.h > small.h){
					// Bigger box is bigger in all dimensions
					if(maxLength[i] < maxLength[j] + small.h){
						maxLength[i] = maxLength[j] + small.h;
						stackDirection[i] = j;
					}
				}
			}
		}
		
		int max = 0;
		int index = 0 ; 
		for(int i= 0 ; i < maxLength.length; i++ ){
			if(max < maxLength[i]){
				max = maxLength[i];
				index = i;
			}
		}
		
		while(index != -1){
			System.out.println("Box " + index + " is placed");
			index = stackDirection[index];
		}
		
		
		return 0;
	}
	
	private static class Box{
		int h;
		int w;
		int d;
		
		public Box(int h, int w, int d){
			this.h = h;
			this.w = w;
			this.d = d;
		}
	}
	
	private static class BoxComparator implements Comparator<Box>{

		@Override
		public int compare(Box b1, Box b2) {
			/**
			 * Return   0  : If both b1 and b2 are same
			 * Return > 0  : If first argument is greater than second. (Here it is opposite way so it will give descending sorting order)
			 * Return < 0  : If first argument is less than second argument. 
			 */
			return b2.w - b1.w;
		}
	}

}
