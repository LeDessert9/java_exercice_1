import java.util.Scanner;

public class Launcher{
	public static void main(String[] args){
		System.out.print("Command unknown soon -->>> ");
		Scanner scn = new java.util.Scanner(System.in);
		String inpt = scn.nextLine();
		if (inpt.equals("quit")){
			scn.close();
		}
		else{
			System.out.println("Unknown command");
		}
	}
}
