package juego;

import java.util.ArrayList;

import characters.Personaje;
import interfaz.Ventana;

public class Juego {
	 private ArrayList<Personaje> equipo1 = new ArrayList<Personaje>();
	 private ArrayList<Personaje> equipo2 = new ArrayList<Personaje>();
	 private static Juego juego;
	 private Ventana v;
	 private boolean turno = true;
	 
	private Juego() {
	 
	}
	
	public void Iniciar() 
	{
		v = new Ventana();
		v.setVisible(true);
		
	}
	public boolean CambiarTurno() {
		if(this.turno) {
			this.turno=false;
		}else {
			this.turno=true;
		}
		
		return this.turno;
	}
	public static Juego getInstance()
	{
	
		if(juego==null) 
		{
			juego = new Juego();
		}
		return juego;
	}	
	
	@Override
	public String toString() {
		return "Juego [personajes=" + equipo1 + "]";
	}

	public void agregarEquipo1(Personaje p) 
	{
		
		this.equipo1.add(p);
		
	}
	public void agregarEquipo2(Personaje p) 
	{
		
		this.equipo2.add(p);
		
	}
	
	
	public void eliminarEquipo1(int index) 
	{
		
		this.equipo1.remove(index);
		
	}
	public void eliminarEquipo2(int index) 
	{
		
		this.equipo2.remove(index);
		
	}
	
	public ArrayList<Personaje>	getEquipo1() 
	{
		return this.equipo1;
	}
	 
	public ArrayList<Personaje>	getEquipo2() 
	{
		return this.equipo2;
	}
	
	public Ventana getVentana() 
	{
		return this.v;
	}
	 

}

