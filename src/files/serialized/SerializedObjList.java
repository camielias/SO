package files.serialized;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SerializedObjList<obj> implements Serializable {
	private static final long serialVersionUID = 5828195740179750668L;

	public List<obj> ObjectDB = new ArrayList<obj>();
	String ObjFile;

	public SerializedObjList(String objFile) {
		ObjFile = objFile;
	}

	public void AddObj(obj obj) {
		ObjectDB.add(obj);
		System.out.print("ADDED: ");
		printuser(ObjectDB.size() - 1);
		SaveDB();
	}

	public void printuser(int i) {
		System.out.println(ObjectDB.get(i).toString());
	}

	public void SaveDB() {
		System.out.println("\nsave db");
		readDB();
		RemoveDuplicates();
		try {

			FileOutputStream fos = new FileOutputStream(ObjFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ObjectDB);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void readDB() {
		try {
			FileInputStream fis = new FileInputStream(ObjFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Concatenate((List<obj>) ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		RemoveDuplicates();
	}

	public void printDB() {
		for (int i = 0; i < ObjectDB.size(); i++) {
			System.out.println(ObjectDB.get(i).toString());
		}
	}

	public void Concatenate(List<obj> NewObjDB) {
		ObjectDB.addAll(NewObjDB);
	}

	public void RemoveDuplicates() {
		Set<obj> setOfBlogs = new LinkedHashSet<>(ObjectDB);
		ObjectDB.clear();
		ObjectDB.addAll(setOfBlogs);
	}
}
