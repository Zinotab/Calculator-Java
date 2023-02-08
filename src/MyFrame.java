import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MyFrame implements ActionListener{
	Font myFont = new Font("none",Font.BOLD,30);
	Font myFont2 = new Font("none",Font.BOLD,40);
	
	ImageIcon Logo = new ImageIcon("calculator.png");
	ImageIcon Logo1 = new ImageIcon("calculator (1).png");
	ImageIcon dotimg = new ImageIcon("dot.png");
	ImageIcon deleteimg = new ImageIcon("delete.png");
	ImageIcon mulimg = new ImageIcon("crossed (1).png");
	ImageIcon divimg = new ImageIcon("divide.png");
	ImageIcon equimg = new ImageIcon("equal (2).png");
	ImageIcon subimg = new ImageIcon("minus (3).png");
	ImageIcon plusimg = new ImageIcon("dot (1).png");
	ImageIcon negimg = new ImageIcon("plus (3).png");
	
	
	
	
	
	
	
	JFrame frame = new JFrame();
	
	JTabbedPane tabpan = new JTabbedPane();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	
	JLabel lablogo = new JLabel();
	
	
	JTextField textfield = new JTextField();
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton,decButton, equButton, delButton, clrButton, negButton;
	
	double num1=0,num2=0,result=0;
	char operator;
	
	JLabel labc = new JLabel();
	
	
	MyFrame(){
		
		tabpan.setBounds(-2, -25, 350, 510);

		tabpan.addTab("New pan1", null, pan1, null);
		tabpan.addTab("New pan2", null, pan2, null);
		
		
		
		lablogo.setIcon(Logo1);
		lablogo.setBounds(140, 185, 64, 64);
		pan1.setBackground(Color.blue);
		pan1.setLayout(null);
		pan1.add(lablogo);
		

		pan2.setLayout(null);
		pan2.setBackground(new Color(0x495057));
		
		
		textfield.setBounds(-3, 0, 352, 95);
		textfield.setFont(myFont2);
		textfield.setEditable(false);
		textfield.setBackground(new Color(0x343a40));
		textfield.setForeground(Color.white);
		
		
		pan2.add(textfield);
		
		addButton = new JButton(plusimg);
		addButton.setBackground(new Color(0x1c1c1e));
		
		
		subButton = new JButton(subimg);
		subButton.setBackground(new Color(0x1c1c1e));
		
		mulButton = new JButton(mulimg);
		mulButton.setBackground(new Color(0x1c1c1e));
		
		divButton = new JButton(divimg);
		divButton.setBackground(new Color(0x1c1c1e));
		
		decButton = new JButton(dotimg);
		decButton.setBackground(new Color(0x000000));
		
		equButton = new JButton(equimg);
		equButton.setBackground(new Color(0x20bf55));
		
		delButton = new JButton(deleteimg);
		delButton.setBackground(new Color(0x3a3a3c));
		
		clrButton = new JButton("C");
		clrButton.setBackground(new Color(0x3a3a3c));
		clrButton.setFont(new Font("none",Font.BOLD,25));
		clrButton.setForeground(Color.white);
		
		negButton = new JButton(negimg);
		negButton.setBackground(new Color(0x000000));
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setBackground(new Color(0x000000));
			numberButtons[i].setForeground(Color.white);
			numberButtons[i].setFocusable(false);
		}
		
		
		labc.setBounds(0, 170, 340, 300);
		labc.setLayout(new GridLayout(4,4,0,0));
		
		labc.add(numberButtons[7]);
		labc.add(numberButtons[8]);
		labc.add(numberButtons[9]);
		labc.add(mulButton);
		labc.add(numberButtons[4]);
		labc.add(numberButtons[5]);
		labc.add(numberButtons[6]);
		labc.add(subButton);
		labc.add(numberButtons[1]);
		labc.add(numberButtons[2]);
		labc.add(numberButtons[3]);
		labc.add(addButton);
		labc.add(negButton);
		labc.add(numberButtons[0]);
		labc.add(decButton);
		labc.add(equButton);
		
		
		delButton.setBounds(0, 95, 127, 75);
		clrButton.setBounds(127, 95, 127, 75);
		divButton.setBounds(255, 95, 85, 75);
		
		pan2.add(clrButton);
		pan2.add(delButton);
		pan2.add(divButton);
		pan2.add(labc);
		
		frame.add(tabpan);
		frame.setTitle("ZED Calculator");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Logo.getImage());
		frame.setSize(350,510);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabpan.setSelectedIndex(1);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			String string = textfield.getText();
			if(string.equals("")) {
				textfield.setText("0.");
			}
			else if(string.contains(".")==false) {
				textfield.setText(textfield.getText().concat("."));
			}
			
			
		}
		
		
		
		if(e.getSource()==addButton) {
			String string = textfield.getText();
			if(string.equals("")) {
				textfield.setText("");
			}
			else{
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
			}
		}
		if(e.getSource()==subButton) {
			String string = textfield.getText();
			if(string.equals("")) {
				textfield.setText("");
			}
			else{
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
			}
		}
		if(e.getSource()==mulButton) {
			String string = textfield.getText();
			if(string.equals("")) {
				textfield.setText("");
			}
			else{
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
			}
		}
		if(e.getSource()==divButton) {
			String string = textfield.getText();
			if(string.equals("")) {
				textfield.setText("");
			}
			else{
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
			}
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			String string = textfield.getText();
			if(string.equals("")) {
				textfield.setText("");
			}
			else{
				double temp = Double.parseDouble(textfield.getText());
				temp*=-1;
				textfield.setText(String.valueOf(temp));
			}
			
		}
	}
	
	
	
	
	
}