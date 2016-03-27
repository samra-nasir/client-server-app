/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author Samra
 */
public class Client {
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
       int choice;
       Scanner sc = new Scanner(System.in);
       System.out.println("Please enter a number to perform respective action:\n1.Enter Note\n2.Read Notes");
       choice = sc.nextInt();
       
       
        Note n = new Note();
        
        Socket s = new Socket("localhost",5555);
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        
        
       if(choice==1){
           
            String username, note;
            System.out.println("Enter a Username");
            username = sc.next();
            System.out.println("Enter a Note");
            note = sc.next();
            setObject(n, 1, username, note);
            System.out.println("Note Added");
          
       }
       
       else if(choice==2){
           
           System.out.print("Enter Username to search notes: ");
           String username = sc.next();	 
           setObject(n, 2, username, "");
            
                    
       }
       
        ObjectOutputStream o = new ObjectOutputStream(s.getOutputStream());
            o.writeObject(n);
          
       
       if(n.opt == 2){
           int c = 0;
           System.out.println("Printing Notes for : "+n.user_name);
            while(true){
                    Note n1 = (Note)ois.readObject();
                    if(n1.user_name.equals("")){
                        if(c==0)
                            System.out.println("No notes exist");
                        break;
                    }
                    else{
                        c=1;
			System.out.println("Note: "+n1.note);
                    }
                }
       }
       
       s.close();
       
        
        
    }
    
    public static void setObject( Note n, int opt, String username, String note){
        n.user_name = username;
        n.note = note;
        n.opt = opt;
        
    }

    
}
