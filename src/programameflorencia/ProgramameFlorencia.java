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
        Scanner ent=new Scanner(System.in);;
        Pattern pattern=null;
            try{
                pattern  = Pattern.compile("-?\\d+");
            }catch(PatternSyntaxException e){            
                System.out.println("Error a l'expressió regular: "+e.getDescription()+"\nTorna-ho a provar.");
              
            }
        long lonVar=Long.valueOf(ent.next(pattern));
        long numVars=0;  
        long retals=0;
        long ultimRetal=0;
        boolean imposible=false;
        boolean primero=true;
        while (lonVar!=-1) {
            
            long nervios=Long.valueOf(ent.next(pattern));
            if(nervios!=-1){
                primero=false;
                long segm=Long.valueOf(ent.next(pattern));
                long lonSegm=Long.valueOf(ent.next(pattern));
                if(lonSegm>lonVar || lonSegm==0 || segm==0 || nervios==0 || lonVar==0){
                    imposible=true;
                    continue;
                }
                long segmPerVarilla=lonVar/lonSegm;
                long retalPerVarilla=lonVar%lonSegm;
                long quantSegm=segm*nervios;
                if(ultimRetal!=0){
                    long quantAnt=quantSegm;
                    quantSegm=(quantSegm-ultimRetal/lonSegm>0?quantSegm-ultimRetal/lonSegm:0);
                    retals=retals-(quantAnt-quantSegm)*lonSegm;
                }

                if(quantSegm<=segmPerVarilla){
                    if(quantSegm!=0){
                        numVars++;
                        retals+=lonVar-(quantSegm*lonSegm);
                        ultimRetal=lonVar-(quantSegm*lonSegm);
                    }
                }
                else{
                    numVars+=quantSegm/segmPerVarilla;
                    retals+=(quantSegm/segmPerVarilla)*retalPerVarilla;
                    long sobrant=quantSegm%segmPerVarilla;
                    if(sobrant!=0){
                        numVars++;
                        ultimRetal=lonVar-(sobrant*lonSegm);
                        retals+=ultimRetal;
                    }
                }
                
            }
            else{
                if(imposible || primero) System.out.println("IMPOSIBLE");
                else System.out.format("%d %d\n", numVars, retals);
                numVars=0;  
                retals=0;
                imposible=false;
                primero=true;
                ultimRetal=0;
                lonVar=Long.valueOf(ent.next(pattern));
            }
        }
        ent.close();
    }
    
}
 