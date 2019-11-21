package objects.users;

import java.io.Serializable;

public class User implements Serializable {

	public final static int PATIENT = 0, ADMINISTRATOR = 1;
	private static final long serialVersionUID = 687961495642283480L;
	int AccessLevel;
	int age;
	String gender;
	private int hashCode;
	String password;

	String username;

	public User(String username, String password, int age, String gender) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		AccessLevel = 0;
	}

	public User(String username, String password, int age, String gender, int accesslevel) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.AccessLevel = accesslevel;
	}

	@Override
	public boolean equals(Object obj) {

		User blog = (User) obj;

		if (this.username.equals(blog.username)) {
			hashCode = blog.hashCode;
			return true;
		} else {
			hashCode = super.hashCode();
			return false;
		}
	}

	public String getAccessLevel() {

		if (AccessLevel == User.ADMINISTRATOR) {
			return "ADMINISTRATOR";
		} else {
			return "PATIENT      ";
		}
	}

	@Override
	public int hashCode() {
		return (this.username.hashCode());
	}

}
