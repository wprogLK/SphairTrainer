/**
 * 
 */
package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Random;

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
		Random rnd=new Random();
		
		int valueX=rnd.nextInt(2);
		int valueY=rnd.nextInt(2);
		
		boolean isPositivX=rnd.nextBoolean();
		boolean isPositivY=rnd.nextBoolean();
		
		if (!isPositivX)
		{
			valueX*=(-1);
		}
		
		if (!isPositivY)
		{
			valueY*=(-1);
		}
		
		this.inputX(valueX);
		this.inputY(valueY);
	}

	public void inputX(int x)
	{
		this.velocityX+=x;	//FOR KEY
		//this.posX=x;			//FOR MOUSE
		
		
	}
	
	public void inputY(int y)
	{
		this.velocityY+=y;	//FOR KEY
		//this.posY=y;			//FOR MOUSE
	}
	
	public void draw(Graphics g)
	{
		this.aTrans.setToTranslation(posX, posY); 	//Copy the position into a matix
		
		Graphics2D g2d = (Graphics2D)g; //cast Graphics g to Graphics2D g2d
		g2d.setColor(Color.BLUE);
		
		Rectangle2D.Double rec=new Rectangle2D.Double(posX, posY, this.diameter, this.diameter);

		this.shape= aTrans.createTransformedShape(rec);
	}





	
	
}
