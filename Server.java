// Creates Connection Listener and Connection Manager objects
import java.net.*;
import java.io.*;
public class Server
{
    // ConnectionManager of all connections within the API
    private ConnectionManager connectionManager;
    // ServerSocket of the Server, passed to ConnectionManager
    private ServerSocket serverSocket;
    
    public Server(int port) throws IOException
    {
        // Create the ServerSocket on the port parameter
        serverSocket = new ServerSocket(port);
        // Create the ConnectionManager
        connectionManager = new ConnectionManager(serverSocket);
    }
    // Private method only accesible to Server and used to
    // shutdown the server and remove connection to Connection Manager
    private void ShutdownServer()
    {
        
    }
}