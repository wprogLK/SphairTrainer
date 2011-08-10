package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Wall extends JPanel implements KeyListener 
{
	private Dot dot;
	
	private int windowsHeight;
	private int windowsWidth;
	
	public Wall(int height, int width,Dot dot)
	{
		this.dot=dot;
		
		this.windowsHeight=height;
		this.windowsWidth=width;
		
		this.add(dot);
		
		this.setFocusable(true);   // Allow this panel to get focus.
		this.addKeyListener(this); 
		
		this.setBackground(Color.BLUE);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.drawTemplate(g);
		
		Graphics2D g2d = (Graphics2D)g; //cast Graphics g to Graphics2D g2d
		
		this.dot.draw(g);	//OLD
		
		g2d.draw(this.dot.getShape());
		
		//this.dot.repaint(); //OLD
	}
	
//	public void draw(Graphics g)
//	{
//		//TODO: do it with a image not a rectangle
//		
//		super.repaint();
//		
//		//this.dot.draw(g);
//		this.dot.repaint();
//	}

	private void drawTemplate(Graphics g) 
	{
		//Cross
		g.drawLine(this.windowsHeight/2, 0, this.windowsHeight/2, this.windowsHeight/2);
		
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
