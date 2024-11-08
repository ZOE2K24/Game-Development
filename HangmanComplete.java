import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanComplete {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner keyboard = new Scanner(System.in);

        String word;

        // I moved scanner keyboard and string word up here, calling out the functions below

        System.out.println("How many players? 1 or 2");
        String players = keyboard.nextLine();

        if (players.equals("1")) {


        List<String> words = new ArrayList<>();

        Scanner scanner = new Scanner(new File("C:\\Users\\jmleg\\OneDrive\\Desktop\\Game-Development\\words_alpha.txt"));
        
        
        while(scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();

        word = words.get(rand.nextInt(words.size()));

        }

        else { // 2-player mode
            System.out.println("Player 1, please enter your word: ");
            word = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // lots of line break to hide the word
            System.out.println("Player 2, it's your turn to guess!");
        }

        //System.out.println(word); << this is disabled for now, to hide word

        List<Character> playerGuesses = new ArrayList<>();
        // overthinly
        // ---------- 

        int wrongCount = 0; 

        while(true) { 


            printHangMan(wrongCount);
           
            if (wrongCount >= 6) {
                System.out.println("You Lose!");
                System.out.println("The word was: " + word); //reveal the word
                break;
            }

            printWordState(word, playerGuesses);

            //getPlayerGuess(keyboard, playerGuesses, word);
            if(getPlayerGuess(keyboard, playerGuesses, word)) {
                wrongCount++;
            }

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

    private static boolean getPlayerGuess(Scanner keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Please enter a letter");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        // printWordState(word, playerGuesses);
        return word.contains(letterGuess);

    }

    private static void printHangMan(int wrongCount) {
        System.out.println("--------");
        System.out.println(" |     |");

        if(wrongCount >= 1) {
            System.out.println(" o");
        }
        
        if(wrongCount >= 2) {
            System.out.print("\\ ");
            if(wrongCount >= 3)
                System.out.println("/");
            else
                System.out.println("");
        }

        if(wrongCount >= 4) 
            System.out.println(" |");

        if(wrongCount >= 5) {
            System.out.print("/ ");
            if(wrongCount >= 6)
                System.out.println("\\ ");
            else
                System.out.println("");
        }
        
        System.out.println("");
        System.out.println("");
    }

}



