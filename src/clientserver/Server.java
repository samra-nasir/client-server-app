/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author Samra
 */
public class Server {
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        
        ArrayList<Note> notesList = new ArrayList<>();
        ServerSocket ss = new ServerSocket(5555);
        System.out.println("Running at port 5555");
        
        while(true){
            try (Socket s = ss.accept()) {
                
                System.out.println("Serving...");
                
               
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                    
                Note n = (Note) ois.readObject();
                
                
                System.out.println(n.user_name+ " connected");
                int opt = n.opt;
                if(opt==1){
                    notesList.add(n);
                }
                else{
                    for(int i = 0; i < notesList.size();++i){
                        if(notesList.get(i).user_name.equals(n.user_name)){
                            Note n1 =notesList.get(i);
                            oos.writeObject(n1);
                        }
                    }
                        
                    Note emp =new Note();
                    emp.user_name= "";
                    oos.writeObject(emp);
                            
                        
                }
                
                System.out.println("Done");
            }
            
        }
    }
    
}
