package objects.test;

import java.io.Serializable;

import files.serialized.SerializedObjList;

public class TestDB extends SerializedObjList<Test> implements Serializable {

	private static final long serialVersionUID = -1372822414286005066L;

	public TestDB() {
		super("USER_DB");
		initialize();
	}

	public int indexof(String username) {
		for (int i = 0; i < ObjectDB.size(); i++) {
			if (ObjectDB.get(i).username.equals(username)) {
				return i;
			}
		}
		return -1;
	}

	private void initialize() {
		// ADDS DEFAULT ADMIN
		if (indexof("ADMIN") == -1)
			this.AddObj(new Test("ADMIN", "ADMIN", 0, "ADMIN", 1));
	}

	@Override
	public void printDB() {
		System.out.println("SIZE: " + ObjectDB.size());
		for (int i = 0; i < this.ObjectDB.size(); i++)
			System.out.println(ObjectDB.get(i).username);
	}

	@Override
	public void printuser(int i) {
		System.out.println(ObjectDB.get(i).username);
	}

	public boolean ValidateCredentials(String username, String password) {
		int userindex = indexof(username);
		if (userindex != -1 && ObjectDB.get(userindex).password.equals(password)) {
			return true;
		}
		return false;
	}

}
