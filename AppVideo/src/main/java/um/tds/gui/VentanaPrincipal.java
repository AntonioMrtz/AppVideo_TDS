package um.tds.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventObject;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;

import com.itextpdf.text.DocumentException;

import pulsador.IEncendidoListener;
import pulsador.Luz;
import um.tds.controlador.Controlador;
import um.tds.dominio.Usuario;

public class VentanaPrincipal implements IEncendidoListener {

	private static JFrame frame;
	private static Usuario user;
	private static JPanel panel_login_name = new JPanel();
	private static JLabel lblTest = new JLabel("test");

	private PanelLogin login = new PanelLogin();
	private PanelRegistro registro = new PanelRegistro();
	private PanelExplorar explorar = new PanelExplorar();
	private PanelMisListas mislistas = new PanelMisListas();
	private PanelNuevaLista nuevalistas = new PanelNuevaLista();
	private PanelRecientes recientes = new PanelRecientes();

	private CardLayout cl;

	private JPanel activeCard;

	public static int setLoginName() {

		user = Controlador.getUnicaInstancia().getUsuarioActual();
		if (user == null) {
			panel_login_name.setVisible(false);
		} else {
			lblTest.setText(user.getUsuario());
			panel_login_name.setVisible(true);
		}

		return 0;
	}

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

		frame.setResizable(true);

