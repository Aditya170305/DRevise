public class SudokuSolver {
    
    public static boolean solve(int [][] board){

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){

				if(board[i][j] == 0){

					for(int digit=1;digit<=9;digit++){

						if(isValid(board , i , j , digit)){
							board[i][j] = digit;

							if(solve(board)) return true;
							else board[i][j] = 0;
						}
					}

					return false;
				}

			}
		}
		return true;
	}

	public static boolean isValid(int [][] board , int row , int col , int digit){

		for(int i=0;i<9;i++){
			if(board[row][i] == digit) return false;
			if(board[i][col] == digit) return false;
			if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == digit) return false;
		}

		return true;
	}

	public static void solveSudoku(int[][] sudoku) {
        
		solve(sudoku);
        
	}
}
