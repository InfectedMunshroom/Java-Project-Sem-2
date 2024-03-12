import java.net.*;
import java.io.*;
import java.util.Scanner;

class ClientSide{
    public static void main(String[] args){
        Socket cSocket;
        Scanner in = new Scanner(System.in);
        try{
            cSocket = new Socket("localhost",5005);
            System.out.println("Message: ");
            String alpha = in.nextLine();
            DataOutputStream dout = new DataOutputStream(cSocket.getOutputStream());
            dout.writeUTF(alpha);
            dout.flush();
            dout.close();
            cSocket.close();
            in.close();
        }
        catch(Exception e){
            System.out.println("[-] Could not send message");
        }
    }
}