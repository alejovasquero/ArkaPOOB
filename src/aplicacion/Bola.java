package aplicacion;

import java.io.Serializable;

public class Bola  implements Serializable{
	private aplicacion.Circle figura;
	public static final int radio = 15;
	private Vector velocidad;
	
	public static final double VELOCIDAD_BAJA = 0.00005;
	public static final double VELOCIDAD_MEDIO_BAJA = 0.00007;
	public static final double VELOCIDAD_MEDIA = 0.00009;
	public static final double VELOCIDAD_ALTA = 0.0001;
	public static final double VELOCIDAD_EXTREMA = 0.0002;
	
	private Dividible ultimoChoque;
	
	/**
	 * Crea una bola
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public Bola(double x, double y) {
		figura =  new Circle("Red",x,y);
		figura.changeSize(radio*2);
		velocidad = new Vector(30, VELOCIDAD_BAJA);
		ultimoChoque = null;
	}
	
	/**
	 * Hace la velocidad de la bola nula(0)
	 */
	public void hacerVelocidadNula() {
		velocidad.setModulo(0);
	}
	
	
	/**
	 * Retorna la posicion en x de la bola
	 * @return Posicion en x de la bola(Centro)
	 */
	public double getX() {
		return figura.getX();
	}
	
	/**
	 * Retorna la posicion en y de la bola
	 * @return Posicion en y de la bola(Centro)
	 */
	public double getY() {
		return figura.getY();
	}
	
	
	/**
	 * Mueve la bola horizontalmente d veces
	 * @param d Cantidad de movimiento horizontal
	 */
	public void moveHorizontal(double d) {
		figura.moveHorizontal(d);
		
	}
	
	/**
	 * Mueve la bola verticalmente d veces
	 * @param d Cantidad de movimiento vertical
	 */
	public void moveVertical(double d) {
		figura.moveVertical(d);
		
	}
	
	/**
	 * Lanza la bola con cierta velocidad y angulo
	 */
	public void ignicion() {
		velocidad.setAngulo(45);
		velocidad.setModulo(VELOCIDAD_EXTREMA);
		
	}
	
	/**
	 * Mueve la bola dada su dirección y velocidad 
	 */
	public void avanzar() {
		moveHorizontal(velocidad.accesoHorizontal());
		moveVertical(velocidad.accesoVertical());
	}
	
	/**
	 * Cambia el angulo de movimiento dado una pared
	 * @param a Pared de rebote
	 */
	private void accionReflejar(Pared a) {
		if(a==Pared.demeParedDerecha() || a == Pared.demeParedizquierda()) {
			velocidad.reflejar(Vector.VERTICAL);
			
		} else if(a==Pared.demeParedInferior() || a == Pared.demeParedSuperior()){
			
			velocidad.reflejar(Vector.HORIZONTAL);
		}
	}
	
	/**
	 * Rebota con respecto a un objeto dividible y una pared de este objeto
	 * @param pibote Objeto de rebote
	 * @param b Pared de rebote
	 */
	public void reflejar(Dividible pibote, Pared b) {
		if(pibote!=null) {
			ultimoChoque = pibote;
		}
		accionReflejar(b);
	}
	
	/**
	 * Retorna el ultimo objeto de rebote de la bola
	 * @return Ultimo objeto contra el que reboto la bola
	 */
	public Dividible getdividible() {
		return ultimoChoque;
	}
	
	/**
	 * Retorna si al bola se intersecta con un rectangulo dado
	 * @param rectangulo Rectangulo de interseccion
	 * @return Si se intersectan
	 */
	public boolean intersects(Rectangle rectangulo) {
		return figura.intersects(rectangulo);
	}
	
	/**
	 * La distancia minima de la bola con respecto a los borders o lados
	 * @param j Bloque para la distancia
	 * @return La distancia entre la bola y el bloque
	 */
	public double distanciaMinima(Bloque j) {
		return figura.distanciaMinima(j.demeFigura());
		
	}
	
	/**
	 * La distancia de la bola a uno de los lados del bloque
	 * @param j Bloque para buscar distancia
	 * @return Distancia entre el circulo y un lado del bloque
	 */
	public double distanciaPerpendicular(Bloque j) {
		return figura.distanciaPerpendicular(j.demeFigura());
	}
}
