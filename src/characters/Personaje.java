package characters;

import utilities.Posicion;

public abstract class Personaje {

protected String nombre;
protected int vitalidad;
protected Posicion posicion;
protected int danioDeAtaque;
protected double distanciaDeAtaque;
protected String clase;
 

public abstract String getClase();
public Personaje(String nombre, Posicion posicion) {
	super();
	this.nombre = nombre;
	this.posicion = posicion;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getVitalidad() {
	return vitalidad;
}
public void setVitalidad(int vitalidad) {
	this.vitalidad = vitalidad;
}
public Posicion getPosicion() {
	return posicion;
}
public void setPosicion(Posicion posicion) {
	this.posicion = posicion;
}
public int getDanioDeAtaque() {
	return danioDeAtaque;
}
public void setDanioDeAtaque(int danioDeAtaque) {
	this.danioDeAtaque = danioDeAtaque;
}
public double getDistanciaDeAtaque() {
	return distanciaDeAtaque;
}
public void setDistanciaDeAtaque(double distanciaDeAtaque) {
	this.distanciaDeAtaque = distanciaDeAtaque;
}


 public void setPosX(double posX) {
	 posicion.setPositionX(posX);
 } 
 public double getPosX() {
	 return posicion.getPositionX();
 }
 
 @Override
public String toString() {
	return "Personaje Nombre=" + nombre + " Posicion= (" + posicion.getPositionX()+","+posicion.getPositionX()+")";
}
public void recibeDanio(int cantidad) {
	 this.vitalidad -= cantidad;
 }
 public double distancia(Personaje otro) {
	 return this.posicion.distancia(otro.getPosicion());
}
 public boolean ataca(Personaje adversario) {
	boolean respuesta = false;
	if(this.distancia(adversario) <= this.distanciaDeAtaque){
	respuesta = true;
	adversario.recibeDanio(this.danioDeAtaque);
	}
	return respuesta;
 }

}
