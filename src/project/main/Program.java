package project.main;

import javax.swing.*;

import project.dice.entities.Dice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program extends JFrame{

	private static final long serialVersionUID = 1L;
	private static JFrame programFrame;
	private static JPanel programPanel;
	
	private static JButton buttonDice100;
	private static JButton buttonDice20;
	private static JButton buttonDice16;
	private static JButton buttonDice10;
	private static JButton buttonDice6;
	private static JButton buttonDice4;
	
	private static JTextField textBonus;
	private static JLabel programLabel;
	public int numberRolled = 0;
		
	public Program() {

		initFrame();
	}

	public static void main(String[] args) {
		
		new Program();
	}
	
    public void initFrame() {
    	
    	try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	} catch(Exception e) {
    		System.out.println("Deu ruim");
    	}
    	
    	programPanel = new JPanel();
    	programFrame = new JFrame();
    	textBonus = new JTextField();
    	
    	buttonDice100 = new JButton("100");
    	buttonDice20 = new JButton("20");
    	buttonDice16 = new JButton("16");
    	buttonDice10 = new JButton("10");
    	buttonDice6 = new JButton("6");
    	buttonDice4 = new JButton("4");
    	
    	programLabel = new JLabel("");
    	
    	buttonDice100.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			rollDice(100);
    		}
    	});
    	buttonDice20.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			rollDice(20);
    		}
    	});
    	buttonDice16.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			rollDice(16);
    		}
    	});
    	buttonDice10.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			rollDice(10);
    		}
    	});
    	buttonDice6.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			rollDice(6);
    		}
    	});
    	buttonDice4.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			rollDice(4);
    		}
    	});
    	
    	programPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    	programPanel.setLayout(new GridLayout(0, 2));
    	programPanel.add(buttonDice100);
    	programPanel.add(buttonDice20);
    	programPanel.add(buttonDice16);
    	programPanel.add(buttonDice10);
    	programPanel.add(buttonDice6);
    	programPanel.add(buttonDice4);
    	
    	programPanel.add(textBonus);
    	programPanel.add(programLabel);

    	programFrame.add(programPanel, BorderLayout.CENTER);
    	programFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	programFrame.setTitle("RPGDice");
    	programFrame.setSize(360,240);
    	programFrame.setVisible(true);
    	programFrame.setResizable(false);
    	
    	//limite dois biljap

    }
    
    private void rollDice(int sides) {
    	
    	String trimmedTextBonus = textBonus.getText().trim();
    	
    	try {
    		int bonus = 0;
    		numberRolled = new Dice(sides).roll();
    		
    		if(!trimmedTextBonus.isEmpty()) bonus = Integer.parseInt(trimmedTextBonus);
    		
    		programLabel.setText("<html>" + "O dado rodou: " + numberRolled + "<br>" +
    							        	"Bonus: " + bonus + "<br>" +
    							        	"Resultado: " + (numberRolled + bonus) + "</html>");
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(textBonus, "\"" + trimmedTextBonus + "\" não é um valor válido." );
    	}
		
    }

}
