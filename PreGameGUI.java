package offenseStatTrack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * A pre-game interface that allows user to 
 * input up to 6 players
 * 
 * @author Sean Calida
 * @version 1/27/18
 */
public class PreGameGUI {

	private Hitter[] hitters;
	private int numHitters;
	private JFrame frame;
	private JLabel hitterNameQ;
	private JTextField hitterNameInput;
	private JButton addHitter;	
	private JTextArea hittersAdded;
	private JButton startGame;
	public InGameGUI inGame;
	
	/*
	 * Constructor
	 */
	public PreGameGUI() {
		hitters = new Hitter[6];
		
		frame = new JFrame("Pre-Game Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocation(100, 100);
		frame.setSize(400, 500);
		
		theHandler handler = new theHandler();
		
		hitterNameQ = new JLabel("Enter Hitter Name");
		hitterNameQ.setToolTipText("Type hitter first name and 1 at a time");
		hitterNameQ.setBounds(50, 10, 200, 50);
		frame.add(hitterNameQ);
		
		hitterNameInput = new JTextField("Type Here");
		hitterNameInput.setBounds(50, 50, 300, 50);
		frame.add(hitterNameInput);
		
		addHitter = new JButton("Add Hitter");
		addHitter.setBounds(150, 115, 100, 50);
		addHitter.addActionListener(handler);
		frame.add(addHitter);
		
		hittersAdded = new JTextArea("Hitters Added: ", 7, 1);
		hittersAdded.setBounds(50, 190, 300, 175);
		frame.add(hittersAdded);
		
		startGame = new JButton("Start Game");
		startGame.setBounds(150, 380, 100, 50);
		startGame.addActionListener(handler);
		frame.add(startGame);
		
		frame.setVisible(true);
		
		numHitters = 0;
	}
	
	/*
	 * Adds hitter name to playersAdded
	 */
	private void clickedAddHitter() {
		String name = hitterNameInput.getText();
		
		if(numHitters < 6) {
			hitters[numHitters] = new Hitter(name);
			numHitters++;
			hittersAdded.append("\n" + numHitters + ": " + name);
		} else {
			hittersAdded.append("\n \nMax number of hitters reached");
		}	
	}
	
	/*
	 * Closes the window and sets gameStarted to true
	 */
	private void clickedStartGame() {
		frame.setVisible(false);
		inGame = new InGameGUI(getHitters(), getNumHitters());
	}
	
	/*
	 * getter method for hitters
	 * @return hitters
	 */
	public Hitter[] getHitters() {
		return hitters;
	}
	
	/*
	 * getter method for numHitters
	 * @return number of hitters
	 */
	public int getNumHitters() {
		return numHitters;
	}
	
	/*
	 * local handler for buttons
	 */
	private class theHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == startGame) {
				clickedStartGame();
			}
			if (event.getSource() == addHitter) {
				clickedAddHitter();
			}			
		}		
	}
}
