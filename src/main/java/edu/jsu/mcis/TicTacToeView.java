package edu.jsu.mcis;
import java.util.Scanner;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener{

    private TicTacToeModel model;    
	private JButton[][] squares;
	private JPanel squaresPanel;
	private JLabel resultLabel;
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
		
		int width = model.getWidth();
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		squares = new JButton[width][width];		
		squaresPanel = new JPanel(new GridLayout(width,width));
		resultLabel = new JLabel();		
		resultLabel.setName("ResultLabel");
		
		//Set squares 
		for(int row = 0; row < width; ++row){
			for(int col = 0; col < width; ++col){
				squares[row][col] = new JButton();
				squares[row][col].addActionListener(this);
				squares[row][col].setName("Square" + row + col);
				squares[row][col].setPreferredSize(new Dimension(64, 64));				
				squaresPanel.add(squares[row][col]);
				
			}
		}
		//Add squares and resultLabel to View Panel. 
		add(squaresPanel);
		add(resultLabel);		
		
    }
	
	@Override
	public void actionPerformed(ActionEvent e){
		String button = ((JButton) e.getSource()).getName();

		int row = (int) button.charAt(6) - 48, col = (int) button.charAt(7) - 48;
				
		model.makeMark(row, col);
		
		
	
		JButton clicked = (JButton)e.getSource();
		clicked.setText(model.getMark(row, col).toString());			
							
		
		if(model.getResult() != TicTacToeModel.Result.NONE){
			resultLabel.setText(model.getResult().toString());		
		
		}		
		
	}    
	
}