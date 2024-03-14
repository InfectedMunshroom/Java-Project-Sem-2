// import java.net.*;
// import java.io.*;

// class ServerSide{
//     public static void main(String[] args){
//         ServerSocket sSocket;
//         Socket cSocket;
//         try{
//             sSocket = new ServerSocket(5005);
//             cSocket = sSocket.accept();
//             try{
//                 DataInputStream dis = new DataInputStream(cSocket.getInputStream());
//                 String str = (String)dis.readUTF();
//                 System.out.println(str);
                
//             }
//             catch(Exception e){
//                 System.out.println("[-] Message could not be read");
//             }
//             sSocket.close();
//         }

//         catch(Exception e){
//             System.out.println("[-] Server connected to port");
//         }




//     }
// }



import java.net.*;
import java.io.*;

class ServerSide{
    public static final int port = 5555;
    private ServerSocket server;
    public static final String STOP_STRING = "--++";

    public ServerSide(){
        try{
            server = new ServerSocket(port);
            System.out.println("[+] Server Successfully Online");
            while(true) clientSideConnections();
        }
        catch(Exception e){
            System.out.println("[-] Error: Check Server");
        }
    }

    private void clientSideConnections(){
        try{
            Socket cSocket = server.accept();
            if(cSocket.isConnected()){
            new Thread(()->{
                ClientSideMultiple client = new ClientSideMultiple(cSocket);
                client.readMessages();
                client.close();

        }).start();}
        }
        catch(Exception e){
            System.out.println("[-] Failure in Connection of Client");
        }
    }



    public static void main(String[] args){
        ServerSide Server = new ServerSide();
    }

}