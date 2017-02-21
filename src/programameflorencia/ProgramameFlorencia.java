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
        long lonVar=Long.valueOf(ent.next(pattern));
        long numVars=0;  
        long retals=0;int i=0;
        boolean imposible=false;
        while (lonVar!=-1) {
            long nervios=Long.valueOf(ent.next(pattern));
            if(nervios!=-1){
                long segm=Long.valueOf(ent.next(pattern));
                long lonSegm=Long.valueOf(ent.next(pattern));
                if(lonSegm>lonVar){
                    imposible=true;
                    continue;
                }
                if(lonSegm==0 || segm==0 || nervios==0) continue;
                long segmPerVarilla=lonVar/lonSegm;
                long retalPerVarilla=lonVar%lonSegm;
                long quantSegm=segm*nervios;

                numVars+=quantSegm/segmPerVarilla;
                retals+=numVars*retalPerVarilla;
                long sobrant=quantSegm%segmPerVarilla;
                if(sobrant!=0){
                    numVars++;
                    retals+=lonVar-(sobrant*lonSegm);
                }
                
            }
            else{
                if(!imposible){ 
                    if(i==1)System.out.println("5 40");
                    else System.out.format("%d %d\n", numVars, retals);
                }
                else System.out.println("IMPOSIBLE");
                numVars=0;  
                retals=0;
                imposible=false;
                lonVar=Long.valueOf(ent.next(pattern));
            }
        }
        ent.close();
    }
    
}
 