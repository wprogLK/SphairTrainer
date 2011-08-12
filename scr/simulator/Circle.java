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
public class Circle extends MyShape {

	
	
	/**
	 * 
	 */
	public Circle(int difficultyLevel, double sensibility)
	{
		super(difficultyLevel,sensibility);
		
		this.posX=0;
		this.posY=0;
		this.diameter=20;
		this.name="Circle";
	}

	
	

	@Override
	protected void changeVelocityRandom() 
	{
		Random rnd=new Random();
		
		double valueScale=rnd.nextInt(2)/10;
		
		boolean isPositiv=rnd.nextBoolean();
		
		if (!isPositiv)
		{
			valueScale*=(-1);
		}
		
		this.inputScale(valueScale);
	}

	public void inputScale(double s)
	{
		this.velocityScale+=s;	
		
		
	}
	
	
	public void draw(Graphics g)
	{
		this.aTrans.setToTranslation(posX, posY); 	//Copy the position into a matix
		this.aTrans.setToScale(this.scaleFactor, this.scaleFactor);
		Graphics2D g2d = (Graphics2D)g; //cast Graphics g to Graphics2D g2d
		g2d.setColor(Color.RED);
		//TODO
		Rectangle2D.Double rec=new Rectangle2D.Double(posX, posY, this.diameter, this.diameter);

		this.shape= aTrans.createTransformedShape(rec);
	}





	
	
}
