package aplicacion;

import java.io.Serializable;

public class Pared implements Dividible, Serializable{
	private static final Pared[] paredes = new Pared[4];
	static {
		paredes[0] = new Pared();
		paredes[1] = new Pared();
		paredes[2] = new Pared();
		paredes[3] = new Pared();
	}
	
	
	public static Pared demeParedDerecha() {
		return paredes[0];
	}
	
	public static Pared demeParedizquierda() {
		return paredes[1];
	}
	
	public static Pared demeParedInferior() {
		return paredes[2];
	}
	
	public static Pared demeParedSuperior() {
		return paredes[3];
	}
	
}
