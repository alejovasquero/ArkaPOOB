
package aplicacion;

import java.io.Serializable;

public abstract class Figura implements Serializable
{
    // instance variables - replace the example below with your own
    protected double xPosition;
    protected double yPosition;
    private String color;
    

    /**
     * Create a new rectangle at default position with default color.
     * Configuramos las posiciones iniciales en (0,0)
     */
    public Figura(double x, double y, String color){
        xPosition = x;
        yPosition = y;
        this.color = color;
    
    }
    
    
    /**
     * Retorna el color actual
     * @return el color de la figura
     */
    public String getColor() {
    	return color;
    }
    
    
    /**
     * Move the rectangle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the rectangle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the rectangle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }

    /**
     * Move the rectangle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(double distance){
        
        xPosition += distance;
        
    }

    /**
     * Move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(double distance){
       
        yPosition += distance;
        
    }

    /**
     * Slowly move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            
        }
    }

    /**
     * Slowly move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            
        }
    }

    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        
    }
    
    public double getX() {
    	return xPosition;
    }
    
    
    public double getY() {
    	return yPosition;
    }
    
    public void setX(double x) {
    	xPosition =x;
    }

    public void setY(double y) {
    	yPosition =y;
    }
}

