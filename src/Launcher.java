import java.util.Scanner;
import static java.lang.Integer.parseInt;
import java.nio.file.*;

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
			else if (inpt.equals("freq")){
				System.out.print("Text file path: ");
				inpt = scn.nextLine();
				String[] ret = frequency(inpt);
				System.out.print("Most 3 frequent words:\n");
				for (int i = 0; i<3; i++){
					System.out.print(ret[i]+" ");
				}
				System.out.print("\n");
			}
			else if (inpt.equals("fibo")){
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

	private static String[] frequency(String path){
		try {
			String line = Files.readString(Paths.get(path));
			line = line.replaceAll("\\p{Punct}  "," ");
			//System.out.print("File content: "+line+"\n");
			
			String[] words = line.split(" ");
			if (words.length <3){
				return new String[1];
			}
			String[] tmp = new String[words.length];
			int[] histo = new int[words.length];
			int index = 0;
			for (int i = 0; i<words.length; i++){
				//System.out.print("words[i]: "+words[i]+"\ntmp[0]: "+tmp[0]+"\n");
				if(!_in(words[i], tmp)){
					histo[index] = 1;
					tmp[index] = words[i];
					index++;
					System.out.print(words[i]+" ");
				}
				else {
					for (int j = 0; j < tmp.length; j++){
						if(words[i].equals(tmp[j])){
							histo[j]++;
						}
					}
				}
			}
			int a = 0;
			int b = 1;
			int c = 2;

			for (int i = 0; i<index; i++){
				System.out.print(tmp[i]+"\n");
				if (histo[i]>histo[c] && tmp[i]!=" "){
					System.out.print("\n");
					if (histo[i]>histo[b]){
						if(histo[i]>histo[a]){
							c = b;
							b = a;
							a = i;
						}
						else{
							c = b;
							b = i;
						}
					}
					else{
						c = i;
					}
				}
				System.out.print("trio: "+tmp[a]+", "+tmp[b]+", "+tmp[c]+"\n");
			}
			System.out.print("\n");
			System.out.print("Yo");
			String[] stuff = {tmp[a], tmp[b], tmp[c]};
			return stuff;
		}
		catch (Exception e){
			System.out.print("Unreadable file: "+path+"\n"+e+"\n");
		}
		return new String[]{"test"};
	}

	private static boolean _in(String clt, String[] clts){
		String elt;
		for(int i = 0; i<clts.length; i++){
			if (clts[i] == null){
				return (false);
			}
			elt = clts[i];
			if (elt.equals(clt)){
				return (true);
			}
		}
		return (false);
	}
}
