package aurum;

import java.net.*;
import java.io.*;


public class serverSide{
  private ServerSocket serverSocket;

  serverSide(ServerSocket serverSocket){
    this.serverSocket = serverSocket;
  }

  public void startServer(){
    try{
        while(serverSocket.isClosed()){
          Socket socket = serverSocket.accept();
          System.out.println("[+] A new client has been connected");
          ClientHandler clientHandler = new ClientHandler(socket);
          Thread thread = new Thread(clientHandler);
        }

      
    }
    catch(Exception e){
      System.out.println("[-] Error in starting server\n" + e);
    }
    
  }

  public void closeServerSocket(){
    try{
      if(serverSocket.isBound()) serverSocket.close();
    }
    catch(Exception e){
      System.out.println("[-] Server socket could not be closed properly");
    }
  }
}