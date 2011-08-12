package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Wall extends JPanel implements KeyListener
{
	private Dot dot;
	
	//General
	private int windowsHeight;
	private int windowsWidth;
	
	
	public Wall(int height, int width,Dot dot)
	{
		this.dot=dot;
		
		this.windowsHeight=height;
		this.windowsWidth=width;
		
		
		this.setFocusable(true);   // Allow this panel to get focus.
		
		this.addKeyListener(this); 
		
		this.setBackground(Color.BLACK);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.drawTemplate(g);
		
		Graphics2D g2d = (Graphics2D)g; //cast Graphics g to Graphics2D g2d
		
		this.dot.draw(g);	
		
		g2d.draw(this.dot.getShape());
		
		
	}
	

	private void drawTemplate(Graphics g) 
	{
		//Cross
		
		
		this.drawCross(g);
		this.drawCircle(g);
		this.drawBarExtras(g);
		
		//Circle
		
	}

	private void drawBarExtras(Graphics g) 
	{
		// TODO Auto-generated method stub
		
	}


	private void drawCircle(Graphics g) 
	{
		g.drawOval(2, 2, 100, 100);
		
	}


	private void drawCross(Graphics g) 
	{
		g.drawLine(this.windowsHeight/2, 0, this.windowsHeight/2, this.windowsHeight/2);
		g.drawLine(0, this.windowsWidth/2, this.windowsWidth/2, this.windowsWidth/2);	
	}


	@Override
	public void keyPressed(KeyEvent ke)
	{
		System.out.println("KEY TYPE");
		 switch (ke.getKeyCode()) 
		 {
		    case KeyEvent.VK_LEFT: 
		    {
		    	this.dot.inputX(-1);
			    break;
		    }
		      
		    case KeyEvent.VK_RIGHT: 
		    {
		    	this.dot.inputX(1);
			    break;
		    }
		    
		    case KeyEvent.VK_UP:  
		    {
		    	this.dot.inputY(-1);
			    break;
		    }
		      
		    case KeyEvent.VK_DOWN:
		    {
		    	this.dot.inputY(1);
			    break;
		    }
		 }
		 
		 this.dot.printInfo();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) 
	{
		
		
	}



	
}
