package comm;
//Server  
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cserver implements Runnable {
	private ServerListener listener;
	
	//Initialize an object whenever server receives data
	public void registerListener(ServerListener sl)
	{
		this.listener = sl;
	}
	
	int serverPort= 5000; //Initialize the server port
	Thread runningThread= null; 
	ServerSocket serverSocket = null;
	
	//constructor that assigns the current port in which data is received
	public Cserver(int port)
	{
        this.serverPort = port;
    }

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		this.runningThread = Thread.currentThread();
		openServerSocket();
		while(true)
		{
			Socket clientSocket = null;
			try
			{
				clientSocket = this.serverSocket.accept(); //accept the socket connection from the client 
                                System.out.println("clientSocket:-"+clientSocket.getLocalPort());
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
            }
            System.out.println("incoming");
            new Thread(new WorkerRunnable(clientSocket, listener)).start(); // start a new thread that continues listening to the clients
	    }
	}

	//create a new serversocket at the incoming port
	private void openServerSocket() 
	{
		// TODO Auto-generated method stub
		try
		{
            this.serverSocket = new ServerSocket(this.serverPort);
            System.out.println("serverSocket:-"+serverSocket.getLocalPort());
        }	
		catch (Exception ex) 
		{
                System.out.println("Could not listen on port: 5000");
                ex.printStackTrace();
                System.exit(-1);
        	
        }
	}
	
	public static void main(String arg[]) throws UnknownHostException, IOException
	{
		Cserver server = new Cserver(4444);
		new Thread(server).start();
	}
}
