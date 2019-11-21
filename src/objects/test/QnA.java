package objects.test;

import java.io.Serializable;

public class QnA implements Serializable {
	private static final long serialVersionUID = -3524562031784749568L;
	String[] answer = new String[4];
	String question;
	int selected = -1;

	public QnA(String Q, String[] A) {
		question = Q;
		answer = A;
	}

	public QnA(String Q, String[] A, int S) {
		this(Q, A);
		selected = S;
	}
}
