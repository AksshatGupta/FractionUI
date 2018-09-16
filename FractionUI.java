
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FractionUI {
	
	public static Fraction one;
	public static Fraction two;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("FRACTIONS");

		one = new Fraction(5, 11);
		two = new Fraction(-2, 6);

		JPanel north = new JPanel(); //Replace by scrollPane.

		north.setBackground(Color.CYAN);
		
		JTextArea textArea = new JTextArea(10, 10);
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(20, 2));

		JLabel numLabel1 = new JLabel("Numerator 1: ");
		JLabel denLabel1 = new JLabel("Denominator 1: ");
		
		final int FIELD_WIDTH = 5;
		
		final JTextField numField1 = new JTextField(FIELD_WIDTH);
		numField1.setText("5");
		
		final JTextField denField1 = new JTextField(FIELD_WIDTH);
		denField1.setText("11");

		int num1 = Integer.parseInt(numField1.getText());
		int den1 = Integer.parseInt(denField1.getText());
		JLabel ratio1 = new JLabel("" + new Fraction(num1, den1));
		
		JLabel numLabel2 = new JLabel("Numerator 1: ");
		JLabel denLabel2 = new JLabel("Denominator 1: ");
		
		final JTextField numField2 = new JTextField(FIELD_WIDTH);
		numField2.setText("-2");
		
		final JTextField denField2 = new JTextField(FIELD_WIDTH);
		denField2.setText("6");

		int num2 = Integer.parseInt(numField2.getText());
		int den2 = Integer.parseInt(denField2.getText());
		JLabel ratio2 = new JLabel("" + new Fraction(num2, den2));
		
		JLabel add = new JLabel("" + Fraction.add(one, two));
		JLabel subtract = new JLabel("" + Fraction.subtract(one, two));
		JLabel multiply = new JLabel("" + Fraction.multiply(one, two));
		JLabel divide = new JLabel("" + Fraction.divide(one, two));
		
		JButton reduceButton = new JButton("X");
		JButton reduceButton2 = new JButton("Y");
		JButton addButton = new JButton("X + Y");
		JButton subtractButton = new JButton("X - Y");
		JButton multiplyButton = new JButton("X * Y");
		JButton divideButton = new JButton("X / Y");
		
		JCheckBox alpha = new JCheckBox();
		alpha.setBackground(Color.cyan);

		JButton test = new JButton("Change");
		test.setBackground(Color.red.darker());
		test.setForeground(Color.white);
		test.setFont(new Font("Georgia", Font.ITALIC, 15));
		
		
		north.setLayout(new GridLayout(12, 2));

		north.add(numLabel1);
		north.add(numField1);
		north.add(denLabel1);
		north.add(denField1);
		north.add(reduceButton);
		north.add(ratio1);

		north.add(numLabel2);
		north.add(numField2);
		north.add(denLabel2);
		north.add(denField2);
		north.add(reduceButton2);
		north.add(ratio2);
		
		north.add(addButton);
		north.add(add);
		north.add(subtractButton);
		north.add(subtract);		
		north.add(multiplyButton);
		north.add(multiply);		
		north.add(divideButton);
		north.add(divide);
		
		north.add(test);
		north.add(new Label());
		
		north.add(new Label("Is this working satisfactorly?"));
		north.add(alpha);
		
		//north.add(scrollPane);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This tells the program to exit when the frame is closed
		frame.setBounds(0, 0, 400, 400); // First two numbers set position, second two set size

		frame.getContentPane().add(BorderLayout.NORTH, north); // BorderLayout allows me to attach the JPanel to the
																// border of the frame

		frame.setVisible(true); // Makes the frame visible

		reduceButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				int num1 = Integer.parseInt(numField1.getText());
				int den1 = Integer.parseInt(denField1.getText());
				one = new Fraction(num1, den1);
				ratio1.setText("" + one);
				
			}
		});
		
		reduceButton2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				int num2 = Integer.parseInt(numField2.getText());
				int den2 = Integer.parseInt(denField2.getText());
				two = new Fraction(num2, den2);
				ratio2.setText("" + two);
				
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
			
				add.setText("" + Fraction.add(one, two));
				
			}
		});
		
		subtractButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
			
				subtract.setText("" + Fraction.subtract(one, two));
				
			}
		});
		
		multiplyButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
			
				multiply.setText("" + Fraction.multiply(one, two));
				
			}
		});
		
		divideButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
			
				divide.setText("" + Fraction.divide(one, two));
				
			}
		});

		test.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
			
				
				int rand = (int) (Math.random()*10) + 1, rand2 = (int) (Math.random()*10) + 1, rand3 = (int) (Math.random()*10) + 1, rand4 = (int) (Math.random()*10) + 1;
				
				one = new Fraction(rand, rand2);
				two = new Fraction(rand3, rand4);
				
				numField1.setText("" + rand);
				denField1.setText("" + rand2);
				numField2.setText("" + rand3);
				denField2.setText("" + rand4);
				
				add.setText("" + Fraction.add(one, two));
				subtract.setText("" + Fraction.subtract(one, two));
				multiply.setText("" + Fraction.multiply(one, two));
				divide.setText("" + Fraction.divide(one, two));
				
				ratio1.setText("" + one);
				ratio2.setText("" + two);

				
			}
		});
		
		alpha.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				north.add(new Label("Thank You!"));
				north.add(new Label("How about now?"));
				north.add(new Label("By: Aksshat Gupta"));
				
			}
		});
	}
}
