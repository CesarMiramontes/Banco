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
public class Peluquero extends Thread {
    LinkedList <Personaje> p = new LinkedList <Personaje> ();
    private final int max = 5;
    
    Peluquero(LinkedList p){
        this.p = p;
        start();
    }
    
    @Override
    public void run(){
        while (true){
            int a = (int) (Math.random() * 10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Peluquero.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (p.size() < max ){
                p.add(new Personaje());
            }
            
        }
    }
    
    LinkedList getL(){
        return this.p;
    }
    
    public void kill(){
        p.removeFirst();
    }
    
}