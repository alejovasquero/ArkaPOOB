package aplicacion;

import java.io.Serializable;

public abstract class Bloque implements Dividible,Serializable{
	public static final int ALTURA = 35;
	public static final int BASE = 75;
	
	private aplicacion.Rectangle figura;
	private int vida;
	private int puntos;
	
	/**
	 * Inicializa un bloque
	 * @param x Posicion en x del bloque
	 * @param y Posicion en y del bloque
	 */
	public Bloque(float x, float y) {
		figura = new aplicacion.Rectangle("Black", x,y);
		figura.changeSize(ALTURA, BASE);
		figura.changeColor("Yellow");
		vida = 1;
	}
	
	
	/**
	 * Retorna la posicion en x del bloque
	 * @return Posicion en x del bloque
	 */
	public double getX() {
    	return figura.getX();
    }
    
	/**
	 * Retorna la posicion en y del bloque
	 * @return Posicion en y del bloque (Parte superior del bloque)
	 */
    public double getY() {
    	return figura.getY();
    }
    
    
    /**
     * Retorna el ancho del bloque
     * @return Ancho del bloque
     */
    public double getWidth() {
    	return figura.getWidth();
    }
    
    /**
     * Retorna el alto del bloque
     * @return Alto del bloque
     */
    public double getHeight() {
    	return figura.getHeight();
    }
    
    
    /**
	 * Retorna el color del bloque
	 * @return Color del bloque
	 */
    public String getColor() {
    	return figura.getColor();
    }
	
    
    
    /**
     * Retorna la vida que tiene el bloque
     * @return Vida del bloque
     */
    public int getVida() {
    	return vida;
    }


    /**
     * Retorna la representacion en rectangulo del bloque
     * @return Rectangulo que representa al bloque
     */
	public Rectangle demeFigura() {
		return figura;
	}


	/**
	 * Golpea al bloque dado una Bola
	 * @param a Bola de choque
	 */
	public void golpear(Bola a) {
		if(vida>0) {
			vida--;
			if(vida==0) {
				concederBeneficio();
			}
		}
		
	}
	
	/**
	 * Cambia la vida del bloque
	 * @param nueva Nueva vida
	 */
	protected void setVida(int nueva) {
		vida = nueva;
	}
    
	/**
	 * Retorna los puntos que da el bloque
	 * @return Puntos que concede el bloque
	 */
	protected int getPuntos() {
		return puntos;
	}
	
	/**
	 * Cambia los puntos que da el bloque
	 * @param nuevos Nuevos puntos
	 */
	protected void setPuntos(int nuevos) {
		puntos = nuevos;
	}
	
	/**
	 * Cambia el color del bloque
	 * @param color Nuevo Color para el bloque
	 */
	protected void setColor(String color) {
		figura.changeColor(color);
	}
	
	/**
	 * Concede el beneficio que da cada bloque
	 */
	protected void concederBeneficio() {
		ArkaPOOB.darPuntos(getPuntos());
	}
	
	
}
