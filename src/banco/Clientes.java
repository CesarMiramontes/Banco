/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.LinkedList;

/**
 *
 * @author Cesar
 */
public class Clientes extends Thread {
    LinkedList <Personaje> p = new LinkedList <Personaje> ();
    private final int max = 5;
    
    Clientes( LinkedList p ){
        this.p = p;
        start();
    }
    
    @Override
    public void run(){
        while(true){
            /*try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                //
            }*/
            
        }
    }
    
    LinkedList getL(){
        return this.p;
    }
    
    public void sig(int i, Personaje x){
        //System.out.println();
        switch(i){
            case 0:
                System.out.println("cajero 0");
            break;    
        }
        p.add(i, x);
    }
    
    public void kill(int i){
        //System.out.println(p.size());
        p.remove(i);
    }
    
}