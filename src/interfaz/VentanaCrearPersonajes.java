package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import characters.Personaje;
import juego.Juego;
import characters.Arquero;
import characters.Caballero;
import characters.Guerrero;
import characters.Mago;
import utilities.Posicion;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaCrearPersonajes extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelCreacionDePersonaje;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel labelNombre;
	private JTextField textFieldNombre;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel labelClase;
	private JPanel panel_5;
	private JButton btnCrear;
	private JComboBox comboBoxClaseNuevoPersonaje;
	private Personaje p;
	private JPanel panel_6;
	private JRadioButton radioEquipo1;
	private JRadioButton radioEquipo2;
	private final ButtonGroup buttonGroupEquipos = new ButtonGroup();

	 
	public VentanaCrearPersonajes() {
		this.setTitle("Crear Personaje");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		this.panelCreacionDePersonaje = new JPanel();
		this.panelCreacionDePersonaje.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.panelCreacionDePersonaje);
		this.panelCreacionDePersonaje.setLayout(new GridLayout(4, 0, 0, 0));
		setLocationRelativeTo(null);
		this.panel_3 = new JPanel();
		this.panelCreacionDePersonaje.add(this.panel_3);
		FlowLayout fl_panel_3 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		fl_panel_3.setAlignOnBaseline(true);
		this.panel_3.setLayout(fl_panel_3);
		
		this.panel = new JPanel();
		this.panel_3.add(this.panel);
		
		this.labelNombre = new JLabel("Nombre");
		this.panel.add(this.labelNombre);
		
		this.textFieldNombre = new JTextField();
		this.panel.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(10);
		
		this.panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) this.panel_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		this.panelCreacionDePersonaje.add(this.panel_1);
		
		this.panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.panel_1.add(this.panel_4);
		
		this.labelClase = new JLabel("Clase");
		this.panel_4.add(this.labelClase);
		
		this.comboBoxClaseNuevoPersonaje = new JComboBox();
		this.comboBoxClaseNuevoPersonaje.setModel(new DefaultComboBoxModel(new String[] {"Guerrero", "Caballero", "Arquero", "Mago"}));
		this.panel_4.add(this.comboBoxClaseNuevoPersonaje);
		
		panel_6 = new JPanel();
		panelCreacionDePersonaje.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		radioEquipo1 = new JRadioButton("Equipo 1");
		buttonGroupEquipos.add(radioEquipo1);
		radioEquipo1.setName("equipos");
		radioEquipo1.setSelected(true);
		panel_6.add(radioEquipo1);
		
		radioEquipo2 = new JRadioButton("Equipo 2");
		buttonGroupEquipos.add(radioEquipo2);
		radioEquipo2.setName("equipos");
		panel_6.add(radioEquipo2);
		
		this.panel_2 = new JPanel();
		this.panelCreacionDePersonaje.add(this.panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		this.panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) this.panel_5.getLayout();
		this.panel_2.add(this.panel_5);
		
		this.btnCrear = new JButton("Crear");
		this.btnCrear.addActionListener(this);
		this.panel_5.add(this.btnCrear);
	}

	 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnCrear) {
			do_btnCrear_actionPerformed(e);
		}
	}
	protected void do_btnCrear_actionPerformed(ActionEvent e) {
		  String contenido = Juego.getInstance().getVentana().textAreaRegistro.getText();
			
		if(!this.textFieldNombre.getText().equals("")) {
			System.out.println(this.textFieldNombre.getText());
			 switch((String) this.comboBoxClaseNuevoPersonaje.getSelectedItem()) {
			 case "Caballero":
				 this.p = new Caballero(this.textFieldNombre.getText(), new Posicion(0,0));
				 break;
			 case "Guerrero":
				 this.p = new Guerrero(this.textFieldNombre.getText(), new Posicion(0,0));
				 break;
			 case "Arquero":
				 this.p = new Arquero(this.textFieldNombre.getText(), new Posicion(0,0));
				 break;
			 case "Mago":
				 this.p = new Mago(this.textFieldNombre.getText(), new Posicion(0,0));
				 break;
			 } 
			 String equipo="0";
			 if(this.radioEquipo1.isSelected()) {
				 Juego.getInstance().agregarEquipo1(p); 
				 equipo = "1";
			 }else {
				 Juego.getInstance().agregarEquipo2(p);
				 equipo = "2";
			 }
			 Juego.getInstance().getVentana().actualizarListas();;
			 contenido += "Se creo un nuevo " + p.getClase()+" en el equipo "+equipo+"\n";
			 Juego.getInstance().getVentana().textAreaRegistro.setText(contenido);;
			 System.out.println(p.toString());
			 this.dispose();
		}
	
	}

	public Personaje getP() {
		return p;
	}
}
