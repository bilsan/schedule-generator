package pseudoServlets;

import htmlBuilder.Site;
import htmlInterfaces.HTMLInterfaceTool;
import java.util.Vector;

import dataStructure.Course;
import dataStructure.Program;
import dataStructure.Student;
import database.Database;

/**
 * @author Zjef
 * @version 1.0
 */
public class StudentTable extends TabAndList<Student>
{
	public StudentTable() 
	{
		super();
	}
	
	@Override
	protected String createExpandScript(Vector<Student> students) 
	{
		String res="";
		int counter=1;
		for (Student i:students)
		{
			res+="if (nTr.id=='"+counter+"'){";
			res+="return '";
			res+="<b>##Programs##</b>";
			if (i.getPrograms()!=null && i.getPrograms().size()>0)
			{
				res+=HTMLInterfaceTool.changeToDataTable("expandTable",i.getPrograms());
			}
			else
			{
				res+=HTMLInterfaceTool.makeEmptyTable("expandTable",Program.class);
			}
			res+="<b>##Courses##</b>";
			if (i.getCourses()!=null && i.getCourses().size()>0)
			{
				res+=HTMLInterfaceTool.changeToDataTable("expandTable2",i.getCourses());
			}
			else
			{
				res+=HTMLInterfaceTool.makeEmptyTable("expandTable2",Course.class);
			}
			res+="';}";
			counter++;
		}
		return res;
	}
	
	@Override
	protected String createInitDatatable() 
	{
		return "\\$('#expandTable').dataTable();\\$('#expandTable2').dataTable();";
	}

	@Override
	protected Vector<Student> getTableObjects(String faculty, String program) 
	{
		Database db=getDB();
		db.connect();
		Program p=db.read(new database.Search(Program.class,program));
		if (p==null)
		{
			return new Vector<Student>();
		}
		Vector<Student> students=db.readAll(new database.Search(program,Student.class,"getPrograms"));
//		Vector<Student> students=db.readAll(new database.Search(p.getID().toString(),Student.class,"getPrograms"));
		db.disconnect();
//		for (Student s:(Vector<Student>)students.clone())
//		{
//			if (!s.getPrograms().contains(p))
//			{
//				students.remove(s);
//			}
//		}
		return students;
	}

	@Override
	public TabName getTabName()
	{
		return TabName.Students;
	}
}