package aurum;

import java.io.*;
import java.net.*;
import java.util.*;

public class clientSideMultiple{
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;

    public clientSideMultiple(Socket socket, String username){
        try{
            this.socket = socket;
            this.username = username;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch(Exception e){
            System.out.println("Error in creating client");
            try {
                closeEverything(socket,bufferedReader,bufferedWriter);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }

    public void sendMessage(){
        try{
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            Scanner sc = new Scanner(System.in);
            while(socket.isConnected()){
                String messageToSend = sc.nextLine();
                bufferedWriter.write(username+": "+messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch(Exception e){
            try {
                closeEverything(socket, bufferedReader, bufferedWriter);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run(){
                String msgFromGrpChat;
                while(socket.isConnected()){
                    try{
                        msgFromGrpChat = bufferedReader.readLine();

                        System.out.println(msgFromGrpChat);
                    }
                    catch(Exception e){
                        try {
                            closeEverything(socket,bufferedReader,bufferedWriter);
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }

                }
            }
        }).start();


    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException{
        if(socket != null){
            socket.close();
        }
        if(bufferedReader != null){
            bufferedReader.close();
        }
        if(bufferedWriter != null){
            bufferedWriter.close();
        }
        
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        Socket socket = new Socket("localhost",9999);
        clientSideMultiple client = new clientSideMultiple(socket, username);
        client.listenForMessage();
        client.sendMessage();
    }

}