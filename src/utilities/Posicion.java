package utilities;

public class Posicion {
 
	private double positionX;
	private double positionY;
	
	public Posicion(double positionX, double positionY) {
		
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public double getPositionX() {return this.positionX;}
	public double getPositionY() {return this.positionY;}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public double distancia(Posicion otro) {
		double distanciaEntre = 0;
		
		double A = Math.pow((otro.getPositionX()-this.positionX),2);
		double B = Math.pow((otro.getPositionY()-this.positionY),2);
		distanciaEntre = Math.sqrt((A+B)); 
		
		return distanciaEntre;
	}
}

