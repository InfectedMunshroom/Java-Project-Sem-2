package aurum;
import java.util.*;
import java.io.*;
import java.net.*;

public class clientSide{
    private Socket socket;
    private DataOutputStream dout;
    private Scanner in;
    private String username;

    public clientSide(){
        System.out.println("Please enter your username:");
        username = in.nextLine();

    }
}