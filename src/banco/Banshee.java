/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cesar
 */
public class Banshee extends Thread {
    LinkedList <Personaje> a;
    
    Banshee (LinkedList a){
        this.a = a;
        start();
    }
    
    @Override
    public void run(){
        while(true){
            try {
                a.add(new Personaje());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Banshee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
