package edu.jsu.mcis;

public class TicTacToeModel{    
	
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg.trim();
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
		grid = new Mark[width][width];	

        /* Initialize grid by filling every square with empty marks */

		for(int i = 0; i < width; ++i){
			for(int j = 0; j < width; ++j){
				grid[i][j] = Mark.EMPTY;
			}
		}
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
		if(isValidSquare(row, col) && grid[row][col].equals(Mark.EMPTY)){
				if(xTurn){
					grid[row][col] = Mark.X;
				}
				else{
					grid[row][col] = Mark.O;
				}
				xTurn = !xTurn;
				
				return true;
		}  
        return false; /* remove this line! */        
    }
	
    public boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
       
       if(row >= 0 && row < width && col >= 0 && col < width && isSquareMarked(row, col) == false){
		   return true;
	    }
		else{
			return false;
		}
    }
	
    public boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
		
		if(grid[row][col] !=Mark.EMPTY){
			return true;
		} 				
		else{				
			return false;			
		}	
				
    }
	
    public Mark getMark(int row, int col) {        
        /* Return mark from the square at the specified location */
		Mark mark = grid[row][col];
		return mark;	
	}
	
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */        
        if(isMarkWin(Mark.X)){
			return Result.X;
		}
		if (isMarkWin(Mark.O)){
			return Result.O;
		}
		if(isTie()){
			return Result.TIE;
		} 
		else{
			return Result.NONE;
		}

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        int MARK_COUNT = 0;
		
		//check horizontal for win condition
        for(int row = 0; row < width; ++row){
			for(int col = 0; col < width; ++col){
				if(getMark(row, col) == mark){
					MARK_COUNT++;
				}
				else{
					MARK_COUNT = 0;
				}
				if(MARK_COUNT == width){
					return true;
				}
			}
			MARK_COUNT = 0;
		}
		
		//check verticle for win condition		
		for(int col = 0; col < width; ++col){
			for(int row = 0; row < width; ++row){
				if(getMark(row,col) == mark){
					MARK_COUNT++;
				}
				else{
					MARK_COUNT = 0;
				}
				if(MARK_COUNT == width){
					return true;
				}
			}
			MARK_COUNT = 0;
		}
		
		//check diagonal bottom left to top right
		for(int i = 0; i < width; ++i){
			
				if(getMark(i, width-1-i) == mark){
					MARK_COUNT++;
				}
				else{
					MARK_COUNT = 0;
				}
				if(MARK_COUNT == width){
					return true;
				}
			
		}
		
		//check diagonal 
        for(int row= 0; row < width; ++row){
			if(getMark(row, row) == mark){
			MARK_COUNT++;
			}
			else{
				MARK_COUNT = 0;
			}
			if(MARK_COUNT == width){
				return true;
			}		
		
			//return false;
		}
		return false;
	}
	
    public boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        for(int i = 0; i < width; ++i){
			for(int j = 0; j < width; ++j){
				if(getMark(i, j) == Mark.EMPTY){
					return false;
				}			
			}
		}
		
		if(isMarkWin(Mark.X) || isMarkWin(Mark.O)){
			return false;
		}
		else{
			return true;
		}
        
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}