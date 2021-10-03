package landaluce;

import javax.swing.JFrame;

public class coche {
	
	private double miVelocidad; // Velocidad en pixels/segundo 
	protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360) 
	protected double posX; // Posición en X (horizontal) 
	protected double posY; // Posición en Y (vertical) 
	private String piloto; // Nombre de piloto
	protected double dt =1./60;
	JFrame scr;
	
	public coche(JFrame sc) {
		super();
		scr=sc;
		miVelocidad = 200;
		miDireccionActual = 0;
		posX = 200;
		posY = 200;
		piloto = "piloto";
	}


	public double getMiVelocidad() {
		return miVelocidad;
	}

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}

	public double getMiDireccionActual() {
		return miDireccionActual;
	}

	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}

	public double getPosX() {
		return posX;
	}


	public void setPosX(double posX) {
		this.posX = posX;
	}


	public double getPosY() {
		return posY;
	}


	public void setPosY(double posY) {
		this.posY = posY;
	}


	public String getPiloto() {
		return piloto;
	}


	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	
	

	
	public void update(double ace, double rot) {
		miVelocidad += ace*dt;
		miDireccionActual += rot*dt;
		
		posX += miVelocidad*Math.cos(miDireccionActual)*dt;
		posY +=  miVelocidad*Math.sin(miDireccionActual)*dt;
		
		double patallaX=scr.getContentPane().getBounds().width;
		double pantallaY=scr.getContentPane().getBounds().height;
		
		if(posX+50>patallaX) {
			posX=patallaX-50;
			miDireccionActual=-Math.PI-miDireccionActual;
		}
		if(posX+50<0) {
			posX=-50;
			miDireccionActual=-Math.PI-miDireccionActual;
		}
		if(posY+50>pantallaY) {
			posY=pantallaY-50;
			miDireccionActual=-miDireccionActual;
		}
		if(posY+50<0) {
			posY=-50;
			miDireccionActual=-miDireccionActual;
		}
		
		miDireccionActual=miDireccionActual%(2*Math.PI);
		
		miVelocidad += - 0.1*miVelocidad*dt;
		
	}
	


	


}



