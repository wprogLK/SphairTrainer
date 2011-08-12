/**
 * 
 */
package main;

import simulator.Simulator;

/**
 * @author Lukas
 *
 */
public class Main 
{
	
	private static Simulator simulator;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{	
		if (validInput(args))
		{
			specificSimulator(args);
		}
		else
		{
			defaultSimulator();
		}
		
		
		
		simulator.start();
		
	}
	
	private static boolean validInput(String[] args)
	{
		if (args.length==2)
		{
			if(tryCastToInteger(args[0]) & tryCastToInteger(args[1]))
			{
				return true;
			}
			return false;
		}
		else
		{
			return false;
		}
	}
	
	public static void defaultSimulator()
	{
		simulator=new Simulator(600,600);
	}
	
	public static void specificSimulator(String[] args)
	{
		int height=doCastToInteger(args[0]);
		int width=doCastToInteger(args[1]);
		
		simulator=new Simulator(height,width);
	}
	
	public final static boolean tryCastToInteger(String input)
	{
		try
		{
			int inputInteger=Integer.parseInt(input);
			return true;
		}
		catch(ClassCastException e)
		{
			return false;
		}
	}
	

	public final static Integer doCastToInteger(String input)
	{
		try
		{
			int inputInteger=Integer.parseInt(input);
			return inputInteger;
		}
		catch(ClassCastException e)
		{
			return null;
		}
	}
	

}
