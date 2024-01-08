package Project;

public class Board {
	public static final int SIZE = 3;	// the size of the square, standard tic tac toe is 3 x 3 can make it into other sizes if needed
    private char[][] grid;

    public Board() {
        grid = new char[SIZE][SIZE];	//make a board matrix
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {		//print the board/arena
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    
    public static int getSize() {		//get the size of the board
        return SIZE;
    }

    public boolean isCellEmpty(int row, int col) {			//check the cell if it's empty
        return grid[row][col] == ' ';
    }

    public void markCell(int row, int col, char symbol) {	//replace cell with the player's symbol
        grid[row][col] = symbol;
    }

    public boolean isBoardFull() {							//check if the 3x3 board is full.
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(char symbol) {					//checking the win condition of the game
        // Checking rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) {
                return true; // If row have same symbol = win
            }
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) {
                return true; // If column have same symbol = win
            }
        }

        // Check diagonals
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) {
            return true; // Diagonal win (top left to bottom right)
        }
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            return true; // Diagonal win (top right to bottom left)
        }

        return false;
    }
}
