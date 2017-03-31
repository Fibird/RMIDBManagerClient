/**
 * 
 */
package cc.chaoyangliu.rmiprac.service;

import java.rmi.*;
import java.util.*;

import javax.swing.JOptionPane;

//import cc.chaoyangliu.rmiprac.service.DataService;

/**
 * @author bird
 *
 */
public class RmiClientTest {

	/**
	 * 
	 */
	public RmiClientTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int port = 1235;
		// Test Data
		String [] ns = {"Mary", "Mike", "Tony"};
		String [] ids = {"201401", "201402", "201403"};
		String [] tbs = {"t1", "t2", "t3"};
		int [] gs = {98, 86, 78};
		int grade = 0;
		DataService ds;
		
		ArrayList<Student> ss = new ArrayList<Student>();
		for (int i = 0; i < 3; i++)
		{
			ss.add(new Student(ns[i], ids[i], gs[i]));
		}
		
		try {
			ds = (DataService) Naming.lookup("//localhost:" + port + "/ds");
			ds.connDataBase("root", "root", "rmijdbc");
			System.out.println("---------Test of Creating Table---------");
			System.out.println("Creating...");
			ds.createTable("grade");
			
			System.out.println("Table Creation Sucess!\n");
			
			System.out.println("---------Test of inserting Data---------");
			System.out.println("Inserting...");
			for (Student s : ss)
			{
				ds.addGrade("grade", s.getName(), s.getId(), s.getGrade());
			}	
			System.out.println("Insert these data:");
			for (Student s : ss)
				System.out.println(s);
			
			System.out.println();
			System.out.println("---------Test of Querying Data---------");
			System.out.println("Querying...");
			for (Student s : ss)
			{
				grade = ds.queryGrade("grade", s.getId());
				System.out.println("The grade of " + s.getId() + "is " + grade);
			}
			System.out.println("Data Query Success!\n");
			System.out.println("---------Test of showing tables---------");
			for (int i = 0; i < tbs.length; i++) {
				ds.createTable(tbs[i]);
			}
			ArrayList<String> a = ds.showTables();

			for (int i = 0; i < a.size(); i++) {
				System.out.println(i + " " + a.get(i));
			}
			System.out.println("Showing Tables Success!\n");
			System.out.println("Nice! Everything is well!");
			ds.free();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
			
	}

}
