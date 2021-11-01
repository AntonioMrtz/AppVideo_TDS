package um.tds.AppVideo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Button;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;

public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("AppVideo");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);
		
		Button button = new Button("Registro");
		panel.add(button);
		
		Button button_1 = new Button("Login");
		panel.add(button_1);
		
		JSeparator separator_3 = new JSeparator();
		panel.add(separator_3);
		
		Button button_2 = new Button("Logout");
		panel.add(button_2);
		
		JSeparator separator_4 = new JSeparator();
		panel.add(separator_4);
		
		JSeparator separator_2 = new JSeparator();
		panel.add(separator_2);
		
		Button button_3 = new Button("Premium");
		button_3.setForeground(Color.RED);
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setForeground(Color.LIGHT_GRAY);
		panel_1.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		Button button_4 = new Button("Explorar");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(Color.LIGHT_GRAY);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.gridheight = 0;
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 0;
		panel_2.add(button_4, gbc_button_4);
		
		Button button_5 = new Button("Mis Listas");
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setForeground(Color.WHITE);
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.gridx = 1;
		gbc_button_5.gridy = 0;
		panel_2.add(button_5, gbc_button_5);
		
		Button button_6 = new Button("Recientes");
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.gridx = 2;
		gbc_button_6.gridy = 0;
		panel_2.add(button_6, gbc_button_6);
		
		Button button_7 = new Button("Nueva Lista");
		button_7.setBackground(Color.LIGHT_GRAY);
		button_7.setForeground(Color.WHITE);
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.gridx = 3;
		gbc_button_7.gridy = 0;
		panel_2.add(button_7, gbc_button_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_1.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 6;
		gbc_verticalStrut.gridy = 0;
		panel_3.add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 7;
		gbc_verticalStrut_1.gridy = 0;
		panel_3.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 6;
		gbc_verticalStrut_2.gridy = 1;
		panel_3.add(verticalStrut_2, gbc_verticalStrut_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 2;
		panel_3.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		Label label = new Label("Login");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.GRAY);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 2;
		panel_3.add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 2;
		panel_3.add(textField, gbc_textField);
		textField.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 3;
		panel_3.add(horizontalStrut, gbc_horizontalStrut);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_2.gridx = 1;
		gbc_horizontalStrut_2.gridy = 3;
		panel_3.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 3;
		panel_3.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_4.gridx = 3;
		gbc_horizontalStrut_4.gridy = 3;
		panel_3.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 3;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 3;
		panel_3.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_1.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			   public void actionPerformed(ActionEvent e) {
				   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				   System.out.println("gola");
				   
				   Registro r = new Registro();
				   r.setSize(400,400);
				   r.setVisible(true);
				   //r.dispose();
				   //frame.dispose();
				   frame.setVisible(false);
				   
				   
			   }
			});
		
		JSeparator separator_7 = new JSeparator();
		panel_4.add(separator_7);
		
		JSeparator separator_5 = new JSeparator();
		panel_4.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		panel_4.add(separator_6);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		panel_4.add(btnNewButton_1);
	}
}
