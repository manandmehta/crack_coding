package moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnglishInt_16_8 {

	static Map<String, String> twoDigitmap = new HashMap<String, String>();
	static Map<String, String> levelTwoName = new HashMap<String, String>();
	static Map<String, String> levelName = new HashMap<String, String>();

	static{
		twoDigitmap.put("0", "Zero");
		twoDigitmap.put("1", "One");
		twoDigitmap.put("2", "Two");
		twoDigitmap.put("3", "Three");
		twoDigitmap.put("4", "Four");
		twoDigitmap.put("5", "Five");
		twoDigitmap.put("6", "Six");
		twoDigitmap.put("7", "Seven");
		twoDigitmap.put("8", "Eight");
		twoDigitmap.put("9", "Nine");
		twoDigitmap.put("10", "Ten");
		twoDigitmap.put("11", "Eleven");
		twoDigitmap.put("12", "Twelve");
		twoDigitmap.put("13", "Thirteen");
		twoDigitmap.put("14", "Fourteen");
		twoDigitmap.put("15", "Fifteen");
		twoDigitmap.put("16", "Sixteen");
		twoDigitmap.put("17", "Seventeen");
		twoDigitmap.put("18", "eighteen");
		twoDigitmap.put("19", "Nineteen");

		levelTwoName.put("2", "twenty");
		levelTwoName.put("3", "Thirty");
		levelTwoName.put("4", "Fourty");
		levelTwoName.put("5", "Fifty");
		levelTwoName.put("6", "Sixty");
		levelTwoName.put("7", "Seventy");
		levelTwoName.put("8", "Eighty");
		levelTwoName.put("9", "Ninety");

		levelName.put("3", "Hundred");
		levelName.put("4", "Thousand");
	}

	List<String> parseDigits(int number) {
		List<String> parseDigit = new ArrayList<String>();
		if (number == 0) {
			parseDigit.add("0");
		}

		while (number != 0) {
			int digit = number % 10;
			number = number / 10;
			parseDigit.add(String.valueOf(digit));
		}

		return parseDigit;
	}

	private static String buildThreeDigits(int level, int index, List<String> digit) {
		String number = "";
		if(index <= digit.size()-1){
			String firstDigit = buildSingleDigit(index, digit);
			if (firstDigit.trim().isEmpty() == false) {
				number = firstDigit +" "+ levelName.get(String.valueOf(level));
			}
		}
		String val = number +" "+ buildLastTwoDigits(--index, digit);
		return val;
	}

	private static String buildLastTwoDigits(int index, List<String> digit) {
		String secondDigitText = "";
		int firstDigitIndex = index-1;
		
		if(index <= digit.size() -1 ){
			String str_secondDigit = digit.get(index);
			int secondDigit = Integer.parseInt(str_secondDigit);
			secondDigitText = levelTwoName.get(str_secondDigit);
	
			if (secondDigit == 0) {
				return buildSingleDigit(firstDigitIndex, digit);
			}
	
			String firstDigit = digit.get(firstDigitIndex);
	
			if (secondDigit < 2) {
				return twoDigitmap.get(secondDigit + firstDigit);
			}
		}
		String val =  secondDigitText+ " " + buildSingleDigit(firstDigitIndex, digit);
		return val;

	}

	private static String buildSingleDigit(int index, List<String> digit) {
		String str_digit = digit.get(index);
		int d = Integer.parseInt(str_digit);

		if (d == 0) {
			return " ";
		}

		return " " + twoDigitmap.get(str_digit);
	}

	private static String buildNumber(List<String> digit) {

		digit = new ArrayList<String>();
		digit.add("7");
		digit.add("5");
		digit.add("1");
		digit.add("1");

		StringBuilder sb = new StringBuilder();

		int index = 2;
		int level = 3;
		int i = 0 ;
		while(i  <= digit.size() ){
			sb.append(buildThreeDigits(level, index, digit));
			i = index;
			index+=3;
			level++;
		}
		
		System.out.println(sb.toString());

		return "";
	}

	public static void main(String[] args) {
		buildNumber(null);
	}
}
