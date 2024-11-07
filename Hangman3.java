import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman3 {
    public static void main(String[] args) throws FileNotFoundException {

        List<String> words = new ArrayList<>();

        Scanner scanner = new Scanner(new File("C:\\Users\\jmleg\\OneDrive\\Desktop\\Game-Development\\words_alpha.txt"));
        Scanner keyboard = new Scanner(System.in);
        
        while(scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();
        // overthinly
        // ---------- kjgikugi

        while(true) { 
            printWordState(word, playerGuesses);
            getPlayerGuess(keyboard, playerGuesses, word);
            if(printWordState(word, playerGuesses)) {
                System.out.println("You Win!");
                break;
            }

            System.err.println("Please enter your guess for the word: ");
            if(keyboard.nextLine().equals(word)) {
                System.out.println("You Win!");
                break;
            }

            else {
                System.out.println("No! Try Again!");
            }
        }

        //printWordState(word, playerGuesses);

        //getPlayerGuess(keyboard, playerGuesses, word);

        // "A" -> 'A'
        // String str = "A"
        // str.chatAt(0) -> "A" -> 'A'
    
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {

        int correctCount = 0;
        for(int i =0;i<word.length();i++) {
            if(playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));

            }

            //random comment - juan miguel legaspi

            else {
                System.out.print("-");
            }
            
        }

        System.out.println();

        return word.length()==correctCount;

    }

    private static void getPlayerGuess(Scanner keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Please enter a letter");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        // printWordState(word, playerGuesses);

    }

    }



