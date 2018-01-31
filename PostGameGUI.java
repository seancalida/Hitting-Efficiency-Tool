package offenseStatTrack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Post or Mid Game interface to display statistics
 * 
 * @author Sean Calida
 * @version 1/29/18
 */
public class PostGameGUI {

	private JFrame frame;
	private JTextArea[] statGroup;
	private Hitter[] hitters;
	private int numHitters;
	private JButton resumeGame;
	private boolean tempDisp;
	
	/*
	 * Constructor
	 * @hitters1 the array of Hitter objects
	 * @hitters2 the number of hitters entered
	 * @temp true if game has ended
	 */
	public PostGameGUI(Hitter[] hitters1, int hitters2, boolean temp) {
		hitters = hitters1;
		numHitters = hitters2;
		tempDisp = temp;
		
		frame = new JFrame("Stat Display");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocation(600, 100);
		int height = 50 + (numHitters * 100) + (numHitters * 10);
		if (tempDisp == false) {
			height += 70;
		}
		frame.setSize(200, height);
		
		statGroup = new JTextArea[numHitters];
		for(int i = 0; i<numHitters; i++) {
			statGroup[i] = new JTextArea(hitters[i].getHitterName());
			statGroup[i].setBounds(10, (10 + (i * 100) + (i * 10)), 200, 100);
			statGroup[i].append("\nKills: " + hitters[i].getKills());
			statGroup[i].append("\nErrors: " + hitters[i].getErrors());
			statGroup[i].append("\nAttempts: " + hitters[i].getAttempts());
			statGroup[i].append("\nHitting Efficiency: " + hitters[i].getHP());
			frame.add(statGroup[i]);
		}
		
		theHandler handler = new theHandler();
		
		if (tempDisp == false) {
			resumeGame = new JButton("Resume Game");
			resumeGame.setBounds(10, height - 100, 200, 50);
			resumeGame.setActionCommand("rg");
			resumeGame.addActionListener(handler);
			frame.add(resumeGame);
		}
		
		frame.setVisible(true);
	}
	
	private class theHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("rg")) {
				frame.setVisible(false);
			}
		}
	}
}
