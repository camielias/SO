package objects.users;

import java.io.Serializable;

import files.serialized.SerializedObjList;

public class UserDB extends SerializedObjList<User> implements Serializable {

	private static final long serialVersionUID = -1372822414286005066L;

	public UserDB() {
		super("USER_DB");
		initialize();
	}

	private void initialize() {
		readDB();
		System.out.println("USER_DB SUCCESFULLY LOADED");
		System.out.println("USER_DB USER COUNT: " + ObjectDB.size());
		adddefaults();
		printloadedDB();
	}

	public void AddObj(User user) {
		if (isvaliduser(user)) {
			ObjectDB.add(user);
			System.out.print("ADDED: " + (ObjectDB.size() - 1));
			SaveDB();
		}
	}

	private boolean isvaliduser(User user) {
		return true;
	}

	private void adddefaults() {
		if (!userexist("ADMIN"))
			this.AddObj(new User("ADMIN", "ADMIN", 0, "ADMIN", User.ADMINISTRATOR));
	}

	public boolean ValidateCredentials(String username, String password) {
		int userindex = indexof(username);
		if (userindex != -1 && ObjectDB.get(userindex).password.equals(password)) {
			return true;
		}
		return false;
	}

	public int indexof(String username) {
		for (int i = 0; i < ObjectDB.size(); i++) {
			if (ObjectDB.get(i).username.equals(username)) {
				return i;
			}
		}
		return -1;
	}

	public boolean userexist(String username) {
		if (indexof(username) == -1) {
			return false;
		}
		return true;
	}

	public void printuser(int i) {

		System.out.print(ObjectDB.get(i).getAccessLevel() + " ");
		System.out.print(ObjectDB.get(i).username + " d");
		System.out.print(ObjectDB.get(i).password + "\n");
	}

	public void printloadedDB() {
		for (int i = 0; i < this.ObjectDB.size(); i++)
			printuser(i);
	}

	public void printDB() {
		readDB();
		for (int i = 0; i < this.ObjectDB.size(); i++)
			System.out.println(ObjectDB.get(i).username);
	}

	public int getAcessLevel(String username) {
		int userindex = indexof(username);
		return ObjectDB.get(userindex).AccessLevel;
	}
}
