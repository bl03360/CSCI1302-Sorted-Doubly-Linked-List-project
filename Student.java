/**
 * 
 */
package cs1302.projects;

import java.util.Date;

/**
 * @author mehdi
 *
 */
public class Student extends Person {
	
	private String collegeName;
	
	public Student(String fname, String lname, int id, Date bdate, String collegeName) {
		super(fname, lname, id, bdate);
		this.collegeName = collegeName;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [" + collegeName + "]";
	}
	

	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	

}
