package aplicacion;

import java.awt.*;
import java.io.Serializable;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */


 
public class Rectangle extends Figura implements Serializable{

    private double height;
    private double width;
    

    /**
     * Create a new rectangle at default position with default color.
     * Configuramos las posiciones iniciales en (0,0)
     */
    public Rectangle(String color, double x, double y){
        super(x,y,color);
        height = 30;
        width = 40;
    }
    

    
    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        
        height = newHeight;
        width = newWidth;
        
    }
    
    public double getWidth() {
    	return width;
    }
    
    
    public double getHeight() {
    	return height;
    }
    
    
    
    
}

