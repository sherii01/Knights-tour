import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        login.initializedemousers();
        login.loginmethod();

        if (login.loginstatus) {
            System.out.println("1.start the game");
            System.out.println("2.exit");
            System.out.println("enter your choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    long starttime = System.currentTimeMillis();
                    long timelimit = 300000;
                    int movesPlayed = 0;
                    int currentScore = 0;  // Changed from score to currentScore
                    Boolean GameWon = false;
                    Random random = new Random();
                    int[][] chessboard = new int[8][8];
                    int rowposition = random.nextInt(8);
                    int colposition = random.nextInt(8);
                    chessboard[rowposition][colposition] = 1;

                    while (true) {
                        long currentTime = System.currentTimeMillis();
                        if (currentTime - starttime >= timelimit) {
                            System.out.println("⏰ TIME'S UP! Final Score: " + currentScore);
                            break;
                        }

                        for (int[] value : chessboard) {
                            for (int cell : value) {
                                System.out.print(cell == 1 ? " ♞ " : " . ");
                            }
                            System.out.println();
                        }

                        int[] LR = {2, 1, -1, -2, -2, -1, 1, 2};
                        int[] UP = {1, 2, 2, 1, -1, -2, -2, -1};
                        int newrowpos;
                        int newcolpos;
                        int[][] validMoves = new int[8][2];
                        int movecounter = 0;
                        for (int i = 0; i < 8; i++) {
                            newrowpos = rowposition + LR[i];
                            newcolpos = colposition + UP[i];
                            if (newrowpos >= 0 && newrowpos < 8 && newcolpos >= 0 && newcolpos < 8 && chessboard[newrowpos][newcolpos] == 0) {
                                System.out.println(movecounter + ".move to " + newrowpos + "," + newcolpos);
                                validMoves[movecounter][0] = newrowpos;
                                validMoves[movecounter][1] = newcolpos;
                                movecounter++;
                            }
                        }

                        if (movecounter == 0) {
                            System.out.println("No more valid moves. Game over.");
                            break;
                        }
                        System.out.println("enter your move");
                        int movechoice = scanner.nextInt();
                        if (movechoice < 0 || movechoice >= movecounter) {
                            System.out.println("Invalid move. Try again.");
                            continue;
                        }

                        if (movechoice >= 0 && movechoice < movecounter) {
                            movesPlayed++;
                            currentScore = movesPlayed;  // Score tracking
                            if (movesPlayed == 63) {
                                System.out.println("Congrats,YOU COMPLETED THE PERFECT KNIGHT's TOUR");
                                GameWon = true;
                            }
                        }
                        if (GameWon) {
                            break;
                        }

                        rowposition = validMoves[movechoice][0];  // Simplified move execution
                        colposition = validMoves[movechoice][1];
                        chessboard[rowposition][colposition] = 1;
                    }

                    System.out.println("moves played: " + movesPlayed);
                    System.out.println("score: " + currentScore);

                    // Update high score if needed
                    Users currentUser = login.getLoggedInUser();
                    if (currentUser != null && currentScore > currentUser.getScore()) {
                        currentUser.setScore(currentScore);
                        System.out.println("🏆 New high score saved!");
                    }
                    break;

                case 2:
                    System.out.println("exitting the game");
                    return;
            }
        }
    }
}



