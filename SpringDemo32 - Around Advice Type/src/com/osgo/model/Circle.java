package com.osgo.model;

public class Circle
{
	private String name;
	

	public String getName()
	{
		return name;
	} // end method getName
	

	public void setName(String name)
	{
		this.name = name;
		System.out.println("Circle's setter called.");
		throw (new RuntimeException());
		
	} // end method setName
	
	
	public String setNameAndReturn(String name)
	{
		this.name = name;
		System.out.println("Circle's setter called.");
		return name;
	} // end method setName
	
	
} // end Class Circle