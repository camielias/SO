package network.body;

interface Instruction {

	// PRINTABLES
	byte PRINT_STRING = (byte) 0x00;
	
	// SERVER INSTRUCTION
	
	
	// SERVER REQUEST
	byte GET_STRINGARRAY_OF_TEST_NAMES = (byte) 0x02;
	byte GET_TEST_BY_INDEX = (byte) 0x01;
	
	
	//MESSAGE CONTROL 
	byte MESSAGE_SUCCESSFUL = (byte) 0xFB; 
	byte MESSAGE_FAILED = (byte) 0xFC;
	
	// CONNECTION CONTROL
	byte PING = (byte) 0xFD;
	byte CREDENTIAL_AUTHENTICATION = (byte) 0xFE; 
	byte CLOSE_CONNECTION = (byte) 0xFF;
}
