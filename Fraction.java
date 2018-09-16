
import java.util.Scanner;

public class Fraction {

	private int denom;
	private int number;
	
	public Fraction() {
		
		denom = 10;
		number = 3;
		simplify();
		reduce();
		
	}
	
	public Fraction(int setNumber, int setDenom) {
		
		denom = setDenom;
		number = setNumber;
		
		try {
			
			@SuppressWarnings("unused")
			double x = number / denom;
			
		} catch (ArithmeticException e) {
			
			System.out.println(e.getMessage());
			//e.printStackTrace();
			denom = 1;
			
		}
		
		simplify();
		reduce();
		
	}

	public int getDenom() {
		
		return denom;
		
	}
	
	public int getNumber() {
		
		return number;
		
	}
	public String toString() {
		
		if (denom  > 1)
			return "Fraction: " + number + "/" + denom;
		
		else
			return "Fraction: " + number;
		
	}
	
	public double getValue() {
		
		return  ((double)number) / denom;
		
	}
	
	// checks for – in denominator
	private void simplify() {
		
		if(denom < 0) {
			
			denom*= -1;
			number*= -1;
			
		}
		
	}
	
	// divides by gcf
	private void reduce() {
		
		int gcf = 0, num = Math.abs(number);
		
		if (num > 0) {
			
			for(int i = 1; i <= Math.min(num, denom); i++) {
				
				if (num % i == 0 && denom % i == 0)
					gcf = i;
				
			}
			
			number /= gcf;
			denom /= gcf;
			
		}
	}
	
	public static Fraction add (Fraction one, Fraction two) {
		
		int de, nam;
		Fraction three = new Fraction();
		
		if (one.getDenom() == two.getDenom()) {
			
			de = one.getDenom() + two.getDenom();
			nam = one.getNumber() + two.getNumber();
			three = new Fraction (nam, de);
			
		}
		
		else {
			
			de = one.getDenom() * two.getDenom();
			nam = (one.getNumber()*two.getDenom()) + (two.getNumber()*one.getDenom());
			three = new Fraction (nam, de);
			
		}
		
		three.reduce();
		three.simplify();
		
		return three;
		
	}
	
	public static Fraction subtract (Fraction one, Fraction two) {
		
		int de, nam;
		Fraction three = new Fraction ();
		
		if (one.getDenom() == two.getDenom()) {
			
			de = one.getDenom() - two.getDenom();
			nam = one.getNumber() - two.getNumber();
			three = new Fraction (nam, de);
			
		}
		
		else {
			
			de = one.getDenom() * two.getDenom();
			nam = (one.getNumber()*two.getDenom()) - (two.getNumber()*one.getDenom());
			three = new Fraction (nam, de);
			
		}
		
		three.reduce();
		three.simplify();
		
		return three;
		
	}
	
	public static Fraction multiply (Fraction one, Fraction two) {
		
		Fraction three = new Fraction (one.getNumber() * two.getNumber(), one.getDenom() * two.getDenom());
		
		return three;
		
	}
	
	public static Fraction divide (Fraction one, Fraction two) {
		
		return multiply(one, two.getReciprocal());
		
	}
	
	public Fraction getReciprocal() {
		
		Fraction recip = new Fraction(denom, number);
		
		return recip;
		
	}


	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner fraction = new Scanner (System.in);
		
		int num, denum;
		boolean b;
		String sign;
		
		System.out.println("Hello!");
		
		System.out.println("What is your numerator?");
		num = fraction.nextInt();
		
		System.out.println("What is your denumerator?");
		denum = fraction.nextInt();
		
		Fraction alpha = new Fraction(num, denum);
		
		System.out.println(alpha);
		
		System.out.println("Do you have a second fraction? (true of false)");
		b = fraction.nextBoolean();
		
		System.out.println("What is your numerator?");
		num = fraction.nextInt();
		
		System.out.println("What is your denumerator?");
		denum = fraction.nextInt();
		
		Fraction beta = new Fraction(num, denum);
		
		if(b) {
			
			System.out.println("What would you like to do with the fractions? (+, -, *, /)");
			 sign = fraction.next();
			 
			 if (sign.equals("+"))
				 System.out.println(add(alpha, beta));
			 else if (sign.equals("-"))
				 System.out.println(subtract(alpha, beta));
			 else if (sign.equals("*"))
				 System.out.println(multiply(alpha, beta));
			 else if (sign.equals("/"))
				 System.out.println(divide(alpha, beta));
			 
		}
		
		else
			System.out.println("Bye.");
		
		/*Fraction one = new Fraction(5, 2);
		System.out.println(one);
		Fraction two = new Fraction(-2, 4);
		System.out.println(two);
		System.out.println(multiply(one, two));
		System.out.println(divide(one, two));
		System.out.println(one.getValue());*/
		
	}

}


