package aurum;
import java.net.*;
import java.io.*;
public class serverSide {
  public static final int port = 5555;
  private ServerSocket server;
  private int clientCounter = 0;
  private DataOutputStream dout;
  private DataInputStream din;

  public serverSide(){
    try{
        server = new ServerSocket(port);
        System.out.println("[+] Server is ready to connect to clients");
    }
    catch(Exception e){
      System.out.println("[-] Error: Server could not be started");
    }
  }

  private void connectClient(){
    try{
      Socket cSocket = server.accept();
      if(cSocket.isConnected()){
        clientCounter++; 
      }
      String ligma = " ";
      ligma = din.readUTF(); 

    }
    catch(Exception e){
      System.out.println("[-] Error in connection client");
    }
    
  }
}
