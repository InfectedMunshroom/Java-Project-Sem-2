// import java.net.*;
// import java.io.*;
// import java.util.Scanner;

// class ClientSide{
//     public static void main(String[] args){
//         Socket cSocket;
//         Scanner in = new Scanner(System.in);
//         try{
//             cSocket = new Socket("localhost",5005);
//             System.out.println("Message: ");
//             String alpha = in.nextLine();
//             DataOutputStream dout = new DataOutputStream(cSocket.getOutputStream());
//             dout.writeUTF(alpha);
//             dout.flush();
//             dout.close();
//             cSocket.close();
//             in.close();
//         }
//         catch(Exception e){
//             System.out.println("[-] Could not send message");
//         }
//     }
// }

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