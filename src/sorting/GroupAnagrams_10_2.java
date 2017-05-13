package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_10_2 {

	//////////////////////////// Solution 1 ////////////////////////////
	static class AnagramComparator implements Comparator<String>{

		private String sortChar(String str){
			char[] charAry = str.toCharArray();
			Arrays.sort(charAry);
			return new String(charAry);
		}
		
		@Override
		public int compare(String str1, String str2) {
			return sortChar(str1).compareTo(sortChar(str2));
		}
	}
	
	//////////////////////////// Solution 2 ////////////////////////////

	private static String sortCharacters(String s){
		char charAry[] = s.toCharArray();
		Arrays.sort(charAry);
		return new String(charAry);
	}
	
	private static void sortAnagram(String strAry[]){
		Map<String, List<String>> mapList = new HashMap<String, List<String>> ();
		
		for (String str : strAry) {
			String key = sortCharacters(str);
			
			List<String> anaList;
			if(mapList.containsKey(key)){
				anaList = mapList.get(key);
			}else{
				anaList = new ArrayList<String>();
				mapList.put(key, anaList);
			}
			
			anaList.add(str);
		}
		
		for(String key : mapList.keySet()){
			List <String> list = mapList.get(key);
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	

	
	public static void main(String[] args) {
		String [] strAry1 = new String[]{"abc","def","bca","efd","cab","bcde","cdeb","abcd","dcab","bcad"};
		String [] strAry2 = new String[]{"abc","def","bca","efd","cab","bcde","cdeb","abcd","dcab","bcad"};
		
		// Solution 1
//		Arrays.sort(strAry1, new GroupAnagrams.AnagramComparator());
//		
//		for (String str : strAry1) {
//			System.out.println(str);
//		}

		
		// Solution 2
		sortAnagram(strAry2);
		
	}

}
