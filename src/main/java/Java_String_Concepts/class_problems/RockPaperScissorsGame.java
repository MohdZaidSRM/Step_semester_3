package Java_String_Concepts.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    // Decides the winner of ONE round using standard Rock-Paper-Scissors rules
    public static String playRound(String playerMove, String computerMove) {
        // Same move on both sides means nobody wins this round
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        // Check every combination where the PLAYER beats the computer
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        // Anything left over means the computer won this round
        return "Computer Wins";
    }

    public static void main(String[] args) {
        // The three legal moves; used to pick a random move for the computer
        String[] moves = {"Rock", "Paper", "Scissors"};

        // Predefined player moves so the live demo is repeatable on stage
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        // Random is Java's built-in random-number generator
        Random random = new Random();

        // Running totals across all rounds
        int wins = 0, losses = 0, draws = 0;

        // Print the table header once, before the loop starts
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");

        // One iteration = one round of the game
        for (int round = 1; round <= playerMoves.length; round++) {
            // Pick a random move for the computer (0, 1, or 2)
            String computerMove = moves[random.nextInt(moves.length)];

            // Look up this round's player move from the predefined list
            String playerMove = playerMoves[round - 1];

            // Ask the helper method who won this round
            String result = playRound(playerMove, computerMove);

            // Update the correct counter based on the outcome
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            // Print one row of the results table
            System.out.printf("%-5d | %-11s | %-13s | %s%n", round, playerMove, computerMove, result);
        }

        // Win percentage calculation (Use 100.0 to prevent integer truncation!)
        double winPercentage = ((double) wins / playerMoves.length) * 100;

        // Print the final scoreboard after all rounds are done
        System.out.println("----------------------------------------------");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}
