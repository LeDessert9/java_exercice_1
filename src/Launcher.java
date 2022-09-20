import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Launcher{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String inpt = "lulz";
		while(!inpt.equals("quit")){
			System.out.print("Command unknown soon -->>> ");
			inpt = scn.nextLine();
			if (inpt.equals("quit")){
				scn.close();
			}
			if (inpt.equals("fibo")){
				System.out.print("Fibo index: ");
				inpt = scn.nextLine();
				try{
					System.out.print("Fibonacci("+inpt+"): "+Fibo(Integer.parseInt(inpt))+"\n");
				}
				catch(IllegalArgumentException e){
					System.out.print("Invalid argument: Fibo function requires an integer.\n");
				}
			}
			else{
				System.out.println("Unknown command");
			}
		}
	}

	private static int Fibo(int n){
		if (n <= 1){
			return n;
		}
		return (Fibo(n-1)+Fibo(n-2));
	}
}
