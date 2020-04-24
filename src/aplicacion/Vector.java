package aplicacion;

import java.io.Serializable;

public class Vector implements Serializable{
	private double angulo;
	private double modulo;
	public static final int HORIZONTAL = 1;
	public static final int VERTICAL = 2;
	
	
	public Vector(double angulo, double modulo) {
		this.modulo =  modulo;
		this.angulo = angulo;
	}
	
	public void setAngulo(double nuevo) {
		angulo =  nuevo;
	}
	
	public double getAngulo() {
		return angulo;
	}
	
	public void setModulo(double nuevo) {
		modulo =  nuevo;
	}
	
	public double getModulo() {
		return modulo;
	}

	public double accesoHorizontal() {
		
		return modulo*Math.cos(Math.toRadians(angulo));
	}

	public double accesoVertical() {
		
		return modulo*Math.sin(Math.toRadians(angulo));
	}
	
	
	public void reflejar(int direccion) {
		if(direccion == HORIZONTAL) {
			angulo = 360 - angulo;
		} else if(direccion == VERTICAL) {
			angulo = 180 - angulo;
		}
		
		
	}
	
	
	
}
