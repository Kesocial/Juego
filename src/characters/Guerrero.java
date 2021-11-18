package characters;

import utilities.Posicion;

public class Guerrero extends Personaje{
	public String clase ="Guerrero";
	public Guerrero(String nombre, Posicion posicion) {
		super(nombre,posicion);this.vitalidad = 500;
		this.danioDeAtaque = 10;	
		this.distanciaDeAtaque = 10;
	}
	 @Override
	 public String toString() {
	 	return "Guerrero Nombre=" + nombre + " Posicion= (" + posicion.getPositionX()+","+posicion.getPositionX()+")";
	 }
	 public String getClase() {
			return clase;
		}
}
