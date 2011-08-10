/**
 * 
 */
package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * @author Lukas
 *
 */
public class Dot extends MyShape {

	
	/**
	 * 
	 */
	public Dot(int difficultyLevel, double sensibility)
	{
		super(difficultyLevel,sensibility);
		
		this.posX=0;
		this.posY=0;
		
		this.name="Dot";
		
		//this.setBounds(0, 0, this.diameter*10,  this.diameter*10);
	}

	@Override
	protected void changeVelocityRandom() 
	{
		
		
	}

	public void inputX(int x)
	{
		this.velocityX+=x;
	}
	
	public void inputY(int y)
	{
		this.velocityY+=y;
	}
	
	public void draw(Graphics g)
	{
		//TODO: do it with a image not a rectangle
		//super.repaint();
		this.aTrans.setToTranslation(posX, posY); 	//Copy the position into a matix
		
		Graphics2D g2d = (Graphics2D)g; //cast Graphics g to Graphics2D g2d
		g2d.setColor(Color.BLUE);
		
		Rectangle2D.Double hum=new Rectangle2D.Double(posX, posY, this.diameter, this.diameter);
		
	//	setCenter(hum);
		
		
		
		//this.rotate(); //rotate if human want to ...
		
		
		this.shape= aTrans.createTransformedShape(hum);
		
		
		
		
//TODO: do it with a image not a rectangle
		
		
		
	}

	
}
