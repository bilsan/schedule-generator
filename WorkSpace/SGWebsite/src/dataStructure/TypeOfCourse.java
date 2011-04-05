package dataStructure;

import database.*;
import htmlInterfaces.HTMLTablable;
import htmlInterfaces.HTMLTablable.*;

/**
 * Deze klasse een XML bestand bevatten met daarin alle mogelijke types van lessen (e.g. HOC, WPO, presentatie,...)
 * 
 * 
 * @author matthiascaenepeel
 * @version2.0
 */

public class TypeOfCourse implements Databasable
{
private String coursetypes;
	
	public TypeOfCourse(String coursetypes)
	{
		this.coursetypes = coursetypes;
	}
	
	private ID id;
	
	@Override
	public void setID(ID id)
	{
		this.id=id;
	}
	
	@Override
	public ID getId()
	{
		return id;
	}
}
