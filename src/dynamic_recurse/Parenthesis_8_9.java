package dynamic_recurse;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis_8_9 {
	
	private static List<String> findParenthesis(int n){
		if(n == 0){
			return null; // No combination possible
		}
		if(n == 1){
			List<String> p_p = new ArrayList<String>();
			p_p.add("()");
			return p_p;
		}
		
		List<String> p_p = new ArrayList<String>();
		List<String> p_p_s = findParenthesis(n-1);
		
		// Append parenthesis around all elements of previous combination
		for(String s: p_p_s){
			p_p.add("(" + s + ")");
		}
		
		// For n-1 elements, append () to front and back. 
		for(int i = 0; i < p_p_s.size() -1 ; i++){
			p_p.add("()" + p_p_s.get(i));
			p_p.add(p_p_s.get(i) + "()");
		}
		
		// The n the element is all size 1 parenthesis e.g. ()()
		// We need to append () to either front or back
		
		p_p.add("()" + p_p_s.get(p_p_s.size() - 1));
		return p_p;
	}
	
	public static void main(String []args){
		List <String> findParen =  findParenthesis(4);
		System.out.println(findParen);
	}
}
