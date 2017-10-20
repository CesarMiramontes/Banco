/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Cesar
 */
public class Banco extends JComponent{

    /**
     * @param args the command line arguments
     */
    private final static int ANCHO = 1300;
    private final static int ALTO = 680;
    int x=ANCHO/2, y=500;
    int vx = 0, vy = 0;
    int s=0, espera =0, index = -1, index2=0;
    ImageIcon personaje [] = new ImageIcon[6];
    ImageIcon piso, atm, police, escudo;
    Personaje aux;
    int tam = 0;
    LinkedList <Personaje> p = new LinkedList <Personaje>(), 
            c = new LinkedList <Personaje> ();
    Peluquero cls;
    Clientes cl;
    boolean flag = true;
    
    Banco(){
        setPreferredSize(new Dimension(ANCHO,ALTO));
        cl = new Clientes(c);
        cls = new Peluquero(p);
        new Juego();
        piso =  new ImageIcon ("src\\resources\\Halo_wallpaper_ring_by_mcnealy-d675h89.jpg");
        personaje[0] =  new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\latest(2).png");
        personaje[1] =  new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\Hunter_H4.png");
        personaje[2] =  new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\HReach_-_Skirmisher.png");
        personaje[3] =  new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\HReach_-_Heavy_Unggoy.png");
        personaje[4] =  new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\H3_MasterChief_Crouch.png");
        personaje[5] =  new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\HReach_-_Minor_Jiralhanae.png");
        police = new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\officer_128.png");
        escudo = new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\401px-Fullmetal_Alchemist_Anime_Logo.svg.png");
        atm =  new ImageIcon ("C:\\Users\\Cesar\\Documents\\NetBeansProjects\\Banco\\src\\resources\\Terminal.png");
    }
    
    public void cicloPrincipalJuego() throws Exception{
        long tiempoViejo = System.nanoTime();
        while(true){
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViejo)/1000000000f;
            tiempoViejo = tiempoNuevo;
            //p = cls.getL();
            //c = cl.getL();
            fisica(dt);
            dibuja();
        }
    }
    
    private void fisica(float dt){
        try{
            for (int i = 0; i < p.size(); i++){
                
                //System.out.println(index);
                p.get(i).esperar(dt, i);
                //p.get(i).posicion = index;
            }
            //System.out.println(c.size());
            if ( flag == true && c.size()!=5){
                if (((int) p.get(0).x) <= (ANCHO/2)){
                    if(index == 4){
                        //index = 0;
                        flag = false;
                    }else{
                        index++;
                    }
                    aux = p.get(0);
                    cls.kill();
                    aux.posicion = index;
                    cl.sig(index, aux);
                }
                //c.getLast().posicion = index;
            }
            
            //if ( c.size() <= 5){
                for(int i=0; i<5; i++){
                    if (c.get(i).y >580 ){
                        index = c.get(i).posicion;
                        cl.kill(i);
                        p.getFirst().posicion = index;
                        cl.sig(i, p.getFirst());
                        cls.kill();
                    }
                }
                    //cl.kill();
           // }
            //index2++;
            //System.out.println(index2);
        }catch(Exception e){
            //System.err.println(p.get(0).x == (ANCHO/2));
        }
        try{
            for (int i = 0; i < c.size(); i++){
                c.get(i).pagar(dt);
            }
        }catch(Exception e){
            
        }
        
    }
    
    @Override
    public void paint(Graphics g){
        int mm=30;
        g.setColor(Color.BLACK);
        piso.paintIcon(this, g, 0, 0);
        
        police.paintIcon(this, g, 300, 300);
        //escudo.paintIcon(this, g, 500, 150);
        for (int i=0; i<5; i++){
            atm.paintIcon(this, g, mm, 0);
            mm =mm+268;
        }
        for (int i = 0; i<p.size(); i++){
            personaje[p.get(i).especie].paintIcon(this, g, (int) p.get(i).x, (int) p.get(i).y);
        }
        for (int i = 0; i<c.size(); i++){
            personaje[c.get(i).especie].paintIcon(this, g, (int) c.get(i).x, (int) c.get(i).y);
            if(c.get(i).y <= 0 && i < 5){
                bar(g, c.get(i));
            }
        }
        g.setColor(Color.red);
        g.fillRect(90+(ANCHO)/2, 500, 500, 5);
        g.setColor(Color.white);
        //g.fill3DRect(400, 450, 200, 200, true);
        g.setColor(Color.black);
        //g.drawRect(400, 450, 200, 200);
        //g.drawRect(402, 452, 200, 200);
        g.setColor(Color.black);
        g.setFont(new Font("", Font.TRUETYPE_FONT, 120));
        g.drawString(Integer.toString(index+1), 470, 550);
        
    }
    
    private void bar(Graphics g, Personaje pp){
        g.setColor(Color.black);
        //System.out.println(pp.posicion);
        switch(pp.posicion){
            case 0:
                g.draw3DRect(50, 200, 100, 10, true);
                g.setColor(Color.green);
                g.fillRect(50, 200, (pp.espera*100)/500, 10);
                break;
            case 1:
                g.draw3DRect(320, 220, 100, 10, true);
                g.setColor(Color.green);
                g.fillRect(320, 220, (pp.espera*100)/500, 10);
                //System.out.println((pp.espera*100)/500);
                break;
            case 2:
                g.draw3DRect(590, 200, 100, 10, true);
                g.setColor(Color.green);
                g.fillRect(590, 200, (pp.espera*100)/500, 10);
                break;
            case 3:
                g.draw3DRect(860, 220, 100, 10, true);
                g.setColor(Color.green);
                g.fillRect(860, 220, (pp.espera*100)/500, 10);
                break;
            case 4:
                g.draw3DRect(1130, 200, 100, 10, true);
                g.setColor(Color.green);
                g.fillRect(1130, 200, (pp.espera*100)/500, 10);
                break;
        }
    }
    
    private void dibuja() throws Exception{
        SwingUtilities.invokeAndWait(new Runnable(){
            @Override
            public void run(){
                paintImmediately(0, 0, ANCHO, ALTO);
            }
        });
    }
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        JFrame jf = new JFrame ("Banco Nacional");
        jf.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        jf.setResizable(false);
        Banco demo1 = new Banco();
        //EjemploGrafico1 demo2 = new EjemploGrafico1(30,50,500,400);
        jf.getContentPane().add(demo1);
        //jf.getContentPane().add(demo2);
        jf.pack();
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
    }
    
}

class Juego extends Thread{

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    String g = "C:\\Users\\Cesar\\Music\\Halo OSTs\\Halo CE\\1-26 - Martin O'Donnell & Michael Salvatori - Halo.mp3";
    Player player;
    
    public Juego(){
        start();
    }
    
    
    
    @Override
    public void run(){
        try {
            FileInputStream fis;
            
            fis = new FileInputStream(g);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis); 
            player.play();  
            
            //demo1.Flag=false;   
        } catch (FileNotFoundException | JavaLayerException e ) {
        	System.out.println(e);
        }
    }
}