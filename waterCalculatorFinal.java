package demo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class waterCalculator {
	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Water in litres per day");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// main containers and Layouts
		JPanel mainPanel = new JPanel();
		frame.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		JPanel rightPanel = new JPanel();
		mainPanel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		// left side
		JLabel CaloriesPerDayLabel = new JLabel("Water in litres per day");
		leftPanel.add(CaloriesPerDayLabel);

		JTextArea planArea = new JTextArea();
		planArea.setBounds(100, 20, 165, 25);
		planArea.setEditable(false);
		planArea.setText("Tell us about you");
		leftPanel.add(planArea);

		// right side
		SimpleDateFormat ft = new SimpleDateFormat("dd. M yyyy");
		JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		rightPanel.add(currentDateLabel);
		

		
		JTextArea questionArea = new JTextArea();
		questionArea.setBounds(100, 20, 165, 25);
		questionArea.setEditable(false);
		questionArea.setText("What's your weight?");
		rightPanel.add(questionArea);
		
		JTextField infoText_1 = new JTextField();
		rightPanel.add(infoText_1);
		
		
		JLabel waterLabel = new JLabel("water intake");
		rightPanel.add(waterLabel);
		
		JTextField infoText_5 = new JTextField();
		rightPanel.add(infoText_5);

		
		JButton showButton = new JButton("Show me how much water I should take!");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int weight = Integer.parseInt(infoText_1.getText());
				userInf data = new userInf(weight);
				infoText_5.setText(Integer.toString(data.calculateWater()));
			}

		});
		rightPanel.add(showButton);

		
		

		frame.pack();
		// Setting the frame visibility to true
		frame.setVisible(true);
        
	}
	
	

	
	
}
