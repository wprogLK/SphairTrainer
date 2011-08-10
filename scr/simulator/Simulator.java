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
	
	private boolean run=true;
	
	private Dot dot;
	/**
	 * @param args
	 */
	public Simulator()
	{
		this.buildShapes();
		this.buildGUI();
		
	}
	
	private void buildShapes() 
	{
		this.dot=new Dot(1,5.0);
		//TODO: Circle
		//TODO: Bar
		
		//this.panel.add(this.dot);
		//this.panel.add(this.circle);
		//this.panel.add(this.bar);
	}
	
	public void buildGUI()
	{
		this.wall=new Wall(1000,1000,this.dot);
		//this.wall.add(dot);
		//this.wall.setLayout(new FlowLayout());
		this.wall.setBounds(0,0,1000,1000);
		this.wall.setBackground(Color.WHITE);
		
		
		this.windows =new JFrame("Sphaire Trainer");
		
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		windows.setContentPane(wall);
		
		windows.setBounds(0, 0, 200, 200);
		
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
			Thread.sleep(100);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
