package Loops;
import java.util.Scanner;

public class GuessingGame {
    String secretWord;
    public GuessingGame(String secretWord) {
        this.secretWord = secretWord;
    }
    
    public String getGuess(String guess) {
        String returnString = "|";
        for (char letter : guess.toCharArray()) {
            int letterIndex = guess.indexOf(letter);
            if (secretWord.charAt(letterIndex) == letter) {
                returnString += "^|";
            } else if (secretWord.indexOf(letter) != -1) {
                returnString += "*|";
            } else {
                returnString += "_|";
            }
        }
        if (secretWord.equals(guess)) {
            return "You win! The word is " + secretWord;
        } else {
            return returnString;
        }
    }
}

class RunGuessingGame {
    public static void main(String[] args) {
        String secretWord = "hello";
        System.out.println("The secret word has " + secretWord.length() + " characters.");
        GuessingGame gg = new GuessingGame(secretWord);

        Scanner sc = new Scanner(System.in);
        System.out.println(gg.getGuess(sc.nextLine()));
        sc.close();
    }
}
