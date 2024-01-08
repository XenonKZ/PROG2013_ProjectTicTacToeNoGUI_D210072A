package Project;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;

    public TicTacToe() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter name for Player 1: ");	//get player1 name
        String player1Name = scanner.nextLine();

        System.out.println("Enter name for Player 2: ");	//get player2 name
        String player2Name = scanner.nextLine();
        
        player1 = new Player(player1Name, 'X');
        player2 = new Player(player2Name, 'O');
        board = new Board();
        currentPlayer = player1;
    }

    public void play() {
    	Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        
        do {
            board.displayBoard();				//print board
            int row, col;

            do {
                System.out.println(currentPlayer.getName() + ", enter your move (row and column) [|0|1|2|] : ");	//prompt user
                row = scanner.nextInt();		
                col = scanner.nextInt();		
            } while (!isValidMove(row, col));	//calls board isValidMove

            board.markCell(row, col, currentPlayer.getSymbol());	//change the empty cell into Player.symbol

            if (board.checkWin(currentPlayer.getSymbol())) {		
                board.displayBoard();				//print the board/arena
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            } else if (board.isBoardFull()) {
                board.displayBoard();				//print the board/arena
                System.out.println("It's a draw!");	
                break;
            }

            switchPlayer();				//switch between the two players
            System.out.println();		//add a empty line
        } while (true);

        scanner.close();
    }

    private boolean isValidMove(int row, int col) {		//validation
        if (row < 0 || row >= Board.SIZE || col < 0 || col >= Board.SIZE) {
            System.out.println("Invalid move. Row and column must be between 0 and " + (Board.SIZE - 1) + ".");
            return false;
        }

        if (!board.isCellEmpty(row, col)) {				//if the board cell is not empty print
            System.out.println("Invalid move. The cell is already occupied.");
            return false;
        }

        return true;
    }

    private void switchPlayer() {  
        if (currentPlayer == player1) {		// Check if it's currently player1's turn
            currentPlayer = player2;		// If yes, switch to player2 for the next turn
        } else {
            currentPlayer = player1;		// If it's not player1's turn, switch to player1 for the next turn
        }
    }//or can use this alternate line |currentPlayer = (currentPlayer == player1) ? player2 : player1;|

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();	//instantiate new object
        game.play();						//call method play
    }
}
