package aplicacion;

import java.io.Serializable;

public class Plataforma implements Serializable{
	protected Rectangle figura;
	public static final int ANCHO = 200;
	public static final int ALTO = 50;
	public static final int AVANCE = 45;
	
	/**
	 * Crea una plataforma 
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public Plataforma(int x, int y) {
		figura = new Rectangle("Red",x,y);
		figura.changeSize(ALTO, ANCHO);
		//figura.changeColor("");
		
	}
	
	/*
	 * Mueve la plataforma hacia a la derecha
	 */
	public void moverDerecha() {
		figura.moveHorizontal(movimientoDerecha());
				
	}
	
	/**
	 * Retorna el movimiento que puede realizar hacia la izquierda sin salirse del escenario y teniendo en cuenta un avance
	 * @return Distancia de avance hacia la izquierda
	 */
	protected double movimientoIzquierda() {
		return (figura.getX()-AVANCE>=0)?
				-AVANCE:-figura.getX();
	}
	
	
	
	/**
	 * Retorna el movimiento que puede realizar hacia la derecha sin salirse del escenario y teniendo en cuenta un avance
	 * @return Distancia de avance hacia la derecha
	 */
	protected double movimientoDerecha() {
		return (figura.getX()+figura.getWidth()+ AVANCE <= ArkaPOOB.ANCHO)?
				AVANCE:ArkaPOOB.ANCHO-(figura.getX()+figura.getWidth());  
	}
	
	/**
	 * Mueve la plataforma hacia la izquierda
	 */
	public void moverIzquierda() {
		figura.moveHorizontal(movimientoIzquierda());
	}
	
	/**
	 * Retorna un arreglo con la información de la plataforma 
	 * @return Arreglo con información de la plataforma [x,y,width,height]
	 */
	public double[] demeInfo() {
		double[] ans = new double[4];
		ans[0] = figura.getX();
		ans[1] = figura.getY();
		ans[2] = figura.getWidth();
		ans[3] = figura.getHeight();
		return ans;
	}
	
	/**
	 * Cambia el valor en x de la plataforma
	 * @param x Nuevo valor en x
	 */
	public void asignarX(double x) {
		figura.setX(x);
		
	}
	
	/**
	 * Cambia el valor en y de la plataforma
	 * @param y Nuevo valor en y
	 */
	public void asignarY(double y) {
		figura.setY(y);
		
	}
	
	/**
	 * Retorna el valor en x de la plataforma
	 * @return Posicion en x
	 */
	public double getX() {
		return figura.getX();
	}
	
	/**
	 * Retorna el valor en y de la plataforma
	 * @return Posicion en y
	 */
	public double getY() {
		return figura.getY();
	}
	
	/**
	 * Retorna si la plataforma tiene propiedades pegajosas
	 * @return Si es pegajosa 
	 */
	protected boolean esPegajosa() {
		return false;
	}

	/**
	 * Retorna una representacion en ractangulo de la plataforma
	 * @return Representacion en ractangulo de la plataforma
	 */
	public Rectangle demeFigura() {
		return figura;
	}
	
	/**
	 * Asigma una bola a la plataforma
	 * @param a Bola a asignafr
	 */
	public void asignarBola(Bola a) {
		
	}
		
	
}
