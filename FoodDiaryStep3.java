package demo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class FoodDiaryImp {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Food diary");
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
		JLabel foodDiaryLabel = new JLabel("Food diary");
		leftPanel.add(foodDiaryLabel);
		JTextArea diaryArea = new JTextArea();
		diaryArea.setBounds(100, 20, 165, 25);
		diaryArea.setEditable(false);
		diaryArea.setText("Here are your meals from previous days");
		leftPanel.add(diaryArea);
		File myObj = new File("filename.txt");
		String text = "";
		try {
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				text += myReader.nextLine() + "\n";
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			try {
				myObj.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		diaryArea.setText(text);

		// right side
		SimpleDateFormat ft = new SimpleDateFormat("dd. M yyyy");
		JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		rightPanel.add(currentDateLabel);
		JTextField breakfastText_1 = new JTextField();
		rightPanel.add(breakfastText_1);
		JTextField lunchText_2 = new JTextField();
		rightPanel.add(lunchText_2);
		JTextField dinnerText_3 = new JTextField();
		rightPanel.add(dinnerText_3);

		
		JButton thanksButton = new JButton("Thanks");
		thanksButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String breakfast1 = breakfastText_1.getText();
				String lunch2 = lunchText_2.getText();
				String dinner3 = dinnerText_3.getText();
				if (breakfast1.isEmpty() && lunch2.isEmpty() && dinner3.isEmpty()) {
					return;
				}
				String text = 
						currentDateLabel.getText() + "\n"
				+ breakfast1 + "\n"
				+ lunch2 + "\n" 
				+ dinner3 + "\n";
				try {
					FileWriter myWriter = new FileWriter("filename.txt",true);
					myWriter.write(text);
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				File myObj = new File("filename.txt");
				text = "";
				try {
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						text += myReader.nextLine() + "\n";
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					try {
						myObj.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				diaryArea.setText(text);

			}
		});
		rightPanel.add(thanksButton);

		JLabel inspirationLabel = new JLabel("How we spend our days is of course " + "how we spend our lives.");
		rightPanel.add(inspirationLabel);

		frame.pack();
		// Setting the frame visibility to true
		frame.setVisible(true);
	}
}
