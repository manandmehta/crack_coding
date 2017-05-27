package dynamic_recurse;

import java.util.ArrayList;
import java.util.List;

public class PowerSet_8_4 {
	/**
	 * Refer to the approach provided by book. It is a lot simpler than this approach.
	 * @param a
	 * @return
	 */
	private static List<ArrayList<String>> findAllSubsets(String a[]){
		List<ArrayList<String>> permList = new ArrayList<ArrayList<String>>();
		
			int size = 1;
			while(size <= a.length){
				int start = 0 ;
				while (start + size - 1  < a.length){
					ArrayList <String> l1 = getRange(a,start, (start + (size-1)));
					int p = start + size - 1;
					
					if(p == start){
						permList.add(l1);
					}
					
					while (p < a.length && p != start){
						ArrayList <String>l2 = new ArrayList<String>(l1);
						l2.add(a[p]);
						p++;
						permList.add(l2);
					}	
					start++;
				}
				size++;
			}
			
			return permList;
		}
	
	
	
		private static ArrayList<String> getRange(String a[], int start, int end){
			ArrayList <String> l1 = new ArrayList<String>();
			if(start == end){
				l1.add(a[start]);
				return l1;
			}else{
				for(int i = start ; i < end ; i++){
					l1.add(a[i]);
				}
			}
			return l1;
		}
		
		public static void main(String[] args) {
			String a[] = new String[]{"a1","a2","a3","a4"};
			
			List<ArrayList<String>> powerSet = findAllSubsets(a);
			
			int index = 1;
			for (ArrayList<String> l : powerSet) {
				System.out.println();
				System.out.print(index + " {");
				for (String set_item : l) {
					System.out.print(set_item + " ");
				}
				System.out.print("}");
				index++;
			}
		}
}
