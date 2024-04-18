package carbon;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientSide{
    private Socket socket;
    private DataOutputStream dout;
    private Scanner in;

    public ClientSide(){
        try{
            socket = new Socket("localhost",ServerSide.port);
            dout = new DataOutputStream(socket.getOutputStream());
            System.out.println("Your message: ");
            in = new Scanner(System.in);
            writeMessage();

        }
        catch(Exception e){
            System.out.println("[-] Error creating client");
        }
    }
    private void writeMessage() throws IOException{
        String line = "";
        while(!line.equals(ServerSide.STOP_STRING)){
            line = in.nextLine();
            dout.writeUTF(line);
        }
        close();

    }
    private void close() throws IOException{
        socket.close();
        in.close();
        dout.close();
    }

    public static void main(String[] args){
        new ClientSide();
    }
}
