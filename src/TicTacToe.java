import  java.util.Scanner;

/**
 * A simple Tic-Tac-Toe game implementation in Java.
 */
public class TicTacToe {

	/**
	 * The main method to run the Tic-Tac-Toe game.
	 *
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		// TODO: Initialize the game board and scanner

		Scanner reader = new Scanner(System.in);
		char[][] board = {
				{' ', ' ' ,' '},
				{' ', ' ' ,' '},
				{' ', ' ' ,' '}
		};

		printBoard(board);
		int valid_moves = 0;
		boolean game_ended = false;

		int player = 0;
		while(!game_ended){

			System.out.println("Player " + (player+1) +
					" enter a col number: ");
			int row = reader.nextInt();
			System.out.println("Player " + (player+1) +
					" enter a col number: ");
			int col = reader.nextInt();
			if(isValid(row,col) && board[row-1][col-1] == ' '){
				board[row-1][col-1] = player == 0 ? 'X' : '0';
				printBoard(board);
				player = ++player % 2;
				valid_moves++;
			}else{
				System.out.println("Please provide valid inputs!!!");
			}
			game_ended = valid_moves == 9 || checkboard(board, row-1, col-1);
		}


		// TODO: Print the initial game board
		// TODO: Prompt the current player for their move
		// TODO: Update the board with the player's move
		// TODO: Handle invalid move
		// TODO: Check if the game has ended

	}




	/**
	 * Checks if the current player has won the game.
	 *
	 * @param board The game board.
	 * @param row The row of the last move.
	 * @param col The column of the last move.
	 * @return True if the current player has won, false otherwise.
	 */
	public static boolean checkboard(char[][] board, int row, int col) {
		// TODO: Implement the logic to check if the current player has won
		char symbol = board[row][col];
		boolean win = true;

		for (int i = 0; i < 3;i++){
			if(board[row][i] != symbol){
				win = false;
				break;
			}
		}
		if (win){
			return true;
		}
		win = true;
		// for colls
		for (int i = 0; i < 3;i++){
			if(board[i][col] != symbol){
				win = false;
				break;
			}
		}
		if (win){
			return true;
		}
		if (row == col){
			win = true;
			for (int i = 0; i < 3; i++){
				if (board[i][i] != symbol){
					win = false;
					break;;
				}
			}
		}
		if (win){
			return true;
		}

		if(row + col == 2){
			win = true;
			for (int i = 0; i < 3; i++) {
				if (board[2 - i][i] != symbol) {
					win = false;


				}
			}
			if (win){
				return true;
			}

        return false;
    }

	/**
	 * Prints the current state of the game board.
	 *
	 * @param board The game board.
	 */
	public static void printBoard(char[][] board) {
		// TODO: Implement the logic to print the game board

		System.out.println("  1        2         3");
		System.out.println("  -----------------------");

		for(int row = 0; row < 3; row++){
			System.out.print(row +1 + " ");
			for (int col = 0; col < 3;col++){
				System.out.print(" | ");
				System.out.print(" " + board[row][col] + " ");

				if(col == 2){
					System.out.print("  |");
				}

			}

			System.out.println();
			System.out.println("  -------------------");
		}

	}

	/**
	 * Validates if the given row and column are within the valid range.
	 *
	 * @param row The row number.
	 * @param col The column number.
	 * @return True if the row and column are valid, false otherwise.
	 */
	public static boolean isValid(int row, int col) {
		// TODO: Implement the logic to validate the row and column
		if(row < 1 || row > 3){
			return false;
		}
		if(col < 1 || col > 3){
			return false;
		}

		return true;
	}
}