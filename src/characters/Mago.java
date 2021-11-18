package characters;

import utilities.Posicion;

public class Mago extends Personaje {
protected int magia;
protected int danioMagico;
public String clase ="Mago";
	public Mago(String nombre, Posicion posicion) {
		super(nombre, posicion);
		 this.magia = 5000;
		 this.vitalidad = 300;
		 this.danioDeAtaque = 3;
		 this.danioMagico = 10;
		 this.distanciaDeAtaque = 5;
	}
	public String getClase() {
		return clase;
	}
	 @Override
	 public String toString() {
	 	return "Mago Nombre=" + nombre + " Posicion= (" + posicion.getPositionX()+","+posicion.getPositionX()+")";
	 }
	@Override
	public boolean ataca(Personaje adversario) {
		 boolean respuesta = false;
		if(this.magia>=500) {
			respuesta = true;
			adversario.recibeDanio(this.danioMagico);
			this.magia -= 500;
		}else{
			if(this.distancia(adversario)<=this.distanciaDeAtaque) {
				respuesta=true;
				adversario.recibeDanio(this.danioDeAtaque);
			}
		}
		
		return respuesta;
	}
	
    public void recuperarMagia() {
    	this.magia += 250;
    }
    public void teletransportarse(double x, double y) {
    	
    	if(this.magia <= 2000) {
    	   	this.posicion.setPositionX(x);
        	this.posicion.setPositionY(y);
        	this.magia -= 2000;
    	}
     }
    public void curarAliado(Personaje aliado) {
    	
    	if(this.magia <= 1000) {
    	   	aliado.vitalidad += 100;
        	this.magia -= 1000;
    	}
     }
    
     public void curarse() {
    	
    	if(this.magia <= 1000) {
    	   	this.vitalidad += 100;
        	this.magia -= 1000;
    	}
     }
}
