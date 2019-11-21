package objects.test;

import java.io.Serializable;

public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 687961495642283480L;

	String Date;
	String Description;
	private int hashCode;
	String Name;
	String password;
	String Taker = "";

	String username;

	public Test() {
	}

	public Test(String username, String password, int age, String gender, int accesslevel) {
	}

	@Override
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

	@Override
	public int hashCode() {
		return (this.username.hashCode());
	}

}
