package comm;
//Interface to hold method to parse incoming data

public interface ServerListener {

	//Notify the controller on data received
	public void serverNotify(byte[] data, String ip);
	
}
