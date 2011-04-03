package HTMLBuilder2;

import java.util.Vector;
import xml.ElementWithChildren;
import xml.ElementWithValue;
import xml.XMLElement;

public class HTMLPage extends ContainerTemplate<HTMLable> implements HTMLable
{
	protected final String name="HTMLPage";
	
	@Override
	public String toHTML()
	{
		String html=new String();
		ElementWithValue e1= (ElementWithValue)(doc.getElement(top));
		html=html+(e1.getValue());
		for (HTMLable e:elements)
		{
			html=html+e.toHTML();
		}
		ElementWithValue e2= (ElementWithValue)(doc.getElement(bottom));
		html=html+(e2.getValue());
		return html;
	}
}
