package cs1302.projects;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Demo {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

	
		
		SortedDblList m = new SortedDblList();
		SortedDblList n = new SortedDblList();
		
		Person s2 = new Student("Brandon", "Lewis", 100, null, "CompSci");
		Person s3 = new Student("Brandon", "Lewis", 200, null, "CompSci");
		Person s4 = new Student("Brandon", "Lewis", 50, null, "CompSci");
		Person s5 = new Student("Brandon", "Lewis", 50, null, "CompSci");
		
		Person a2 = new Person("Brandon", "Lewis", 200, null);
		Person a3 = new Person("Brandon", "Lewis", 300, null);
		Person a4 = new Person("Brandon", "Lewis", 1500, null);
		Person a5 = new Person("Brandon", "Lewis", 50, null);
		
		
		m.add(s2);
		m.add(s3);
		m.add(s4);
		m.add(s5);
		
		n.add(a2);
		n.add(a3);
		n.add(a4);
		n.add(a5);

		
		m.printList();
		
		
		System.out.println(m.getHead().getData().toString());
		System.out.println(m.getTail().getData().toString());
		System.out.println();
		
		
		n.printList();
		System.out.println(n.getHead().getData().toString());
		System.out.println(n.getTail().getData().toString());
		System.out.println();
		
		n.remove(a2);
		n.printList();
		System.out.println(n.getHead().getData().toString());
		System.out.println(n.getTail().getData().toString());
		System.out.println();
		
		n.remove(a4);
		n.printList();
		System.out.println(n.getHead().getData().toString());
		System.out.println(n.getTail().getData().toString());
		System.out.println();
		
		n.remove(a3);
		n.printList();
		System.out.println(n.getHead().getData().toString());
		System.out.println(n.getTail().getData().toString());
		System.out.println();
		
		n.remove(a5);
		n.printList();
		System.out.println();
		
		System.out.println(n.getSize());
		System.out.println();
		
		System.out.println(n.indexOf(a5));
		System.out.println();
		
		n.add(a2);
		n.add(a3);
		n.add(a4);
		n.add(a5);
		
		System.out.println(n.get(3));
		System.out.println();
		
		System.out.println(n.indexOf(a5));
		System.out.println();
			
		m.union(n).printList();
		System.out.println(m.union(n).getHead().getData().toString());
		System.out.println(m.union(n).getTail().getData().toString());
		System.out.println();
		
		m.intersection(n).printList();
		System.out.println(m.intersection(n).getHead().getData().toString());
		System.out.println(m.intersection(n).getTail().getData().toString());
		System.out.println();
		
		String filename = "SortedList.txt";
		m.saveListObjects(filename);
		
		m.loadListObjects(filename);
		
		
		
	}
}
