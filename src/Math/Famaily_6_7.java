package Math;

import java.util.Random;

public class Famaily_6_7 {

	private static double familySimulation(int n){
		int boys = 0 ; 
		int girls = 0 ;
		
		for(int i = 0 ; i < n ; i ++){
			boys += randomBirthSimulation();
			girls++; // For each family exactly one girl is born
		}
		
		System.out.println("Boys Born:> " +boys);
		System.out.println("Girls Born:> " +boys);
		
		return girls / (double) boys+girls;
	} 
	
	
	/**
	 * How many boys were born before a girl was born
	 * @return
	 */
	private static int randomBirthSimulation(){
		
		Random random = new Random();
		
		boolean girlBorn = false;
		int countBoys = 0 ;
		while(girlBorn == false){
			girlBorn = random.nextBoolean();
			if(girlBorn == false){
				countBoys++;
			}
		}
		
		return countBoys;
	} 
	
	public static void main(String[] args) {
		System.out.println(familySimulation(100));
	}
}
