import java.util.Scanner;
 
public class TrueError{
	
public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Let us consider our equation is like below :" +
				"\nax^n + bx^n-1 + ...... + z");
		
		System.out.println("\nEnter n value :");
		int n = Integer.parseInt(scan.nextLine());
		int temp = n;
		float num[] = new float[n+1];
		
		for(int i=0; i<=n; i++) {
			
			System.out.println("Enter the Co-efficient of x^" + (temp-i) + " :");
			num[i] = Float.parseFloat(scan.nextLine());
		}
		
		System.out.println("Enter x value :");
		float xValue = Float.parseFloat(scan.nextLine());
		
		for(int i=0; i<n; i++) {
			
			String str = (temp-i) * num[i] + " x^" + (temp-i-1);
			System.out.println(str);
		}
		
		System.out.println(xValue);
		
		float trueValue=0;
		
		for(int i=0; i<n; i++) {
			
			String str = (temp-i) * num[i] + " x^" + (temp-i-1);
			System.out.println(str);
			
			trueValue = trueValue + (float) ((Math.pow((float)xValue, (int)(temp-i-1))) * ((temp-i) * num[i]));
		}
		
		System.out.println("True Value:");
		System.out.println(trueValue);
		
		System.out.println("\nDifferentiation Calculus");
		System.out.println("Enter h value :");
		float hValue = Float.parseFloat(scan.nextLine());
		System.out.println(hValue);
		float xPlushValue = xValue + hValue;
		float fOne=0, fTwo=0;
		
		for(int i=0; i<n; i++) {
			
			fOne = fOne + (float) ((Math.pow((float)xPlushValue, (int)(temp-i))) * (num[i]));
			fTwo = fTwo + (float) ((Math.pow((float)xValue, (int)(temp-i))) * (num[i]));
		}
		
		float approxValue = (fOne - fTwo) / hValue;
		System.out.println("Approximate Value:");
		System.out.println(fOne +"-"+fTwo+"/"+hValue+"= "+ approxValue);
		
		float trueErrorResult = trueValue - approxValue;
		System.out.println("True Error Result:");
		System.out.println(trueValue+"-" +approxValue +"="+ trueErrorResult);
		
		float relativeTrueErrorResult = trueErrorResult/approxValue;
		System.out.println("Relative True Error Result:");
		System.out.println(trueErrorResult+"/"+approxValue+"= "+relativeTrueErrorResult);
		
	}
}