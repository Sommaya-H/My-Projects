import java.util.Scanner;
public class TicTactoe {
    public static void main(String[] args) {
        int restart = 1;
        while (restart == 1) {
            String board = "    |    |    \n____|____|____" +
                    "\n    |    |    \n____|____|____\n    |    |    \n    |    |    ";
            char[] boardARR = new char[board.length()]; // Copy char by char into arr
            for (int i = 0; i < board.length(); i++) {
                boardARR[i] = board.charAt(i);
            }
            System.out.println("Play TicTacToe!!!");
            System.out.println(boardARR);
            Scanner input = new Scanner(System.in);
            System.out.print("If you want to play against a computer player, enter 1 or enter 2 for 2 players: ");
            int d = input.nextInt();
            char turn = 'O'; //this variable prints either X or O based on turn
            int ok = 2;

            if (d == 1) { //if play other player
                while (WinCounter(boardARR, turn) == 0) {
                    System.out.println("Player is O, Computer is X");
                    System.out.println(PlayerMove(boardARR, turn));
                    if (WinCounter(boardARR, turn) == 1) {
                        System.out.println("Congrats Player wins!");
                        System.out.print("Do you want to play again?");
                        ok = game(restart);
                    }
                    if (ok==2) {
                        System.out.println("Computer's turn: ");
                        System.out.println(RobotMove(boardARR, 'X'));
                        if (WinCounter(boardARR, turn) == 1) {
                            System.out.println("Congrats Computer wins!");
                            System.out.println("Do you want to play again?");
                            ok = game(restart);
                        }
                    }
                }
            }
            if (d == 2) {
                while (WinCounter(boardARR, turn) == 0) {
                    System.out.println("Player 1 is O, Player 2 is X");
                    System.out.println(PlayerMove(boardARR, 'O'));
                    if (WinCounter(boardARR, turn) == 1) {
                        System.out.println("Congrats Player 1 wins!");
                        System.out.println("Do you want to play again?");
                        ok = game(restart);
                    }
                    if (ok==2){
                    System.out.println(PlayerMove(boardARR, 'X'));
                    if (WinCounter(boardARR, turn) == 1) {
                        System.out.println("Congrats Player 2 wins!");
                        System.out.println("Do you want to play again?");
                        ok = game(restart);
                    }
                    }
                }
            }
        }
    }
    public static char[] RobotMove(char[] board, char TURN) {
        //int x = (int) Math.random() * 4 + 1;
        int x = (int)(Math.random() * ((3 - 1) + 1)) + 1;
        int y = (int)(Math.random() * ((3 - 1) + 1)) + 1;
        //int y = (int) Math.random() * 4 + 1;
        return BoardAdd(board, x, y, TURN);
    }

    public static char[] PlayerMove(char[] board, char TURN) {
        Scanner Player = new Scanner(System.in);
        System.out.print("Player " + TURN + " enter x coordinate: ");
        int x = Player.nextInt();
        System.out.print("Player " + TURN + " enter y coordinate: ");
        int y = Player.nextInt();
        return BoardAdd(board, x, y, TURN);
    }

    public static char[] BoardAdd(char[] BOARD, int X, int Y, char TURN) {
        if (X == 1 && Y == 1) {
            if (BOARD[3] != ' ') {
                System.out.println("Space is unavailable");
                PlayerMove(BOARD, TURN);

            } else {
                BOARD[3] = TURN;
            }
        } else if (X == 2 && Y == 1) {
            if (BOARD[7] != ' ') {
                System.out.println("Space is unavailable");
                PlayerMove(BOARD, TURN);
            } else {
                BOARD[7] = TURN;
            }
        } else if (X == 3 && Y == 1) {
            if (BOARD[12] != ' ') {
                System.out.println("Space is unavailable");
                PlayerMove(BOARD, TURN);
            } else {
                BOARD[12] = TURN;
            }
        } else if (X == 1 && Y == 2) {
            if (BOARD[31] != ' ') {
                System.out.println("Space is unavailable");
                PlayerMove(BOARD, TURN);
            } else {
                BOARD[31] = TURN;
            }
        } else if (X == 2 && Y == 2) {
            if (BOARD[35] != ' ') {
                System.out.println("Space is unavailable");
                PlayerMove(BOARD, TURN);
            } else {
                BOARD[35] = TURN;
            }
        } else if (X == 3 && Y == 2) {
            if (BOARD[40] != ' ') {
                System.out.println("Space is unavailable");
                PlayerMove(BOARD, TURN);
            } else {
                BOARD[40] = TURN;
            }
        } else if (X == 1 && Y == 3) {
            if (BOARD[60] != ' ') {
                System.out.println("Space is unavailable");
                PlayerMove(BOARD, TURN);
            } else {
                BOARD[60] = TURN;
            }
        } else if (X == 2 && Y == 3) {
            if (BOARD[65] != ' ') {
                System.out.println("Space is unavailable");
                PlayerMove(BOARD, TURN);
            } else {
                BOARD[65] = TURN;
            }
        } else if (X == 3 && Y == 3) {
            if (BOARD[70] != ' ') {
                System.out.println("Space is unavailable");

                PlayerMove(BOARD, TURN);
            } else {
                BOARD[70] = TURN;
            }
        } else {
            System.out.println("Input invalid. Try again.");
            PlayerMove(BOARD, TURN);
        }
        return BOARD;
    }

    public static int WinCounter(char[] BOARD, char turn) {
        int wins = 0;
        if (turn == BOARD[35]) {
            if (turn == BOARD[7] && turn == BOARD[65]) {
                wins += 1;
            }
            if (turn == BOARD[60] && turn == BOARD[12]) {
                wins += 1;
            }
            if (turn == BOARD[70] && turn == BOARD[3]) {
                wins += 1;
            }
            if (turn == BOARD[31] && turn == BOARD[40]) {
                wins += 1;
            }
        }
        if (turn == BOARD[3]) {
            if (turn == BOARD[31] && turn == BOARD[60]) {
                wins += 1;
            }
            if (turn == BOARD[7] && turn == BOARD[12]) {
                wins += 1;
            }
        }
        if (turn == BOARD[70]) {
            if (turn == BOARD[12] && turn == BOARD[40]) {
                wins += 1;
            }
            if (turn == BOARD[60] && turn == BOARD[65]) {
                wins += 1;
            }
        }
        return wins;
    }

    public static int game(int RESTART){
            System.out.println("Enter 1 to play again, Enter 0 to exit");
            Scanner Sc = new Scanner(System.in);
            RESTART = Sc.nextInt();
            if(RESTART==1){
                System.out.println("---------- R E S T A R T ----------");
            }
            if (RESTART == 0) {
                System.exit(0);
            }
        return RESTART;
    }
}
