package comm;
//Establish connection with the server and send data

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {

    Socket soc;
    OutputStream toserver;
    InputStream in;

    //Constructor that establishes the connection
    public MyClient(byte[] buf, String ip, int port) {
        try {
            System.out.print(ip);
            System.out.println(port);

            soc = new Socket(ip, port);	// server is listening on this port
            toserver = new BufferedOutputStream(soc.getOutputStream());
            toserver.write(buf, 0, buf.length);	//Write data onto the socket
            toserver.close();
            soc.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error in the MyClient : " + ex.toString());
        }
    }
}
