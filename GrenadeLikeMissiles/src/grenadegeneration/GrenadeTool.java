package grenadegeneration;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GrenadeTool {
	
	//Jframe creates the window layer, Container creates the Container layer, panels then labels go into the container
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;
	JLabel titleNameLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 28);
	Font fritzBold;
	Font zapfC;
	JButton startButton, choice1, choice2,choice3,choice4,choice5;
	JTextArea mainTextArea;
	String step;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	
	public static void main(String[] args) {
		
		new GrenadeTool();
	}
	
	public GrenadeTool() {
		
		try{
			fritzBold = Font.createFont(Font.TRUETYPE_FONT, new File("Fritz Bold.ttf")).deriveFont(35f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fritz Bold.ttf")));
			
		
		
		}
		catch(IOException | FontFormatException e){
			
			
		}
		try{
			zapfC = Font.createFont(Font.TRUETYPE_FONT, new File("Zapf Calligraphic 801.otf")).deriveFont(30f);
			GraphicsEnvironment gtwo = GraphicsEnvironment.getLocalGraphicsEnvironment();
			gtwo.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Zapf Calligraphic 801.otf")));
		
		
		}
		catch(IOException | FontFormatException e){
			
			
		}
		
		
		
		
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADnD Grenade-Like Missiles Tool");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(fritzBold);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(zapfC);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		
		window.setVisible(true);
	}
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(zapfC);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(5,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton();
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(zapfC);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton();
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(zapfC);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton();
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(zapfC);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton();
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(zapfC);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		choice5 = new JButton();
		choice5.setBackground(Color.black);
		choice5.setForeground(Color.black);
		choice5.setForeground(Color.white);
		choice5.setFont(zapfC);
		choice5.setFocusPainted(false);
		choice5.addActionListener(choiceHandler);
		choice5.setActionCommand("c5");
		choiceButtonPanel.add(choice5);
		
		grenades();
		
		
	}
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
		
		
		
	}

	public void grenades() {
		step = "gTypeQuestion";
		mainTextArea.setText("Is your grenade [acid], [holy water], [oil],\n[poison], or [other]?");
		
		choice1.setText("acid");
		choice2.setText("holy water");
		choice3.setText("oil");
		choice4.setText("poison");
		choice5.setText("other");
		
		
	}
	public void acid() {
	
		class acidQualities {
			private int aoeInFeet = 1;
			Random rand = new Random();
			private int max=8, min=2;
			private int directHit = (rand.nextInt(max-min+1) +min);
			private int splashDmg = 1;
			
			
		}
		acidQualities cool = new acidQualities();
		mainTextArea.setText("The AOE of the projectile is "+cool.aoeInFeet+" feet. Direct Hit Damage is: " +cool.directHit +" and splash damage is: "+cool.splashDmg+""
				+ "\n\nDid you miss your projectile?");
		choice1.setText("yes");
		choice2.setText("no");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");	
		
		step = "missQ";
	}
	
	public void holyWater() {
		
		class hWaterQualities {
			private int aoeInFeet = 1;
			Random rand = new Random();
			private int max=7, min=2;
			private int directHit = (rand.nextInt(max-min+1) +min);
			private int splashDmg = 1;
			
			
		}
		hWaterQualities cool = new hWaterQualities();
		mainTextArea.setText("The AOE of the projectile is "+cool.aoeInFeet+" feet. Direct Hit Damage is: " +cool.directHit +" and splash damage is: "+cool.splashDmg+""
				+ "\n\nDid you miss your projectile?");
		choice1.setText("yes");
		choice2.setText("no");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");	
		
		step = "missQ";
	}
	
	public void oil() {
		
		class oilQualities {
			private int aoeInFeet = 3;
			Random rand = new Random();
		
			private int directHitSM = (rand.nextInt(6)+1 + rand.nextInt(6)+1);
			private int directHitL = (rand.nextInt(6)+1);
			private int splashDmg = 1;
		
		
	}
	oilQualities cool = new oilQualities();
	mainTextArea.setText("The AOE of the projectile is a "+cool.aoeInFeet+" feet diameter. Direct Hit Damage is: " +cool.directHitSM +" "
			+ " against S/M and " +cool.directHitL+" against Large. Splash damage is: "+cool.splashDmg+"\n\nDid you miss your projectile?");
	choice1.setText("yes");
	choice2.setText("no");
	choice3.setText("");
	choice4.setText("");
	choice5.setText("");	
	
	step = "missQ";
}
	public void poison() {
		class poisonQualities {
			private int aoeInFeet = 1;
		}
		poisonQualities cool = new poisonQualities();
		mainTextArea.setText("The AOE of the projectile is a "+cool.aoeInFeet+" foot diameter. Direct Hit/splash damage is special, refer to DM\n\nDid you miss your projectile?");
		choice1.setText("yes");
		choice2.setText("no");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");	
		
		step = "missQ";
	}
	public void other() {
		
		
		mainTextArea.setText("Refer to DM description of projectile."
				+ "\n\nDid you miss your projectile?");
		choice1.setText("yes");
		choice2.setText("no");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");	
		
		step = "missQ";
	}
	
	public void goodAim() {
		mainTextArea.setText("Good aim."
				+ "\n\nDid you want to throw another projectile?");
		choice1.setText("yes");
		choice2.setText("no");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");	
		
		step = "multiAttackQ";
		
	}
	
	public class ChoiceHandler implements ActionListener{
		String grenadeType = null;
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			 
			
			switch(step) {
			case "gTypeQuestion":
				switch (yourChoice) {
				case "c1": grenadeType = " acid"; acid();
				break;
				case "c2": grenadeType = " holy water"; holyWater();
				break;
				case "c3": grenadeType = " oil"; oil();
				break;
				case "c4": grenadeType = " poison"; poison();
				break;
				case "c5": grenadeType =""; other();
				break;
			
				}
				break;
			case "missQ" : 
				switch (yourChoice) {
				case "c1": range();
				break;
				case "c2":goodAim() ;
				break;
				
				}
				break;
			case "rangeQ": 
				switch (yourChoice) {
				case "c1": missResult(grenadeType, 's');
				break;
				case "c2":missResult(grenadeType, 'm') ;
				break;
				case "c3":missResult(grenadeType, 'l') ;
				break;
				}
				break;
			case "multiAttackQ":
				switch (yourChoice) {
				case "c1": grenades(); 
				break;
				case "c2": step = "end";
				mainTextArea.setText("Wait your turn on initiative");
				break;
				
				
				}
			break;
			}
			
			
		}
	}
	public void missResult(String grenadeType, char range) {
		
		mainTextArea.setText("Your"+grenadeType +" projectile flys out "+ missDirection()+" \ndegrees from the target, missing by " + missDistance(range) +" feet."
				+ "\n\nWould you like to through another grenade?");
		step = "multiAttackQ";
		choice1.setText("yes");
		choice2.setText("no");
		choice3.setText("");
		choice4.setText("");
		choice5.setText("");
		
	}
	
	public void range() {
		
		mainTextArea.setText("Was your target within short, medium or \nlong range? [s/m/l]");
		choice1.setText("small");
		choice2.setText("medium");
		choice3.setText("long");
		step = "rangeQ";
		
		
	}
	
	public int missDirection() {
		int directionMiss = 42069;
		Random rand = new Random();
		
		int directionRoll = (rand.nextInt(10)+1);
		
		switch (directionRoll) {
		case 1: directionMiss = 70;
		break;
		case 2: directionMiss = 0;
		break;
		case 3: directionMiss = 180;
		break;
		case 4: directionMiss = 30;
		break;
		case 5: directionMiss = 150;
		break;
		case 6: directionMiss = 60;
		break;
		case 7: directionMiss = 120;
		break;
		case 8: directionMiss = 90;
		break;
		case 9: directionMiss = 90;
		break;
		case 10:directionMiss = 90;	
		break;
		default: System.out.println("no case was hit");
		
		}
		return directionMiss;
	}
	
	public int missDistance(char range) {
		Random rand = new Random();
		
		int distanceOff =0;
		switch (range) {
		case 's':distanceOff = (rand.nextInt(6)+1) ;
		break;
		case 'm': distanceOff = (rand.nextInt(10)+1);
		break;
		case 'l': distanceOff = ((rand.nextInt(10)+1) + (rand.nextInt(10)+1));
		break;
		
		}
		
		return distanceOff;
	}
	
}
