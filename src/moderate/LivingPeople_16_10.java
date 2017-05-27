package moderate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class LivingPeople_16_10 {

	private static class Person{
		int born;
		int death;
		public Person(int b, int d){
			born = b;
			death = d;
		}
	}
	
	private static class SortByBirth implements Comparator<Person>{
		public int compare(Person p1, Person p2) {
			return p1.born - p2.born;
		}
	}
	private static class SortByDeath implements Comparator<Person>{
		public int compare(Person p1, Person p2) {
			return p1.death - p2.death;
		}
	} 
	
	private static void maxAliveYear(List <Person> people){
		ArrayList <Person> byBirth = new ArrayList<Person>(people);
		ArrayList <Person> byDeath = new ArrayList<Person>(people);
		byBirth.sort(new SortByBirth());
		byDeath.sort(new SortByDeath());
		
		int indexBirth = 0, indexDeath = 0;
		int peopleAlive = 0;
		int maxAlivePeople = 0;
		int maxAliveYear = 0;
		
		while(indexBirth < people.size()){
			if(byBirth.get(indexBirth).born <= byDeath.get(indexDeath).death){
				// If a person was born and died in same year, we will still count as 1
				peopleAlive++;
				indexBirth++;
				if(peopleAlive > maxAlivePeople){
					maxAlivePeople = peopleAlive;
					maxAliveYear = byBirth.get(indexBirth-1).born; 
				}
			}else{
				peopleAlive --;
				indexDeath++;
			}
		}
		
		System.out.println(maxAlivePeople);
		System.out.println(maxAliveYear);
	}
	
	public static void main(String[] args) {
		List <Person> people = new ArrayList<Person>();
		people.add(new Person(12,15));
		people.add(new Person(20,90));
		people.add(new Person(10,98));
		people.add(new Person(1,72));
		people.add(new Person(10,98));
		people.add(new Person(23,82));
		people.add(new Person(13,98));
		people.add(new Person(90,98));
		people.add(new Person(83,99));
		people.add(new Person(75,94));
		
		maxAliveYear(people);
	}

}
