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
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Button;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;

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
		frame.setResizable(false);
		//frame.setBounds(100, 100, 450, 300);
		frame.setBounds(100, 100, 600, 400);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		//JLabel lblNewLabel = new JLabel("AppVideo");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/um/tds/AppVideo/AppVideo (1).png")));
		/*lblNewLabel.setIcon((Icon) new ImageIcon("AppVideo.png"));*/
		
		
		
		/*lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 15));*/
		panel.add(lblNewLabel);
		
		JSeparator separator_7 = new JSeparator();
		panel.add(separator_7);
		
		JSeparator separator_6 = new JSeparator();
		panel.add(separator_6);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JSeparator separator_5 = new JSeparator();
		panel.add(separator_5);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);
		
		Button button = new Button("Registro");
		panel.add(button);
		
		Button button_1 = new Button("Login");
		panel.add(button_1);
		
		JSeparator separator_3 = new JSeparator();
		panel.add(separator_3);
		
		JSeparator separator_9 = new JSeparator();
		panel.add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		panel.add(separator_10);
		
		JSeparator separator_8 = new JSeparator();
		panel.add(separator_8);
		
		Button button_2 = new Button("Logout");
		panel.add(button_2);
		
		JSeparator separator_4 = new JSeparator();
		panel.add(separator_4);
		
		JSeparator separator_2 = new JSeparator();
		panel.add(separator_2);
		
		Button button_3 = new Button("Premium");
		button_3.setForeground(Color.RED);
		panel.add(button_3);
		
		final JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
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
		
		final JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(Color.GRAY);
		panel_1.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 11;
		gbc_verticalStrut.gridy = 0;
		panel_3.add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 13;
		gbc_verticalStrut_1.gridy = 0;
		panel_3.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 9;
		gbc_verticalStrut_2.gridy = 2;
		panel_3.add(verticalStrut_2, gbc_verticalStrut_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 3;
		panel_3.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_7.gridx = 1;
		gbc_horizontalStrut_7.gridy = 3;
		panel_3.add(horizontalStrut_7, gbc_horizontalStrut_7);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
		gbc_horizontalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_8.gridx = 2;
		gbc_horizontalStrut_8.gridy = 3;
		panel_3.add(horizontalStrut_8, gbc_horizontalStrut_8);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_9 = new GridBagConstraints();
		gbc_horizontalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_9.gridx = 3;
		gbc_horizontalStrut_9.gridy = 3;
		panel_3.add(horizontalStrut_9, gbc_horizontalStrut_9);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 4;
		gbc_horizontalStrut_6.gridy = 3;
		panel_3.add(horizontalStrut_6, gbc_horizontalStrut_6);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_10 = new GridBagConstraints();
		gbc_horizontalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_10.gridx = 5;
		gbc_horizontalStrut_10.gridy = 3;
		panel_3.add(horizontalStrut_10, gbc_horizontalStrut_10);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_11 = new GridBagConstraints();
		gbc_horizontalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_11.gridx = 6;
		gbc_horizontalStrut_11.gridy = 3;
		panel_3.add(horizontalStrut_11, gbc_horizontalStrut_11);
		
		Label label = new Label("Login");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.GRAY);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 8;
		gbc_label.gridy = 3;
		panel_3.add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 9;
		gbc_textField.gridy = 3;
		panel_3.add(textField, gbc_textField);
		textField.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 4;
		panel_3.add(horizontalStrut, gbc_horizontalStrut);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 1;
		gbc_horizontalStrut_2.gridy = 4;
		panel_3.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 4;
		panel_3.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 3;
		gbc_horizontalStrut_4.gridy = 4;
		panel_3.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 8;
		gbc_lblNewLabel_1.gridy = 4;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 9;
		gbc_textField_1.gridy = 4;
		panel_3.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 7;
		gbc_verticalStrut_3.gridy = 5;
		panel_3.add(verticalStrut_3, gbc_verticalStrut_3);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 8;
		gbc_verticalStrut_4.gridy = 5;
		panel_3.add(verticalStrut_4, gbc_verticalStrut_4);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_5.gridx = 15;
		gbc_verticalStrut_5.gridy = 5;
		panel_3.add(verticalStrut_5, gbc_verticalStrut_5);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 7;
		gbc_verticalStrut_6.gridy = 6;
		panel_3.add(verticalStrut_6, gbc_verticalStrut_6);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 8;
		gbc_horizontalStrut_5.gridy = 6;
		panel_3.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_7.gridx = 14;
		gbc_verticalStrut_7.gridy = 6;
		panel_3.add(verticalStrut_7, gbc_verticalStrut_7);
		
		JButton btnNewButton = new JButton("Aceptar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 7;
		panel_3.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			   public void actionPerformed(ActionEvent e) {

				   JPanel j = new JPanel();
				   PanelRegistro bot= new PanelRegistro();
				   j.add(bot);
				   panel_3.setVisible(false);
				   panel_1.add(j, BorderLayout.CENTER);
				   j.setVisible(true);
			   }
			});
		
		JButton btnNewButton_1_1 = new JButton("Cancelar");
		btnNewButton_1_1.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1_1.gridx = 10;
		gbc_btnNewButton_1_1.gridy = 7;
		panel_3.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
		
	}
}
