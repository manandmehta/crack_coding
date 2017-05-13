package bit_manip;


/**
 * https://www.quora.com/What-is-the-binary-representation-of-0-75
 * @author mdmehta
 *
 */
public class printBinary_5_2 {

	private static String printBinary(double num){
		if(num >= 1 || num <= 0){
			return "ERROR";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		
		while(num > 0){
			/*to till max 32*/
			if(sb.length() >= 32){
				return "ERROR Too Long";
			}
			
			double r = num * 2;
			
			if(r >=1){
				sb.append(1);
				num = r - 1;
			}else{
				sb.append(0);
				num = r;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(printBinary(0.75));
		System.out.println(printBinary(0.125));
	}
}
