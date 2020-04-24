package aplicacion;

import java.io.Serializable;

public class PlataformaEspecial extends Plataforma implements Serializable{
	public PlataformaEspecial(int x, int y) {
		super(x,y);
		
		
	}
	
	@Override
	public void moverDerecha() {
		figura.moveHorizontal(movimientoIzquierda());
				
	}
	

	@Override
	public void moverIzquierda() {
		figura.moveHorizontal(movimientoDerecha());
	}
	
}
