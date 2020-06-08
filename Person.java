package cs1302.projects;

import java.util.Date;

public class Person implements Comparable<Person> {
	
	private String fname;
	private String lname;
	private int id;
	private Date bdate;
	
	
	public Person() {
		fname = null;
		lname = null;
		id = 0;
		bdate = null;
	}
	
	
	
	public Person(String fname, String lname, int id, Date bdate) {
		this.fname = fname;
		this.lname = lname;
		this.id = id;
		this.bdate = bdate;
	}
	
	@Override
	public int compareTo(Person o) {
		Person p = (Person) o;
		
		if(p.getId() > getId()) {
			return 1;
		}
		else if(p.getId() < getId()) {
			return -1;
		}
		else 
			return 0;
	}
	
	/**
	 * @return id, fname, lname, and bdate 
	 */
	public String toString() {
		return id + " " + fname + " " + lname + " " + bdate;
	}
	
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the bdate
	 */
	public Date getBdate() {
		return bdate;
	}

	/**
	 * @param bdate the bdate to set
	 */
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

}
