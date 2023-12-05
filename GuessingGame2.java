//Aidan Lim
//Lab 2x1: Guessing Game 2

import java.util.*;
import static java.lang.Integer.MAX_VALUE;

public class GuessingGame2 { 
    public static void main(String[] args) { // main method
        Scanner input = new Scanner(System.in); 
        boolean bool = true;
        int guessCount = 0; 
        int gameCount = 0;
        int guessTotal = 0;
        int bestGame = MAX_VALUE;
        String yesno;

        System.out.println("Would you like to play a game (answer with Y or N)?"); // initial prompt
        yesno = input.next();

        while (bool) { 
            while (!yesno.contains("Y") && !yesno.contains("N")) { // invalid
               System.out.println("Sorry I didn't quite catch that."); 
               yesno = input.next();
            } 
            if (yesno.contains("N")) { // no 
               bool = !bool;
               break;
            }
            guessCount = playGame(); // yes
            gameCount++; // count games
            guessTotal = guessTotal + guessCount; // count total guesses
            if (guessCount < bestGame) { // replace high score
                bestGame = guessCount;
            }
            System.out.println("Would you like to play again? Answer with Y or N."); // looped prompt
            yesno = input.next(); 
        }
        
        try { // results
            results(bestGame, gameCount, guessTotal);
        } catch (Exception e) {
            System.out.println("Too Bad.");
        }
        
        input.close();
    }

    public static int playGame() { // play game method
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean bool = true;
        int guess = 0;
        int number = rand.nextInt(10) + 1; // generate answer
        int guessCount = 0; // score count for this game

        System.out.println("I'm thinking of a number between 1 and 10..."); // initial prompt
        while (bool) {
            try {    
                guess = input.nextInt();
                bool = !bool;
                guessCount++;
            } catch (Exception e) {
                System.out.println("Sorry I didn't quite catch that.");
                input.nextLine();
            }
        }   
         while (guess != number && guess != 0) { // incorrect
             if (guess < number) { // too high
                 System.out.println("Higher!");
             } else if (guess > number) { // too low
                 System.out.println("Lower!");
             }
             try {
                 guess = input.nextInt(); // looped prompt
                 guessCount++;
            } catch (Exception e) {
                System.out.println("Sorry I didn't quite catch that.");
                input.nextLine();
            }
         }
    
        System.out.println("Nice Job! " + number + " was correct!"); // correct
        return guessCount;
    }

    public static void results(int bestGame, int gameCount, int sum) { // results method
        double average = sum/gameCount; // average guesses per game
        System.out.println("Total Games: " + gameCount); 
        System.out.println("Total Guesses: " + sum);
        System.out.println("Average Guesses Per Game: " + average);
        System.out.println("Best Game: " + bestGame + " guesses");
    }
}