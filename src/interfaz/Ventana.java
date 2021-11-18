package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import characters.Personaje;
import juego.Juego;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;

public class Ventana extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Personaje> modeloLista1 = new DefaultListModel<Personaje>();
	private DefaultListModel<Personaje> modeloLista2 = new DefaultListModel<Personaje>();
	private VentanaCrearPersonajes vcp = new VentanaCrearPersonajes();
	public JTextArea textAreaRegistro = new JTextArea();
	private JButton btnAtacarEquipo1 = new JButton("Atacar");
	private JButton btnAtacarEquipo2 = new JButton("Atacar");
	private JButton btnMoverEquipo2 = new JButton("Mover");
	private JButton btnMoverEquipo1 = new JButton("Mover");
 
	/**
	 * Launch the application.
	 */
	 
	protected void CambiarTurno() {
		if(Juego.getInstance().CambiarTurno()) 
		{
			btnAtacarEquipo2.setEnabled(false);
			btnMoverEquipo2.setEnabled(false);
			btnAtacarEquipo1.setEnabled(true);
			btnMoverEquipo1.setEnabled(true); 
		}
		else 
		{
			btnAtacarEquipo1.setEnabled(false);
			btnMoverEquipo1.setEnabled(false);
			btnAtacarEquipo2.setEnabled(true);
			btnMoverEquipo2.setEnabled(true);
		}
		
	}
	public Ventana() {
		 
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel Main = new JPanel();
		Main.setBackground(Color.WHITE);
		contentPane.add(Main, BorderLayout.CENTER);
		GridBagLayout gbl_Main = new GridBagLayout();
		gbl_Main.columnWidths = new int[] {700, 250};
		gbl_Main.rowHeights = new int[] {450, 450};
		gbl_Main.columnWeights = new double[]{0.0, 0.0};
		gbl_Main.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		Main.setLayout(gbl_Main);
		
		JPanel Personajes = new JPanel();
		Personajes.setBorder(null);
		Personajes.setBackground(Color.WHITE);
		GridBagConstraints gbc_Personajes = new GridBagConstraints();
		gbc_Personajes.fill = GridBagConstraints.BOTH;
		gbc_Personajes.insets = new Insets(0, 0, 0, 5);
		gbc_Personajes.gridx = 0;
		gbc_Personajes.gridy = 0;
		Main.add(Personajes, gbc_Personajes);
		Personajes.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		Personajes.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel Equipo1 = new JPanel();
		Equipo1.setBackground(Color.WHITE);
		Equipo1.setBorder(new TitledBorder(null, "Equipo1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(Equipo1);
		Equipo1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		Equipo1.add(scrollPane, BorderLayout.CENTER);
		
		JList<Personaje> listEquipo1 = new JList<Personaje>();
		listEquipo1.setBorder(new TitledBorder(null, "Personajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(listEquipo1);
		listEquipo1.setModel(modeloLista1);
		
		JList<Personaje> listEquipo2 = new JList<Personaje>();
		listEquipo2.setBorder(new TitledBorder(null, "Personajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listEquipo2.setModel(modeloLista2);
		  
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		Equipo1.add(panel_2, BorderLayout.SOUTH);
		
		btnAtacarEquipo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(listEquipo1.getSelectedValue()==null) || !(listEquipo2.getSelectedValue() == null)) {
					if(listEquipo2.getSelectedValue().getVitalidad()<=0) {
						Juego.getInstance().eliminarEquipo2(listEquipo2.getSelectedIndex());
					}
					
					CambiarTurno();	
					
				}
				 
				
			}
		});
		panel_2.add(btnAtacarEquipo1);
		
		 
		panel_2.add(btnMoverEquipo1);
		JPanel Equipo2 = new JPanel();
		Equipo2.setBackground(Color.WHITE);
		Equipo2.setBorder(new TitledBorder(null, "Equipo2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(Equipo2);
		Equipo2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		Equipo2.add(scrollPane_1, BorderLayout.CENTER);
		
		scrollPane_1.setViewportView(listEquipo2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		Equipo2.add(panel_2_1, BorderLayout.SOUTH);
		
		 
		btnAtacarEquipo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(listEquipo1.getSelectedValue()==null) && !(listEquipo2.getSelectedValue() == null)) {
					
					if(listEquipo1.getSelectedValue().getVitalidad()<=0) {
						Juego.getInstance().eliminarEquipo1(listEquipo1.getSelectedIndex());
					}
					
					
					CambiarTurno();	
					
				}
			}
		});
		btnAtacarEquipo2.setEnabled(false);
		panel_2_1.add(btnAtacarEquipo2);
		
		 
		btnMoverEquipo2.setEnabled(false);
		panel_2_1.add(btnMoverEquipo2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "-", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		Main.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel Registro = new JPanel();
		panel_4.add(Registro);
		Registro.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Registro.setBackground(Color.WHITE);
		Registro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane registro = new JScrollPane();
		Registro.add(registro);
		
 		registro.setViewportView(textAreaRegistro);
	 
		
		JPanel Tittle = new JPanel();
		Tittle.setBackground(new Color(153, 204, 255));
		contentPane.add(Tittle, BorderLayout.NORTH);
		Tittle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel lblNewLabel = new JLabel("Juego de Estrategia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		Tittle.add(lblNewLabel);
		
		JPanel Botones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) Botones.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		Botones.setBackground(Color.WHITE);
		contentPane.add(Botones, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		Botones.add(panel_1);
		
		JButton btnCrear = new JButton("Crear nuevo personaje");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vcp.setVisible(true);
				actualizarListas();
		}
		});
		panel_1.add(btnCrear);
	}
	public void actualizarListas() {
		this.modeloLista1.clear();
		this.modeloLista2.clear();
		Iterator<Personaje> iterator1 =Juego.getInstance().getEquipo1().iterator();
		Iterator<Personaje> iterator2 =Juego.getInstance().getEquipo2().iterator();
	 
	
		while(iterator1.hasNext()) {
			this.modeloLista1.addElement(iterator1.next());
		}
		while(iterator2.hasNext()) {
			this.modeloLista2.addElement(iterator2.next());
		}
	
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	 

	 
}
