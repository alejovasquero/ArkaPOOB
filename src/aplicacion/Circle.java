package aplicacion;

import java.io.Serializable;

public class Circle extends Figura implements Serializable{

    public static final double PI=3.1416;
    
    private int diameter;
    
    
    /**
     * Create a new circle at default position with default color.
     */
    public Circle(String color, double x, double y){
        super(x,y,color);
        diameter = 30;
    }

   


	/**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter){
       
        diameter = newDiameter;
        
    }

    public int getDiameter(){
        return diameter;
    }




	public boolean intersects(Rectangle rectangulo) {
		double w = rectangulo.getWidth();
		double h = rectangulo.getHeight();
		double xr = rectangulo.getX()+w/2;
		double yr = rectangulo.getY()-h/2;
		double xc = getX();
		double yc = getY();
		double r = getDiameter()/2;
		if(rectangulo.getY()==455) {
			//System.out.println(xc+" vs  "+xr);
		}
		return Math.abs(xc-xr) <= w/2+ r && Math.abs(yc-yr)<= h/2+r;
	}


	/**
	 * Retorna si la bola se encuentra a los lados o arriba del Bloque
	 * @param b
	 * @return
	 */
	public boolean golpePerpendicular(Rectangle b) {
		return (b.getX()<=getX() && getX()<=b.getX()+b.getWidth()) ||  
				(b.getY()-b.getHeight()<=getY() && getY()<= b.getY());  
		
	}
	

	public double distanciaMinima(Rectangle figura) {
		double ans;
		if(golpePerpendicular(figura)) {
			ans = distanciaPerpendicular(figura);
		} else {
			ans = distanciaRecta(figura);
		}
		return ans;
	}




	public double distanciaPerpendicular(Rectangle figura) {
		double minimo = Integer.MAX_VALUE;
		double xc = getX();
		double yc = getY();
		double xr = figura.getX();
		double yr = figura.getY();
		double w = figura.getWidth();
		double h = figura.getHeight();
		minimo = Math.min(minimo, Math.abs(yc-yr));
		minimo = Math.min(minimo, Math.abs(yc-(yr-h)));
		minimo = Math.min(minimo, Math.abs(xr+w-xc));
		minimo = Math.min(minimo, Math.abs(xr-xc));
		return minimo;
	}


	
	public double distanciaRecta(Rectangle figura) {
		double minimo = Integer.MAX_VALUE;
		double xc = getX();
		double yc = getY();
		double xr = figura.getX();
		double yr = figura.getY();
		double w = figura.getWidth();
		double h = figura.getHeight();
		minimo = Math.min(minimo, Math.sqrt((xc-xr)*(xc-xr) +(yc-yr)*(yc-yr)));
		minimo = Math.min(minimo, Math.sqrt((xc-xr)*(xc-xr) +(yc-(yr-h))*(yc-(yr-h))));
		minimo = Math.min(minimo, Math.sqrt((xc-(xr+w))*(xc-(xr+w)) +(yc-yr)*(yc-yr)));
		minimo = Math.min(minimo, Math.sqrt((xc-(xr+w))*(xc-(xr+w)) +(yc-(yr-h))*(yc-(yr-h))));
		return minimo;
	}
}