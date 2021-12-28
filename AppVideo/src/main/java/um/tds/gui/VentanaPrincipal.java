package um.tds.gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import tds.driver.ServicioPersistencia;
import um.tds.controlador.Controlador;
import um.tds.dominio.CatalogoVideos;
import um.tds.dominio.Etiqueta;
import um.tds.dominio.FiltroAdultFilter;
import um.tds.dominio.Usuario;
import um.tds.dominio.Video;
import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;

import java.awt.CardLayout;
import java.awt.Label;

public class VentanaPrincipal {

	private static JFrame frame;
	private static Usuario user;
	private static JPanel panel_login_name= new JPanel();
	private static JLabel lblTest=new JLabel("test");
	
	
	
	public static JFrame getFrame() {
		

			return frame;

	}
	
	
	public static int setLoginName() {
		
		System.out.println("hola");
		user = Controlador.getUnicaInstancia().getUsuarioActual();
		   if(user==null) {
			   panel_login_name.setVisible(false);
		   }else {
			   lblTest.setText(user.getUsuario());
			   panel_login_name.setVisible(true);
		   }

		   return 0;
}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void mostrarVentana() {
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		
		
		//frame.setResizable(false);
		frame.setResizable(true);
		//frame.setBounds(100, 100, 450, 300);
		frame.setBounds(100, 100, 600, 400);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		//JPanel panel_login_name = new JPanel();
		panel_login_name.setVisible(false);
		panel.add(panel_login_name);
		panel_login_name.setLayout(new BorderLayout(0, 0));
		
		//JLabel lblTest = new JLabel("test");
		panel_login_name.add(lblTest, BorderLayout.SOUTH);
		
		JLabel lblBienvenido = new JLabel("Bienvenido:");
		panel_login_name.add(lblBienvenido, BorderLayout.NORTH);
		
		//JLabel lblNewLabel = new JLabel("AppVideo");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/AppVideo (1).png")));
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
		
		
		
		
		
		/* Lo que cambia */
		
		
		
		JPanel pantallaPrincipal = new JPanel();
		panel_1.add(pantallaPrincipal, BorderLayout.CENTER);
		pantallaPrincipal.setLayout(new CardLayout(0, 0));
		
		PanelLogin login = new PanelLogin();
		pantallaPrincipal.add(login,"login");
		
		PanelRegistro registro = new PanelRegistro();
		pantallaPrincipal.add(registro,"registro");
		
		PanelExplorar explorar= new PanelExplorar();
		pantallaPrincipal.add(explorar,"explorar");
		
		PanelMisListas mislistas = new PanelMisListas();
		pantallaPrincipal.add(mislistas,"mislistas");
		
		PanelNuevaLista nuevalistas = new PanelNuevaLista();
		pantallaPrincipal.add(nuevalistas,"nuevalista");
		
		PanelRecientes recientes = new PanelRecientes();
		pantallaPrincipal.add(recientes,"recientes");		
		
		CardLayout cl = (CardLayout)(pantallaPrincipal.getLayout());
	    cl.show(pantallaPrincipal,"login");
	    
	    
	   
		
	    /* action handlers */

		
	    button.addActionListener(new ActionListener() {   // BOTON REGISTRO
			
			   public void actionPerformed(ActionEvent e) {
				   
				
				   cl.show(pantallaPrincipal,"registro");
				   
			   }
			   
	    });
	    
	    
	    button_1.addActionListener(new ActionListener() {   // BOTON LOGIN
			
			   public void actionPerformed(ActionEvent e) {
			
				   cl.show(pantallaPrincipal,"login");
				   
				   
			   }
			   
	    });
	    
	    
	    button_2.addActionListener(new ActionListener() {   // BOTON LOGOUT
			
			   public void actionPerformed(ActionEvent e) {
			
				   Controlador.getUnicaInstancia().logoutUsuario();
				   
				   
			   }
			   
	    });
	    
	    button_3.addActionListener(new ActionListener() {   // BOTON PREMIUM
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
				   if(Controlador.getUnicaInstancia().getUsuarioActual()!=null) {
					   
					   
					   if (Controlador.getUnicaInstancia().getUsuarioActual()!=null) {
						   
						   Controlador.getUnicaInstancia().getUsuarioActual().becomePremium();
						   
					   }
					   
				   }
				   
				  
				  
				 
			   }
			   
	    });  
	    
	    button_4.addActionListener(new ActionListener() {   // BOTON EXPLORAR
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
				   cl.show(pantallaPrincipal,"explorar");
				   
				   
			   }
			   
	    });  
	    
	    
	    
	    button_7.addActionListener(new ActionListener() {   // BOTON NUEVA LISTA
			
			   public void actionPerformed(ActionEvent e) {
				  
				   cl.show(pantallaPrincipal,"nuevalista");
				   
				   
			   }
			   
	    });  
	    
	    
	    button_5.addActionListener(new ActionListener() {   // BOTON MIS LISTAS
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
				   cl.show(pantallaPrincipal,"mislistas");
				   
				   
			   }
			   
	    });
		
	    
	    
	    button_6.addActionListener(new ActionListener() {   // BOTON RECIENTES
			
			   public void actionPerformed(ActionEvent e) {
				
				   cl.show(pantallaPrincipal,"recientes");
				   
				   
			   }
			   
	    });
		
	}
}
