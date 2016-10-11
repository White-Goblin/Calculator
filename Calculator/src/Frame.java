import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private JPanel contentPane;
	private String str = "";
	private int lastNum;
	private int thisNum;
	private int resultNum;
	private JTextField textField = new JTextField();
	private Mather doMath = new Mather();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 300);
		
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gC = new GridBagConstraints();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(grid);
		setContentPane(contentPane);
		
			JComponent buttonC = new JButton("C");
			JComponent buttonEqual = new JButton("=");
			JComponent button0 = new JButton("1");
			JComponent button1 = new JButton("2");
			JComponent button2 = new JButton("3");
			JComponent button3 = new JButton("4");
			JComponent button4 = new JButton("5");
			JComponent button5 = new JButton("6");
			JComponent button6 = new JButton("7");
			JComponent button7 = new JButton("8");
			JComponent button8 = new JButton("9");
			JComponent buttonSubtract = new JButton("-");
			JComponent button9 = new JButton("0");
			JComponent buttonAdd = new JButton("+");
					
			textField.setEnabled(false);
			
			addComp(contentPane,  buttonC, gC, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  textField, gC, 1, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);	
			addComp(contentPane,  button0, gC, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button1, gC, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button2, gC, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button3, gC, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button4, gC, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button5, gC, 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button6, gC, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button7, gC, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button8, gC, 2, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  buttonSubtract, gC, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  button9, gC, 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  buttonAdd, gC, 2, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComp(contentPane,  buttonEqual, gC, 0, 5, 4, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			
			((JButton) buttonC).addActionListener(new OperatorActionListener());
			((JButton) button0).addActionListener(new ButtonActionListener());
			((JButton) button1).addActionListener(new ButtonActionListener());
			((JButton) button2).addActionListener(new ButtonActionListener());
			((JButton) button3).addActionListener(new ButtonActionListener());
			((JButton) button4).addActionListener(new ButtonActionListener());
			((JButton) button5).addActionListener(new ButtonActionListener());
			((JButton) button6).addActionListener(new ButtonActionListener());
			((JButton) button7).addActionListener(new ButtonActionListener());
			((JButton) button8).addActionListener(new ButtonActionListener());
			((JButton) button9).addActionListener(new ButtonActionListener());
			((JButton) buttonSubtract).addActionListener(new OperatorActionListener());
			((JButton) buttonAdd).addActionListener(new OperatorActionListener());
			((JButton) buttonEqual).addActionListener(new EqualActionListener());
	}
	
	private void addComp (JPanel thePanel, JComponent comp, GridBagConstraints gC, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch) {
		gC.gridx = xPos;
		gC.gridy = yPos;
		gC.gridwidth = compWidth;
		gC.gridheight = compHeight;
		gC.weightx = 100;
		gC.weighty= 100;
		gC.insets = new Insets(5,5,5,5);
		gC.anchor = place;
		gC.fill = stretch;
		
		thePanel.add(comp,gC);
	}
	
////methods////
	
	private void appendString (String buttonChar) {
		str += buttonChar;
	}
	
	private void updateScreen(int num) {
		textField.setText("");
		textField.setText(String.valueOf(num));
	}
	
	private void updateScreen(String num) {
		textField.setText("");
		textField.setText(num);
	}
	
	private void printTestVariables() {
		System.out.println("Current Result: " + thisNum);
		System.out.println("Current Building String: " + str);
	}
		
////action listeners////
	
	public class ButtonActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String strFromButton = (((JButton) e.getSource()).getText());
			appendString(strFromButton);
			updateScreen(Integer.parseInt(str));
			thisNum = Integer.parseInt(str);
			printTestVariables();
		}
	} 
	
	public class OperatorActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String operator = (((JButton) e.getSource()).getText());
			if (operator.equals("+")) {
				resultNum = doMath.add(lastNum, thisNum);
				updateScreen(resultNum);
				lastNum = resultNum;
				str = "";
			}
			if (operator.equals("-")) {
				resultNum = doMath.subtract(lastNum, thisNum);
				updateScreen(resultNum);
				lastNum = resultNum;
				str = "";
			}
			if (operator.equals("C")) {
				lastNum=0;
				resultNum=0;
				thisNum=0;
				str="";
				updateScreen(resultNum);
			}
		}
	}
	
	public class EqualActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			updateScreen(resultNum);

		}
	} 
	
}
