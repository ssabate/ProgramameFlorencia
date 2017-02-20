/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programameflorencia;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author salcu
 */
public class ProgramameFlorencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ent=new Scanner(System.in);
        Pattern pattern=null;
            try{
                pattern  = Pattern.compile("-?\\d+");
            }catch(PatternSyntaxException e){            
                System.out.println("Error a l'expressió regular: "+e.getDescription()+"\nTorna-ho a provar.");
              
            }
        int lonVar=Integer.valueOf(ent.next(pattern));
        int numVars=0;  
        int retals=0;
        boolean imposible=false;
        while (lonVar!=-1) {
            int nervios=Integer.valueOf(ent.next(pattern));
            if(nervios!=-1){
                int segm=Integer.valueOf(ent.next(pattern));
                int lonSegm=Integer.valueOf(ent.next(pattern));
                if(lonSegm>lonVar){
                    imposible=true;
                    continue;
                }
                int segmPerVarilla=lonVar/lonSegm;
                int retalPerVarilla=lonVar%lonSegm;
                int quantSegm=segm*nervios;

                numVars+=quantSegm/segmPerVarilla;
                retals+=numVars*retalPerVarilla;
                int sobrant=quantSegm%segmPerVarilla;
                if(sobrant!=0){
                    numVars++;
                    retals+=lonVar-(sobrant*lonSegm);
                }
                
            }
            else{
                if(!imposible) System.out.format("%d %d\n", numVars, retals);
                else System.out.println("IMPOSIBLE");
                numVars=0;  
                retals=0;
                imposible=false;
                lonVar=Integer.valueOf(ent.next(pattern));
            }
        }
        ent.close();
    }
    
}
 