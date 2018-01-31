package offenseStatTrack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * An in-game interface for user to take stats
 * 
 * @author Sean Calida
 * @version 1/28/18
 */
public class InGameGUI {

	private JFrame frame;
	private JLabel instructions;
	private JRadioButton[] buttonGroup;
	private ButtonGroup group;
	private JButton killButton;
	private JButton errorButton;
	private JButton attemptButton;
	private JButton displayButton;
	private JButton endGame;
	private Hitter[] hitters;
	private int numHitters;
	public boolean gameEnded;
	private String selectedHitter;
	
	/*
	 * Constructor
	 * @hitters1 an array of hitters
	 * @hitters2 the number of hitters on court
	 */
	public InGameGUI(Hitter[] hitters1, int hitters2) {
		hitters = hitters1;
		numHitters = hitters2;
		group = new ButtonGroup();
		selectedHitter = "";
		gameEnded = false;
		
		frame = new JFrame("In-Game Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocation(100, 100);
		frame.setSize(380, 450);
		
		theHandler handler = new theHandler();
		
		instructions = new JLabel("Select hitter then select action.");
		instructions.setBounds(55, 10, 200, 50);
		frame.add(instructions);
		
		buttonGroup = new JRadioButton[numHitters];
		for(int i = 0; i<numHitters; i++) {
			buttonGroup[i] = new JRadioButton(hitters[i].getHitterName());
			buttonGroup[i].setActionCommand(hitters[i].getHitterName());
			buttonGroup[i].addActionListener(handler);
			buttonGroup[i].setBounds(50, (70 + (i * 50) + (i * 10)), 150, 50);
			buttonGroup[i].setVerticalAlignment(SwingConstants.TOP);
			frame.add(buttonGroup[i]);
			group.add(buttonGroup[i]);
		}
		
	
		killButton = new JButton("Kill");
		killButton.setBounds(210, 70, 100, 50);
		killButton.setActionCommand("kill");
		killButton.addActionListener(handler);
		frame.add(killButton);
		
		errorButton = new JButton("Error");
		errorButton.setBounds(210, 130, 100, 50);
		errorButton.setActionCommand("error");
		errorButton.addActionListener(handler);
		frame.add(errorButton);
		
		attemptButton = new JButton("Attempt");
		attemptButton.setBounds(210, 190, 100, 50);
		attemptButton.setActionCommand("attempt");
		attemptButton.addActionListener(handler);
		frame.add(attemptButton);
		
		displayButton = new JButton("Display Stats");
		displayButton.setBounds(210, 250, 100, 50);
		displayButton.setActionCommand("ds");
		displayButton.addActionListener(handler);
		frame.add(displayButton);
		
		endGame = new JButton("End Game");
		endGame.setBounds(210, 310, 100, 50);
		endGame.setActionCommand("end");
		endGame.addActionListener(handler);
		frame.add(endGame);
		
		frame.setVisible(true);
	}
	
	/*
	 *  adds kill and attempt to selected hitter
	 */
	private void clickedKill() {
		for(int i = 0; i<numHitters; i++) {
			if(selectedHitter.equals(hitters[i].getHitterName())) {
				hitters[i].addKill();
				hitters[i].addAttempt();
			}
		}
	}
	
	/*
	 * adds error and attempt to selected hitter
	 */
	private void clickedError() {
		for(int i = 0; i<numHitters; i++) {
			if(selectedHitter.equals(hitters[i].getHitterName())) {
				hitters[i].addError();
				hitters[i].addAttempt();
			}
		}
	}
	
	/*
	 * adds attempt to selected hitter
	 */
	private void clickedAttempt() {
		for(int i = 0; i<numHitters; i++) {
			if(selectedHitter.equals(hitters[i].getHitterName())) {
				hitters[i].addAttempt();
			}
		}
	}
	
	/*
	 * ends game and leads to post-game window and closes in-game window
	 */	
	private void clickedEnd() {
		frame.setVisible(false);
		gameEnded = true;
		new PostGameGUI(getHitters(), getNumHitters(), gameEnded);
	}
	
	/*
	 * leads to post-game window
	 */
	private void clickedDispStat() {
		new PostGameGUI(getHitters(), getNumHitters(), gameEnded);
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
			for (int i = 0; i<numHitters; i++) {
				if(event.getActionCommand().equals(hitters[i].getHitterName())) {
					selectedHitter = hitters[i].getHitterName();
				}
			}
			if (event.getActionCommand().equals("kill")) {
				clickedKill();
			}
			if (event.getActionCommand().equals("error")) {
				clickedError();
			}
			if (event.getActionCommand().equals("attempt")) {
				clickedAttempt();
			}
			if (event.getActionCommand().equals("ds")) {
				clickedDispStat();
			}
			if (event.getActionCommand().equals("end")) {
				clickedEnd();
			}
		}		
	}
}
