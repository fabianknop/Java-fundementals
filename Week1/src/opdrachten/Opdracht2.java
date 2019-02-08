package opdrachten;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Opdracht2 {

	public static void main(String[] args) {
		welcome();
		readFriends();
	}
	
	private static void welcome(){
		System.out.println("Naam pls: ");
		Scanner scanner = new Scanner(System.in); 
		String name = scanner.nextLine();
		scanner.close();
		if(name.equals("Willem")){
			System.out.println("Goeiedagschotel: " + name);
		} else System.out.println("Welkom " + name);
	}
	
	private static void readFriends(){
		String pathFormat = "../tekstbestanden/";
		try {
			Scanner scanner = new Scanner(new File("../tekstbestanden/friends.txt"));
			while(scanner.hasNextLine()){
				String name = scanner.nextLine();
				System.out.println(name);
				String path = pathFormat + name + ".txt";
				File f = new File(path);
				try {
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
