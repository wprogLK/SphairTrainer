package simulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Simulator extends Thread
{
	private  Wall wall;
	private JFrame windows;
	private int width;
	private int height;
	
	private boolean run=true;
	
	private Dot dot;
	/**
	 * @param args
	 */
	public Simulator(int height, int width)
	{
		
		this.height=height;
		this.width=width;
		
		this.buildShapes();
		this.buildGUI();

		
	}
	
	private void buildShapes() 
	{
		this.dot=new Dot(1,5.0);
		//TODO: Circle
		//TODO: Bar
		
		this.dot.maxPosX=this.width/2;
		this.dot.maxPosY=this.height/2;
	}
	
	public void buildGUI()
	{
		this.wall=new Wall(this.height,this.width,this.dot);
		//this.wall.add(dot);
		//this.wall.setLayout(new FlowLayout());
		this.wall.setBounds(0,0,800,800);
		this.wall.setBackground(Color.WHITE);
		
		
		this.windows =new JFrame("Sphaire Trainer");
		
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		windows.setContentPane(wall);
		
		windows.setBounds(0, 0, 800, 800);
		windows.setSize(800, 800);
		
		//windows.pack();
	

	}
	
	public void showWindow()
	{
		windows.setVisible(true);
	}
	
	public void run()
	{
		this.showWindow();
		
		while(this.run)
		{
			this.updateShapes();
			
			
			
			this.sleep();
		}
	}
	
	private void updateShapes() 
	{
		this.dot.update();
		this.wall.repaint();
		
	}

	private void sleep()
	{
		try 
		{
			Thread.sleep(26);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
