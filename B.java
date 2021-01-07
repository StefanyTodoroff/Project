package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WaterApp extends JFrame {

	private JPanel contentPane;
	private JTextField fieldWeight;
	private final JButton buttonTellMe = new JButton("Tell me!");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaterApp frame = new WaterApp();
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
	public WaterApp() {
		setBackground(new Color(240, 240, 240));
		setTitle("Water Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 169);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("How much water should I drink today?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("My weight (kg):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1);
		
		fieldWeight = new JTextField();
		contentPane.add(fieldWeight);
		fieldWeight.setColumns(10);
		buttonTellMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				float weight = Float.parseFloat(fieldWeight.getText());
				float waterAmount = calculateWater(weight);
				String message = "You should drink %.1f L of water a day!";
				message = message.format(message, waterAmount);
				
				JOptionPane.showMessageDialog(WaterApp.this, message);
			}
		});
		contentPane.add(buttonTellMe);
	}
	private float calculateWater(float weight) {
		return (weight / 10f ) * 0.4f;
	}

}
