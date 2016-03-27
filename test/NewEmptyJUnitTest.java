/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.Test;
import static org.junit.Assert.*;
import clientserver.Note;
import clientserver.Client;

/**
 *
 * @author Samra
 */
public class NewEmptyJUnitTest {
    	
	    @Test
	    public void TestA() {
	        
	      Note n = new Note();
              n.user_name = "Samra";
              n.note = "Hey";
              n.opt = 1;
              
              Note a = new Note();
              Client.setObject(a, 1, "Samra", "Hey");
              assertEquals(n.user_name, a.user_name);
              assertEquals(n.opt, a.opt);
              assertEquals(n.note, a.note);
             
	       
            } 
	}