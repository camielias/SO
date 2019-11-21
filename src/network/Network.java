package network;

interface Network {

	int BUFFERSIZE = 1 * 1024;
	int PORT = 4444;

	String Server = "0.0.0.0";
	String Client = "0.0.0.0";

	// TEST VARIABLES
	String ServerPATH = ".//SERVER//";
	String ClientPATH = ".//CLIENT//";
	// END TEST VARIABLES

	String MainServer = "0.0.0.0";
	String Servers[] = { "Server1", "Server2", "Server3", };

}
