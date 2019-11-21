package objects.test;

import java.io.Serializable;

public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 687961495642283480L;

	String Name;
	String Taker = "";
	String Description;
	String Date;
	String username;
	String password;

	private int hashCode;

	public Test() {
	}

	public Test(String username, String password, int age, String gender, int accesslevel) {
	}

	public boolean equals(Object obj) {

		Test blog = (Test) obj;

		if (Name.equals(blog.Name)) {
			hashCode = blog.hashCode;
			return true;
		} else {
			hashCode = super.hashCode();
			return false;
		}
	}

	public int hashCode() {
		return (this.username.hashCode());
	}

}
