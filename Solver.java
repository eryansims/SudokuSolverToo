
/**
 * Write a description of class Solver here.
 *
 * @author Ryan Sims
 * @version 12/10/18
 */

public class Solver {
    public static int[][] UNSOLVED_GRID = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,0,0,0,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,0,0,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9},
    };
    
    static private int[][] grid;
    public static final int EMPTYCELL = 0; 
    public static final int SIZE = 9; 
    
    
    public static void main(String[] args) {
        Solver sudoku = new Solver(UNSOLVED_GRID);
	System.out.println("Sudoku Grid You Needed Solved:");
	System.out.println();
	sudoku.results();
		
	
	if (Solver.solve()) {
		System.out.println("Your Solved Sudoku Grid:");
		System.out.println();
		Solver.results();
	} 
	
	else {
		System.out.println("This Sudoku Grid is Unsolvable");
	}
    }
    
    public Solver(int[][] board) {
	this.grid = new int[SIZE][SIZE];
		
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
		    this.grid[i][j] = grid[i][j];
		}
        }
    }
    
    private static boolean Row(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
		if (grid[row][i] == number) {
		    return true;
		}
        }   
		
	return false;
    }

    private static boolean Column(int column, int number) {
        for (int i = 0; i < SIZE; i++) {
                if (grid[i][column] == number) {
                    return true;
                }
        }	
	
        return false;
    }

    private static boolean Square(int row, int column, int number) {
	int roww = row - row % 3;
	int columnn = column - column % 3;
		
	for (int i = roww; i < roww + 3; i++) {
	   	for (int j = columnn; j < columnn + 3; j++) {
			if (grid[i][j] == number) {
			    return true;
                        }
                }
        }
	
        return false;
    }

    private static boolean Ok(int row, int column, int number) {
	return !Row(row, number)  &&  !Column(column, number)  &&  !Square(row, column, number);
    }
    
    public static boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (grid[row][column] == EMPTYCELL) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (Ok(row, column, number)) {
                            grid[row][column] = number;

                            if (solve()) { 
                                return true;
                            } 
                            
                            else { 
                              grid[row][column] = EMPTYCELL;
                            }
                        }
                    }

                    return false; 
                }
            }
        }

        return true; 
    }
	
    public static void results() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + grid[i][j]);
            }
		
            System.out.println();
	}
		
	System.out.println();
    }
	
}
