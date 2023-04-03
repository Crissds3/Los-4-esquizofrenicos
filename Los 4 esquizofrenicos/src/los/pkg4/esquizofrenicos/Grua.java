
package los.pkg4.esquizofrenicos;

public class Grua {

 
   
     protected double[] base(double x, double y) {

        double[] coordenada = {
            x,y ,x+100,y,
            x,y,x,y+50,
            x,y+50,x+100,y+50,
            x+100,y+50,x+100,y
                
                
               
         
        
          
        };
        return coordenada;
    }
     
      protected double[] cuerda(double x, double y) {

        double[] coordenada = {
         x,y,x,y+100,
                
                

        
          
        };
        return coordenada;
    }
    
      
        protected double[] iman(double x, double y) {

        double[] coordenada = {
         x-20,y,x+20,y,
         x-20,y,x-30,y+30,
         x-30,y+30,x-30,y+60,
         x-30,y+60,x-20,y+60,
         x-20,y+60,x-20,y+40,
         x-20,y+40,x-15,y+30,
         x-15,y+30,x+15,y+30,
         x+15,y+30,x+20,y+40,
         x+20,y+40,x+20,y+60,
         x+20,y+60,x+30,y+60,
         x+30,y+60,x+30,y+30,
         x+30,y+30,x+22,y,
         
                
                
                
                
               
        
          
        };
        return coordenada;
    }
}
