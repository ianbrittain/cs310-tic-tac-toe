package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
		model.getWidth();
		System.out.println("\n");
		System.out.print("  ");	
		for(int col = 0; col < model.getWidth(); ++col){
			System.out.print(col);
		}
		System.out.print("\n");
		for(int row = 0; row < model.getWidth(); ++row){
			System.out.print(row + " ");			
			for(int col = 0; col < model.getWidth(); ++col){
				if(!model.isSquareMarked(row, col)){
					System.out.print("-");					
				}
				else{
					System.out.print(model.getMark(row, col));
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.print("\n");
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */
		if(model.isXTurn()){
			System.out.print("\nPlayer 1 (X) move: \nEnter the row and column numbers, seperated by a space: ");
		}
		else{
			System.out.print("\nPlayer 2 (O) move: \nEnter the row and column numbers, seperated by a space: ");
		}
       

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("Error: Invalid input. Please enter a valid option.");
    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}