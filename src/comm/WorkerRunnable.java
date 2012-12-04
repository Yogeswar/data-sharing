package comm;
//Read data from the inputstream
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import org.apache.commons.io.IOUtils;

public class WorkerRunnable implements Runnable
{
	Socket clientSocket = null;
    String serverText   = null;
    private ServerListener listener;
	InputStream is;
	PrintWriter toclient;

	public WorkerRunnable(Socket clientSocket, ServerListener sl) 
	{

		// TODO Auto-generated constructor stub
		this.clientSocket = clientSocket;
		this.listener = sl;
        
	}

	@Override
	public void run() 
	{
	
		// TODO Auto-generated method stub
		try
		{
        	while(true)
    		{
        	String Ip1=clientSocket.getInetAddress().toString();	//Obtain the IP address from socket data
			String Ip = Ip1.substring(1);
                        System.out.println(Ip);
			is = new BufferedInputStream(clientSocket.getInputStream());	 
			byte[] bytes = IOUtils.toByteArray(is);	//Read data from InputStream
			listener.serverNotify(bytes, Ip);	//Process the data read
			break;
    		}
            clientSocket.close();	//Close socket
            
        }
		catch (Exception ex) 
		{
        	ex.printStackTrace();
        }
    }
}


