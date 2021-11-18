package characters;

import utilities.Posicion;

public class Arquero extends Personaje {
	protected int cantidadFlechas;
	protected double alcanceAtaqueLargo;
	public String clase ="Arquero";
	protected int danioAtaqueLargo;
 public Arquero(String nombre, Posicion posicion) {
	 super(nombre,posicion);
	 this.vitalidad = 400;
	 this.danioDeAtaque = 5;
	 this.alcanceAtaqueLargo = 100;
	 this.danioAtaqueLargo = 20;
	 this.cantidadFlechas = 20;
	 
	 
 }
 public String getClase() {
		return clase;
	}
 @Override
public String toString() {
	return "Arquero Nombre=" + nombre + " Posicion= (" + posicion.getPositionX()+","+posicion.getPositionX()+")"+" Vida= "+this.vitalidad;
}
@Override
public boolean ataca(Personaje adversario) {
	 
	boolean respuesta = false;
	
	if(this.cantidadFlechas>0) {
		if(this.distancia(adversario)<=this.alcanceAtaqueLargo) {
			adversario.recibeDanio(this.danioAtaqueLargo);
			this.cantidadFlechas--;
			respuesta = true;
		}else {
		respuesta = super.ataca(adversario);
		}
		}
	return respuesta;
	}

}
