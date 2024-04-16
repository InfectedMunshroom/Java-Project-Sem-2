

import javax.swing.*;    
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;  
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.FileNotFoundException;

public class MyProject implements ActionListener
{
	JFrame f;
	JLabel label;
	JPasswordField value;
	JTextField text,text2;
	JLabel l1,l2,l3,ll,pl1,pl2,pl3,pl4,pl5;
	JButton b1,b2,home,logout;
	String uname;
	ImageIcon img1,img2,img3,img4,img5;
	Random rand = new Random(); 
    int k;
	Map<String,String>m = new HashMap<String,String>();
	public static String b_msg="";
    public static int len = 0;
    
    public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };
    public static char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
            'V', 'B', 'N', 'M' };
    
	MyProject()
	{
	// 	uname=new String("");
		f=new JFrame("My Project");    
    //     label = new JLabel();            
    //     label.setBounds(20,150, 200,50);  
    //     value = new JPasswordField();   
    //     value.setBounds(100,75,100,30);   
    //     l1=new JLabel("Username:");    
    //     l1.setBounds(20,20, 80,30);    
    //     l2=new JLabel("Password:");    
    //     l2.setBounds(20,75, 80,30);    
    //     b1 = new JButton("Login");  
    //     b1.setBounds(100,120, 80,30);    
    //     text = new JTextField();  
    //     text.setBounds(100,20, 100,30);    
    //     f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b1); f.add(text);  
    //     f.setSize(650,650);    
    //     f.setLayout(null);    
    //     f.setVisible(true);     
    //     b1.addActionListener(new ActionListener() {  
    //     public void actionPerformed(ActionEvent e) 
    //     {   
    //     	menu(); 
    //     }  
    //    });   
          menu();
	}
	private void menu()
	{
		String userName="Hi" ; //text.getText();
        String password = "Hello" ; //new String(value.getPassword());
        f.getContentPane().removeAll();
        f.getContentPane().repaint();
        label = new JLabel(); 
        label.setBounds(40,60, 200,50);  
        b1 = new JButton("Send message");
        b2 = new JButton("Inbox");
        logout = new JButton("Logout");
        b1.setBounds(50,100, 200,30); 
        b2.setBounds(50,150,200,30);
        logout.setBounds(50,200,200,30);
        f.add(label);
        f.add(b1);
        f.add(b2);
        f.add(logout);
        f.setSize(650,650);    
        f.setLayout(null);    
        f.setVisible(true); 
        
        b1.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) 
            {   
            	sendMessage(); 
            }  
           }); 
        
        b2.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) 
            {   
            	viewMessage(); 
            }  
           }); 
        
        logout.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) 
            {   
            	//loginPage(); 
            }  
           }); 
        
        boolean flag=false;
        if ((userName.trim().equals("knight") && password.trim().equals("pass"))||(userName.trim().equals("knight") && password.trim().equals("pass"))) 
        {
        	flag=true;
        	uname=new String(userName);
        }
        if(flag)
        {
        	label.setText(" Hello " + uname + "");
        }
        // else 
        // {
        // 	loginPage();
        // }
	}
	// private void loginPage()
	// {
	// 	f.getContentPane().removeAll();
	//     f.getContentPane().repaint();
	// 	uname=new String("");  
    //     label = new JLabel();            
    //     label.setBounds(20,150, 200,50);  
    //     value = new JPasswordField();   
    //     value.setBounds(100,75,100,30);   
    //     l1=new JLabel("Username:");    
    //     l1.setBounds(20,20, 80,30);    
    //     l2=new JLabel("Password:");    
    //     l2.setBounds(20,75, 80,30);    
    //     b1 = new JButton("Login");  
    //     b1.setBounds(100,120, 80,30);    
    //     text = new JTextField();  
    //     text.setBounds(100,20, 100,30);    
    //     f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b1); f.add(text);  
    //     f.setSize(650,650);    
    //     f.setLayout(null);    
    //     f.setVisible(true);     
    //     b1.addActionListener(new ActionListener() {  
    //     public void actionPerformed(ActionEvent e) 
    //     {   
    //     	menu(); 
    //     }  
    //    });
	// }
	private void sendMessage()
	{
        f.getContentPane().removeAll();
        f.getContentPane().repaint();
        label = new JLabel();
        ll=new JLabel();   
        l1=new JLabel("Enter username:");    
        l1.setBounds(20,20, 150,30);    
        l2=new JLabel("Enter the secret message:");    
        l2.setBounds(20,75, 150,30);
        
        JTextField t1 = new JTextField();  
        t1.setBounds(200,20, 200,30); 
        JTextField t2 = new JTextField();  
        t2.setBounds(200,75, 200,30);
        
        
        l3=new JLabel("Choose an image:");    
        l3.setBounds(20,120,150,30); 
        
        Image image,newimg;
        
        img1 =new ImageIcon("/home/tatenashisarashiki/Projects/Hermes II Beta/aurum/steganography/MyProject/src/autumn.jpg");
        image = img1.getImage();
        newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
        img1=new ImageIcon(newimg);
        pl1=new JLabel(img1);
        pl1.setBounds(20,170,100,100);
        f.add(pl1);
        
        img2 =new ImageIcon("/home/tatenashisarashiki/Projects/Hermes II Beta/aurum/steganography/MyProject/src/summer.jpg");
        image = img2.getImage();
        newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
        img2=new ImageIcon(newimg);
        pl2=new JLabel(img2);
        pl2.setBounds(20,270,100,100);
        f.add(pl2);
        
        img3 =new ImageIcon("/home/tatenashisarashiki/Projects/Hermes II Beta/aurum/steganography/MyProject/src/winter.jpg");
        image = img3.getImage();
        newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
        img3=new ImageIcon(newimg);
        pl3=new JLabel(img3);
        pl3.setBounds(20,370,100,100);
        f.add(pl3);
        
        img4 =new ImageIcon("/home/tatenashisarashiki/Projects/Hermes II Beta/aurum/steganography/MyProject/src/spring.jpg");
        image = img4.getImage();
        newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
        img4=new ImageIcon(newimg);
        pl4=new JLabel(img4);
        pl4.setBounds(20,470,100,100);
        f.add(pl4);
        
        JRadioButton rb1,rb2,rb3,rb4;
        ButtonGroup g;
        
        rb1=new JRadioButton();
        rb2=new JRadioButton();
        rb3=new JRadioButton();
        rb4=new JRadioButton();
        g=new ButtonGroup();
        home=new JButton("home");
        home.setBounds(400,530,80,30);
        f.add(home);
        
       rb1.setBounds(150,220,20,20);
       rb2.setBounds(150,320,20,20);
       rb3.setBounds(150,420,20,20);
       rb4.setBounds(150,520,20,20);
        
        f.add(rb1);
        f.add(rb2);
        f.add(rb3);
        f.add(rb4);
        
        g.add(rb1);
        g.add(rb2);
        g.add(rb3);
        g.add(rb4);
        
        
        ll.setBounds(250,250,300,300);
   	    f.add(ll);
        
        b1 = new JButton("Send");  
        b1.setBounds(300,530, 80,30);       
        f.add(l1); f.add(l2); f.add(b1); f.add(t1); f.add(t2);  
        f.add(l3);
        f.setSize(650,650);    
        f.setLayout(null);    
        f.setVisible(true);     
        b1.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) 
        {   
        	String to=new String(t1.getText());
        	String img=new String("/home/tatenashisarashiki/Projects/Hermes II Beta/aurum/steganography/MyProject/src/");
        	 if(rb1.isSelected())
        	 {
        		 img+="summer";
        	 }
        	 else if(rb2.isSelected())
        	 {
        		 img+="winter";
        	 }
        	 else if(rb3.isSelected())
        	 {
        		 img+="autumn";
        	 }
        	 else if(rb4.isSelected())
        	 {
        		 img+="spring";
        	 }
        	 img+=".jpg";
        	 m.put(to,img);
        	 
        	 String contentOfMessageFile =new String(t2.getText());
        	 
        	 k= rand.nextInt(100);
        	 
        	 //String msg2=monoEncryption(contentOfMessageFile);
        	 String msg2=new String(contentOfMessageFile);
        	 
        	 int[] bits=bit_Msg(msg2);
        	 BufferedImage theImage=readImageFile(img);
        	 try
        	 {
        		 hideTheMessage(bits, theImage); 
        	 }
        	 catch(Exception e1)
        	 {
        		 
        	 }
        	 ll.setText("Message sent successfully!");
        }
        });
        home.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) 
            {   
            	menu();
            }
            });
	}
	public static int[] bit_Msg(String msg){
		int j=0;
		int[] b_msg=new int[msg.length()*8];
		for(int i=0;i<msg.length();i++){
			int x=msg.charAt(i);
			String x_s=Integer.toBinaryString(x);
			while(x_s.length()!=8){
				x_s='0'+x_s;
			}
			for(int i1=0;i1<8;i1++) {
			    b_msg[j] = Integer.parseInt(String.valueOf(x_s.charAt(i1)));
			    j++;
			  };
		}
		
		return b_msg;
	}
	public static BufferedImage readImageFile(String COVERIMAGEFILE){
		BufferedImage theImage = null;
		File p = new File (COVERIMAGEFILE);
		try{
		theImage = ImageIO.read(p);
		}catch (IOException e){
		e.printStackTrace();
		System.exit(1);
		}
		return theImage;
		}
	public static void hideTheMessage (int[] bits, BufferedImage theImage) throws Exception{
		File f = new File ("steg.png");
		BufferedImage sten_img=null;
		int bit_l=bits.length/8;
		int[] bl_msg=new int[8];
		String bl_s=Integer.toBinaryString(bit_l);
		while(bl_s.length()!=8){
			bl_s='0'+bl_s;
		}
		for(int i1=0;i1<8;i1++) {
			bl_msg[i1] = Integer.parseInt(String.valueOf(bl_s.charAt(i1)));
		  };
	int j=0;
	int b=0;
	int currentBitEntry=8;

	for (int x = 0; x < theImage.getWidth(); x++){
	for ( int y = 0; y < theImage.getHeight(); y++){
		if(x==0&&y<8){
			int currentPixel = theImage.getRGB(x, y);	
			int ori=currentPixel;
			int red = currentPixel>>16;
			red = red & 255;
			int green = currentPixel>>8;
			green = green & 255;
			int blue = currentPixel;
			blue = blue & 255;
			String x_s=Integer.toBinaryString(blue);
			String sten_s=x_s.substring(0, x_s.length()-1);
			sten_s=sten_s+Integer.toString(bl_msg[b]);

			//j++;
			int temp=Integer.parseInt(sten_s,2);
			int s_pixel=Integer.parseInt(sten_s, 2);
			int a=255;
			int rgb = (a<<24) | (red<<16) | (green<<8) | s_pixel;
			theImage.setRGB(x, y, rgb);
			ImageIO.write(theImage, "png", f);
	b++;

		}
		else if (currentBitEntry < bits.length+8 ){

		int currentPixel = theImage.getRGB(x, y);	
		int ori=currentPixel;
		int red = currentPixel>>16;
		red = red & 255;
		int green = currentPixel>>8;
		green = green & 255;
		int blue = currentPixel;
		blue = blue & 255;
		String x_s=Integer.toBinaryString(blue);
		String sten_s=x_s.substring(0, x_s.length()-1);
		sten_s=sten_s+Integer.toString(bits[j]);
		j++;
		int temp=Integer.parseInt(sten_s,2);
		int s_pixel=Integer.parseInt(sten_s, 2);
		
		int a=255;
		int rgb = (a<<24) | (red<<16) | (green<<8) | s_pixel;
		theImage.setRGB(x, y, rgb);
		ImageIO.write(theImage, "png", f);
		currentBitEntry++;	
		}
	}
	}
	}
	
	public static String monoEncryption(String s)
    {
        char c[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (p[j] == s.charAt(i))
                {
                    c[i] = ch[j];
                    break;
                }
            }
        }
        return (new String(c));
    }
 
    public static String monoDecryption(String s)
    {
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }
	
	private void decryptLastMessage()
	{
		f.getContentPane().removeAll();
        f.getContentPane().repaint();
        
        String img_to_decrypt=new String("/home/tatenashisarashiki/Projects/Hermes II Beta/aurum/steganography/MyProject/src/steg.png");
       
        
    	BufferedImage yImage=readImageFile(img_to_decrypt);

    	
    	JButton bk = new JButton("Back");  
        bk.setBounds(100,150, 80,30);
        f.add(bk);
        
        bk.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) 
            {   
            	viewMessage(); 
            }  
           });
        
    	try
    	{
    		DecodeTheMessage(yImage);
    	}
    	catch(Exception e3)
    	{
    		
    	}
    	String msg="";
    	//System.out.println("len is "+len*8);
    	for(int i=0;i<len*8;i=i+8){
    		
    		String sub=b_msg.substring(i,i+8);
    		
    		int m=Integer.parseInt(sub,2);
    		char ch=(char) m;
    		msg+=ch;
    	}
    	//String msg3=monoDecryption(msg);
    	
    	String msg3=new String(msg);
    	
        JLabel recent_msg = new JLabel(); 
        recent_msg.setBounds(100,100, 200,50);
        recent_msg.setText(msg3);
        f.add(recent_msg);
	}
	private void viewMessage()
	{
        f.getContentPane().removeAll();
        f.getContentPane().repaint();
        Image image,newimg;
        img5 =new ImageIcon("E:\\java\\MyProject\\steg.png");
        image = img5.getImage();
        newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); 
        img5=new ImageIcon(newimg);
        pl5=new JLabel(img5);
        pl5.setBounds(100,100,200,200);
        f.add(pl5);
        
        home=new JButton("home");
        home.setBounds(250,500,80,30);
        f.add(home);
        
        home.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) 
            {   
            	menu();
            }
            });
        
        JButton dm = new JButton("Decrypt");  
        dm.setBounds(350,150, 80,30);
        f.add(dm);
        
        dm.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) 
            {   
            	decryptLastMessage(); 
            }  
           });
        
	}
	public static void DecodeTheMessage (BufferedImage yImage) throws Exception{

		int j=0;
		int currentBitEntry=0;
		String bx_msg="";
		for (int x = 0; x < yImage.getWidth(); x++){
		for ( int y = 0; y < yImage.getHeight(); y++){
		if(x==0&&y<8){
			//System.out.println("enc "+yImage.getRGB(x, y)+" dec "+yImage.getRGB(x, y)+" "+b_msg);
			int currentPixel = yImage.getRGB(x, y);	
			int red = currentPixel>>16;
			red = red & 255;
			int green = currentPixel>>8;
			green = green & 255;
			int blue = currentPixel;
			blue = blue & 255;
			String x_s=Integer.toBinaryString(blue);
			bx_msg+=x_s.charAt(x_s.length()-1);
			len=Integer.parseInt(bx_msg,2);
			
		}
		else if(currentBitEntry<len*8){
		//System.out.println("enc "+yImage.getRGB(x, y)+" dec "+yImage.getRGB(x, y)+" "+b_msg);
			int currentPixel = yImage.getRGB(x, y);	
			int red = currentPixel>>16;
			red = red & 255;
			int green = currentPixel>>8;
			green = green & 255;
			int blue = currentPixel;
			blue = blue & 255;
			String x_s=Integer.toBinaryString(blue);
			b_msg+=x_s.charAt(x_s.length()-1);

			
			currentBitEntry++;	
			//System.out.println("curre "+currentBitEntry);
		}
		}
		}
		}
    public static void main(String args[])
    {
    	new MyProject();
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
