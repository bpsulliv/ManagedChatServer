
import java.net.*;

public class ConnectionManager extends Thread implements ConnectionManagerAPI 
{
    // ServerSocket passed from Server
    private ServerSocket host;
    // ConnectionListener
    private ConnectionListener connectionListener;
    // RoomManager
    private RoomManager roomManager;
    // Client, Used to reference the client object passed from listener
    private Client client;

    public ConnectionManager(ServerSocket host) 
    {
        this.host = host; 

        //add new room manager object, and add the default lobby room
    }

//*** PARENT CLASS METHODS ***	
    public boolean stopServer() {
    }

//*** INTERFACE METHODS ***
    public boolean addClientToRoom(Client client) {
    }

    public boolean createNewRoom(String roomName) {
    }

    public void addClientToDefaultLobby(Client client) {
        managers.get(0).add;
    }

    public boolean addClientToRoom(String roomName, Client client,
            Room currentRoom) {
    }

    public <String> ArrayList getListOfRooms() {
    }

    public int getNumberOfClientsInRoom() {
    }

    public int getNumberOfClients() {
    }

    public boolean doesRoomExist(String room) {
        //loop through the room manager objects to check room names
        for (RoomManager current : managers) {
            if (current.doesRoomExistAtThisLevel(room)) {
                return true;
            }
        }
    }
}