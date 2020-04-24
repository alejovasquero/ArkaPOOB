package aplicacion;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class PlataformaPegajosa extends Plataforma implements Serializable{
	private Bola pibote;
	private int turnos;
	
	public PlataformaPegajosa(int x, int y) {
		super(x,y);
		pibote = null;
		turnos = 3;
	}
	
	public void setPibote(Bola a) {
		pibote = a;
	}
	
	
	@Override
	public void asignarBola(Bola a) {
		if(pibote == null && turnos>0) {
			pibote = a;
			
			a.hacerVelocidadNula();
			turnos--;
			pibote.moveHorizontal( getX()+Plataforma.ANCHO/2 - a.getX());
			pibote.moveVertical(getY() - (a.getY() - Bola.radio));
			lanzarBola();
			
		}
		
	}
	@Override
	public void moverDerecha() {
		if(pibote!= null) {
			pibote.moveHorizontal(movimientoDerecha());
		}
		super.moverDerecha();
		
	}
	
	@Override
	public void moverIzquierda() {
		if(pibote!= null) {
			pibote.moveHorizontal(movimientoIzquierda());
		}
		super.moverIzquierda();
	}
	
	protected boolean esPegajosa() {
		return true;
	}
	
	private void lanzarBola() {
		if(pibote!= null) {
			try {
				TimeUnit.SECONDS.sleep(2);
				pibote.ignicion();
				pibote = null;
				
			} catch (InterruptedException | NullPointerException e) {
			}
		}
	}
	
}
