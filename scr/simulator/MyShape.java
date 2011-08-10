/**
 * 
 */
package simulator;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

/**
 * @author Lukas
 *
 */
public abstract class MyShape extends Container
{
	protected Shape shape;
	
	protected String name="MyShape";
	
	protected double diameter=20;
	
	protected AffineTransform aTrans=new AffineTransform();
	
	protected double posX;
	protected double posY;
	
	protected double scaleFactor;
	
	protected double angle;
	
	
	protected double velocityX;
	protected double velocityY;
	
	protected double velocityAngle;
	
	protected double velocityScale;
	
	
	
	protected double maxPosX;
	protected double minPosX;
	
	protected double maxPosY;
	protected double minPosY;
	
	
	protected double maxScaleFactor;
	protected double minScaleFactor;
	
	
	protected double maxAngle;
	protected double minAngle;
	
	/**
	 * can be between 1 and 10; 5 is normal 10 is more; 1 is less
	 */
	protected double sensibility;
	
	/**
	 * can be between 1 (=easy) and 6(=ultimative hard)
	 */
	protected int difficultyLevel;		
	
	protected final int startCounter=6;
	protected int counter;		
	
	
	public MyShape(int difficultyLevel, double sensibility)
	{
		this.setDifficultyLevel(difficultyLevel);
		this.setSensibilityLevel(sensibility);
		
		this.aTrans.setToTranslation(0, 0);
		this.setPreferredSize(new Dimension((int) this.diameter,(int) this.diameter)); 
	}
	
	public Shape getShape()
	{
		return this.shape;
	}
	
	/*
	public void setMaxAndMinPos(double maxPosX, double minPosX, double maxPosY, double minPosY)
	{
		this.maxPosX=maxPosX;
		this.minPosX=minPosX;

		this.maxPosY=maxPosY;
		this.minPosY=minPosY;
	}
	
	public void setMaxAndMinScale(double maxScaleFactor, double minScaleFactor)
	{
		this.maxScaleFactor=maxScaleFactor;
		this.minScaleFactor=minScaleFactor;
	}
	
	public void setMaxAndMinAngle(double maxAngle, double minAngle)
	{
		this.maxAngle=maxAngle;
		this.minAngle=minAngle;
	}
	
	private void setMaxAndMinDefault()
	{
		this
	}
	*/
	
	public void update()
	{
		this.checkForChange();
		this.updateMove();
		this.move();
		//this.repaint();	//OLD
	}
	
	public AffineTransform getAffineTransform()
	{
		return this.aTrans;
	}
	
	private void move() 
	{
		this.aTrans.translate(this.posX, this.posY);
		this.aTrans.rotate(this.angle);
		this.aTrans.scale(this.scaleFactor, this.scaleFactor);
		
		//this.setBounds((int) this.posX, (int) this.posY, this.diameter, this.diameter);
	}
	
	private void checkForChange() 
	{
		if (this.counter==0)
		{
			System.out.println("Change!");
			this.changeVelocityRandom();
			this.resetCounter();
		}
		else
		{
			//this.printInfo();
			this.counter--;
		}
	}

	private void setDifficultyLevel(int level)
	{
		this.difficultyLevel=level;
	}
	
	private void setSensibilityLevel(double level)
	{
		this.sensibility=level;
	}
	
	private void resetCounter()
	{
		this.counter=this.startCounter;
	}
	
	protected abstract void changeVelocityRandom();
	protected abstract void draw(Graphics g);
	
	
	private  void updateMove()
	{
		this.posX=this.posX+this.velocityX;
		this.posY=this.posY+this.velocityY;
		
		this.angle=this.angle+this.velocityAngle;
		
		this.scaleFactor=this.scaleFactor+this.velocityScale;
	}
	
	public void printInfo()
	{
		System.out.println("Name: " + this.name);
		System.out.println("posX: " + this.posX);
		System.out.println("posY: " + this.posY);
		System.out.println("veloX: " + this.velocityX);
		System.out.println("veloY: " + this.velocityY);
	} 
	

}
