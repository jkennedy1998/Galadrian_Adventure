import java.util.Scanner;

import javax.swing.JOptionPane;

public class IO {
	public static int getInt(String s){
		int input;
		String in = JOptionPane.showInputDialog(s);
		input = Integer.parseInt(in);
		return input;
	}
	
	public static int getInt(){
		int input;
		String in = JOptionPane.showInputDialog("Please enter an integer");
		input = Integer.parseInt(in);
		return input;
	}
	
	public static double getDouble(String s){
		double input;
		String in = JOptionPane.showInputDialog(s);
		input = Double.parseDouble(in);
		return input;
	}
	
	public static double getDouble(){
		double input;
		String in = JOptionPane.showInputDialog("Please enter a Double");
		input = Double.parseDouble(in);
		return input;
	}
	
	public static boolean getBoolean(String s){
		boolean input;
		String in = JOptionPane.showInputDialog(s);
		input = Boolean.parseBoolean(in);
		return input;
	}
	
	public static boolean getBoolean(){
		boolean input;
		String in = JOptionPane.showInputDialog("Please enter a Boolean");
		input = Boolean.parseBoolean(in);
		return input;
	}
	
	public static String getString(String s){
		String input = JOptionPane.showInputDialog(s);
		return input;
	}
	
	public static String getString(){
		String input = JOptionPane.showInputDialog("Please enter a String");
		return input;
	}
	
	public static int getConsoleInt(String s){
		Scanner scan = new Scanner(System.in);
		System.out.print(s + ":");
		int input = scan.nextInt();
		return input;
	}
	
	public static int getConsoleInt(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter an Integer:");
		int input = scan.nextInt();
		return input;
	}
	
	public static double getConsoleDouble(String s){
		Scanner scan = new Scanner(System.in);
		System.out.print(s + ":");
		double input = scan.nextDouble();
		return input;
	}
	
	public static double getConsoleDouble(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a Double:");
		double input = scan.nextDouble();
		return input;
	}
	
	public static boolean getConsoleBoolean(String s){
		Scanner scan = new Scanner(System.in);
		System.out.print(s + ":");
		boolean input = scan.nextBoolean();
		return input;
	}
	
	public static boolean getConsoleBoolean(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a Boolean:");
		boolean input = scan.nextBoolean();
		return input;
	}
	
	public static String getConsoleString(String s){
		Scanner scan = new Scanner(System.in);
		System.out.print(s + ":");
		String input = scan.next();
		return input;
	}
	
	public static String getConsoleString(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a String:");
		String input = scan.next();
		return input;
	}
}