		frame.setBounds(100, 100, 700, 500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		panel_login_name.setVisible(false);

		Luz luz = new Luz();
		panel.add(luz);
		luz.setColor(Color.YELLOW);

		luz.addEncendidoListener((IEncendidoListener) this);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		panel.add(panel_login_name);
		panel_login_name.setLayout(new BorderLayout(0, 0));

		panel_login_name.add(lblTest, BorderLayout.SOUTH);

		JLabel lblBienvenido = new JLabel("Bienvenido:");
		panel_login_name.add(lblBienvenido, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/AppVideo (1).png")));

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

		Button button_4 = new Button("Explorar");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(Color.LIGHT_GRAY);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_2.add(button_4);

		Button button_5 = new Button("Mis Listas");
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setForeground(Color.WHITE);
		panel_2.add(button_5);

		Button button_6 = new Button("Otras Listas");
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(Color.LIGHT_GRAY);
		panel_2.add(button_6);

		Button button_7 = new Button("Nueva Lista");
		button_7.setBackground(Color.LIGHT_GRAY);
		button_7.setForeground(Color.WHITE);
		panel_2.add(button_7);

		Button button_7_1 = new Button("Generar PDF");
		button_7_1.setForeground(Color.WHITE);
		button_7_1.setBackground(Color.LIGHT_GRAY);
		panel_2.add(button_7_1);

		/* Lo que cambia */

		JPanel pantallaPrincipal = new JPanel();
		panel_1.add(pantallaPrincipal, BorderLayout.CENTER);
		pantallaPrincipal.setLayout(new CardLayout(0, 0));

		// PanelLogin login = new PanelLogin();
		pantallaPrincipal.add(login, "login");

		// PanelRegistro registro = new PanelRegistro();
		pantallaPrincipal.add(registro, "registro");

		// PanelExplorar explorar= new PanelExplorar();
		pantallaPrincipal.add(explorar, "explorar");

		// PanelMisListas mislistas = new PanelMisListas();
		pantallaPrincipal.add(mislistas, "mislistas");

		// PanelNuevaLista nuevalistas = new PanelNuevaLista();
		pantallaPrincipal.add(nuevalistas, "nuevalista");

		// PanelRecientes recientes = new PanelRecientes();
		pantallaPrincipal.add(recientes, "recientes");

		cl = (CardLayout) (pantallaPrincipal.getLayout());
		cl.show(pantallaPrincipal, "login");

		/* action handlers */

		button.addActionListener(new ActionListener() { // BOTON REGISTRO

			public void actionPerformed(ActionEvent e) {

				switchWindow();
				activeCard = registro;
				cl.show(pantallaPrincipal, "registro");

			}

		});

		button_1.addActionListener(new ActionListener() { // BOTON LOGIN

			public void actionPerformed(ActionEvent e) {

				switchWindow();
				activeCard = login;
				cl.show(pantallaPrincipal, "login");

			}

		});

		button_2.addActionListener(new ActionListener() { // BOTON LOGOUT

			public void actionPerformed(ActionEvent e) {

				Controlador.getUnicaInstancia().logoutUsuario();
				user = null;
				setLoginName();

			}

		});

		button_3.addActionListener(new ActionListener() { // BOTON PREMIUM

			public void actionPerformed(ActionEvent e) {

				if (Controlador.getUnicaInstancia().getUsuarioActual() != null) {

					if (Controlador.getUnicaInstancia().getUsuarioActual() != null) {

						Controlador.getUnicaInstancia().getUsuarioActual().becomePremium();
						JOptionPane.showMessageDialog(frame, "Usuario Premium", "Usuario Premium",
								JOptionPane.INFORMATION_MESSAGE);

					}

				}

			}

		});

		button_4.addActionListener(new ActionListener() { // BOTON EXPLORAR

			public void actionPerformed(ActionEvent e) {

				if (Controlador.getUnicaInstancia().getUsuarioActual() != null) {
					switchWindow();
					activeCard = explorar;
					cl.show(pantallaPrincipal, "explorar");
					explorar.enter();

				}
			}

		});

		button_7.addActionListener(new ActionListener() { // BOTON NUEVA LISTA

			public void actionPerformed(ActionEvent e) {

				if (Controlador.getUnicaInstancia().getUsuarioActual() != null) {
					nuevalistas.enter();
					switchWindow();
					activeCard = nuevalistas;
					cl.show(pantallaPrincipal, "nuevalista");
				}

			}

		});

		button_5.addActionListener(new ActionListener() { // BOTON MIS LISTAS

			public void actionPerformed(ActionEvent e) {

				if (Controlador.getUnicaInstancia().getUsuarioActual() != null) {
					mislistas.enter();
					switchWindow();
					activeCard = mislistas;
					cl.show(pantallaPrincipal, "mislistas");
				}

			}

		});

		button_6.addActionListener(new ActionListener() { // BOTON RECIENTES

			public void actionPerformed(ActionEvent e) {

				if (Controlador.getUnicaInstancia().getUsuarioActual() != null) {
					recientes.enter();
					switchWindow();
					activeCard = recientes;
					cl.show(pantallaPrincipal, "recientes");
				}

			}

		});

		button_7_1.addActionListener(new ActionListener() { // BOTON GENERAR PDF

			public void actionPerformed(ActionEvent e) {

				try {
					Controlador.getUnicaInstancia().generarPdf();

					JOptionPane.showMessageDialog(null, "Documento pdf generado en la carpeta del proyecto");
				} catch (FileNotFoundException | DocumentException e1) {

					e1.printStackTrace();
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}

		});
	}

	@Override
	public void enteradoCambioEncendido(EventObject evt) {

		JFileChooser fileChooser = new JFileChooser();

		int retChooser = fileChooser.showOpenDialog(null);

		if (retChooser == JFileChooser.APPROVE_OPTION) {

			String pwd = fileChooser.getSelectedFile().getAbsolutePath();

			Controlador.getUnicaInstancia().getVideosFromXml(pwd);

		}

		else {
			JOptionPane.showMessageDialog(frame, "Sin fichero seleccionado", "Error fichero",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	public void switchWindow() { // dependiendo del card actual actuamos de una manera u otra

		// Se podria unificar haciendo que todas esas ventanas hereden de una interfaz y
		// hacer simplemente
		// cardactual.enter() o cardactual.exit()

		if (activeCard instanceof PanelExplorar) {

			explorar.exit();
		}

		else if (activeCard instanceof PanelRecientes) {

			recientes.exit();
		} else if (activeCard instanceof PanelMisListas) {
			
			mislistas.exit();
		}

		else if (activeCard instanceof PanelNuevaLista) {

			nuevalistas.exit();
		}

	}

}
