package aplicacion;

import java.io.Serializable;

public class BloqueRojo extends Bloque implements Serializable{
	/**
	 * Crea un bloque Rojo
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public BloqueRojo(float x, float y) {
		super(x, y);
		setColor("Red");
		setVida(1);
		setPuntos(100);
	}

}
