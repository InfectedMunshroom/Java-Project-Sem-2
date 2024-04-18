package carbon;
import java.io.*;
import java.net.*;

public class ClientSideMultiple{
    private Socket clientSocket;
    private DataInputStream dis;

    public ClientSideMultiple(Socket ccSocket){
        this.clientSocket = ccSocket;
        try{
            this.dis = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        }
        catch(Exception e){
            System.out.println("[-] Failure in Sending Message");
        }
    }

    public void readMessages(){
        String line = "";
        while(!line.equals(ServerSide.STOP_STRING)){
            try{
                line = dis.readUTF();
            }
            catch(Exception e){
                System.out.println("[-] Failure in Reading Message");
            }
            System.out.println(line);
        }
    }

    public void close(){
        try{
        clientSocket.close();
        dis.close();
        }
        catch(Exception e){
            System.out.println("[-] Fatal Error: Could not close client sockets and ports. Please contact tech support at h.a.ayushman@gmail.com");
        }
    }
}