package aplicacion;

import java.io.Serializable;

public class BloqueVerde extends Bloque implements Serializable{
	/**
	 * Crea un bloque Verde
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public BloqueVerde(float x, float y) {
		super(x, y);
		setColor("Green");
		setVida(2);
		setPuntos(200);
	}
}
