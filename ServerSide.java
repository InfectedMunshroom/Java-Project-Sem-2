import java.net.*;
import java.io.*;

class ServerSide{
    public static void main(String[] args){
        ServerSocket sSocket;
        Socket cSocket;
        try{
            sSocket = new ServerSocket(5005);
            cSocket = sSocket.accept();
            try{
                DataInputStream dis = new DataInputStream(cSocket.getInputStream());
                String str = (String)dis.readUTF();
                System.out.println(str);
                
            }
            catch(Exception e){
                System.out.println("[-] Message could not be read");
            }
            sSocket.close();
        }

        catch(Exception e){
            System.out.println("[-] Server connected to port");
        }




    }
}