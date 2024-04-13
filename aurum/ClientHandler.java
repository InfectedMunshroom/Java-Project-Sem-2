package aurum;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    @Override
    public void run(){
        String messageFromClient;
        try{
            while(socket.isConnected()){
                messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);
            }
        }
        catch(Exception e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }


    }


    ClientHandler(Socket socket){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            clientHandlers.add(this);
            broadcastMessage("SEVRVER: " + clientUsername +" has entered the chat");
        }
        catch(Exception e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }

    public void broadcastMessage(String message){
        for(ClientHandler client : clientHandlers){
            try{
                if(!client.clientUsername.equals(clientUsername)){
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }

            }
            catch(Exception e){
                closeEverything(socket,bufferedReader,bufferedWriter);
            }
        }
    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage(clientUsername+" has left the chat");
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try{
            socket.close();
            bufferedReader.close();
            bufferedWriter.close();

        }
        catch(Exception e){
            System.out.println("Fatal Error please check in with tech support");
        }
    }
}