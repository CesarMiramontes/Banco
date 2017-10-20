/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static java.lang.Math.random;

/**
 *
 * @author Cesar
 */
public class Personaje {
    int especie, posicion;
    private final static int ANCHO = 1300;
    private final static int ALTO = 680;
    float x=1300, y=500;
    int vx = -200, vy = 0;
    int s=0, espera =0;
    
    Personaje(){
        especie = (int) (random() *7);
        //posicion = (int) (random() *5);
        //System.out.println(posicion);
    }
    
    public void esperar(float dt, int i){
        switch (i){
            case 0:
                if (x > (ANCHO/2)){
                    x+= vx*dt;
                }
                break;
            case 1:
                if (x > (ANCHO/2)+100){
                    x+= vx*dt;
                }
                break;
            case 2:
                if (x > (ANCHO/2)+200){
                    x+= vx*dt;
                }
                break;
            case 3:
                if (x > (ANCHO/2)+300){
                    x+= vx*dt;
                }
                break;
            case 4:
                if (x > (ANCHO/2)+400){
                    x+= vx*dt;
                }
                break;
            default:
                break;
        }
    }
    
    public void pagar(float dt){
        //System.out.println(c);
        switch(posicion){
            case 0:
                if (s == 0){
                    if( y > 200){
                        vx = 0; vy = -200;
                        //x += vx * dt;
                        y += vy * dt;
                    }else{
                        //System.out.println( 100);
                        if ( x > 10 ){
                            //System.out.println(x+=vx*dt);
                            vx = -200; vy = 0;
                            x += vx * dt;
                            //y += vy * dt;
                        }else{
                            vx = 0; vy = -200;
                            //System.out.println(vy*dt);
                            x += vx * dt;
                            y += vy * dt;
                        }
                    }
                    if( y <= 0){
                        s = 1;
                    }
                }else{
                    if (espera < 500){
                        espera++;
                    }else{
                        vx = 0; vy = 1000;
                        x += vx * dt;
                        y += vy * dt;
                    }
                }
                if ( y > 680){
                    //x=ANCHO/2; y=500;
                    //s = espera = 0;
                }
                break;
                
            case 1:
                if (s == 0){
                    if( y > 200){
                        vx = 0; vy = -200;
                        //x += vx * dt;
                        y += vy * dt;
                    }else{
                        //System.out.println( 100);
                        if ( x > 300 ){
                            vx = -200; vy = 0;
                            x += vx * dt;
                            //y += vy * dt;
                        }else{
                            vx = 0; vy = -200;
                            x += vx * dt;
                            y += vy * dt;
                        }
                    }
                    if( y <= 0){
                        s = 1;
                    }
                }else{
                    if (espera < 500){
                        espera++;
                    }else{
                        vx = 0; vy = 1000;
                        x += vx * dt;
                        y += vy * dt;
                    }
                }
                if ( y > 680){
                    //x=ANCHO/2; y=500;
                    //s = espera = 0;
                }
                break;
                
            case 2:
                if (s == 0){
                    if( y > 200){
                        vx = 0; vy = -200;
                        //x += vx * dt;
                        y += vy * dt;
                    }else{
                        //System.out.println( 100);
                        if ( x > 570 ){
                            vx = -200; vy = 0;
                            x += vx * dt;
                            //System.out.println(x + " " + (x < 970));
                            //y += vy * dt;
                        }else{
                            vx = 0; vy = -200;
                            //x += vx * dt;
                            y += vy * dt;
                        }
                    }
                    if( y <= 0){
                        s = 1;
                    }
                }else{
                    if (espera < 500){
                        espera++;
                    }else{
                        vx = 0; vy = 1000;
                        x += vx * dt;
                        y += vy * dt;
                    }
                }
                if ( y > 680){
                    //x=ANCHO/2; y=500;
                    //s = espera = 0;
                }
                break;
            case 3:
                if (s == 0){
                    if( y > 200){
                        vx = 0; vy = -200;
                        //x += vx * dt;
                        y += vy * dt;
                    }else{
                        
                        if ( x < 840 ){
                            //int c;
                            vx = 200; vy = 0;
                            //System.out.println(x+=vx*dt);
                            //x++;
                            x += vx * dt;
                        }else{
                            vx = 0; vy = -200;
                            //x += vx * dt;
                            y += vy * dt;
                        }
                    }
                    if( y <= 0){
                        s = 1;
                    }
                }else{
                    if (espera < 500){
                        espera++;
                    }else{
                        vx = 0; vy = 1000;
                        x += vx * dt;
                        y += vy * dt;
                    }
                }
                if ( y > 680){
                    //x=ANCHO/2; y=500;
                    //s = espera = 0;
                }
                break;
                
            case 4:
                if (s == 0){
                    if( y > 200){
                        vx = 0; vy = -200;
                        //x += vx * dt;
                        y += vy * dt;
                    }else{
                        
                        if ( x < 1099 ){
                            //int c;
                            vx = 200; vy = 0;
                            //System.out.println(x+=vx*dt);
                            //x++;
                            x += vx * dt;
                        }else{
                            vx = 0; vy = -200;
                            //x += vx * dt;
                            y += vy * dt;
                        }
                    }
                    if( y <= 0){
                        s = 1;
                    }
                }else{
                    if (espera < 500){
                        espera++;
                    }else{
                        vx = 0; vy = 1000;
                        x += vx * dt;
                        y += vy * dt;
                    }
                }
                if ( y > 680){
                    //x=ANCHO/2; y=500;
                    //s = espera = 0;
                }
                break;
            }
    }
    
    int funAux(int x, int vx, float dt){
        return x+=vx*dt;
    }
    
}
