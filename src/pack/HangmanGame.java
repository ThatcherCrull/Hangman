package pack;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class HangmanGame {

	public static void main(String[] args) {
		File file = new File("dictionary.txt");
		ArrayList<String> words = new ArrayList<>();
		
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				words.add(line);
			}
			scan.close();
			
			Scanner input = new Scanner(System.in);
			System.out.print("What is the longest word you want to play with? ");
			int l = input.nextInt();
			while ((l <= 0 || l >= 29)) {
				System.out.println("Invalid length");
				System.out.print("What is the longest word you want to play with? ");
				l = input.nextInt();
			}
			
			Random random = new Random();
			ArrayList<String> lwords = new ArrayList<>();
			
			for (int i = 0; i < words.size(); i++) {
				if ((words.get(i).length()) == l) {
					lwords.add(words.get(i));
				}
			}
			
			int r = random.nextInt(lwords.size());
			String word = lwords.get(r);
			
			System.out.print("How many guess do you want? ");
			int max = input.nextInt();
			int guess_num = 1;
			char[] letters = word.toCharArray();
			char[] reveal = new char[l];
			for (int i = 0; i < reveal.length; i++) {
				reveal[i] = '-';
			}
			
			while (guess_num <= max) {
				System.out.println("You are on guess "+guess_num+" out of "+max);
				System.out.print("What letter do you want? ");
				String guess = input.next();
				for (int i = 0; i < letters.length; i++) {
					if (letters[i] == guess.charAt(0)) {
						reveal[i] = (guess.toUpperCase()).charAt(0);
					}
				}
				for (int i = 0; i < reveal.length; i++) {
					System.out.print(reveal[i]);
				}
				System.out.println("\n");
				guess_num++;
			}
			input.close();
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
            e.printStackTrace();
		}
		

	}

}
