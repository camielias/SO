package network.body;

import java.util.ArrayList;

public class Message<E> {
	byte Instruction;
	
	ArrayList<E> objects = new ArrayList<E>();
}
