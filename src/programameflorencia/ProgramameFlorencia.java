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
        long lV=Long.valueOf(ent.next(pattern));
        long nVars=0;  
        long retals=0;
        long ultimRetal=0;
        boolean imposible=false;
        boolean primero=true;
        while (lV!=-1) {
            
            long nN=Long.valueOf(ent.next(pattern));
            if(nN!=-1){
                primero=false;
                long nS=Long.valueOf(ent.next(pattern));
                long lS=Long.valueOf(ent.next(pattern));
                if(imposible) continue;
                if(lS>lV || lS==0 || nS==0 || nN==0 || lV==0){
                    imposible=true;
                    continue;
                }
                long nSegm=nS*nN;
                if(ultimRetal!=0 && ultimRetal>=lS){
                    long qSR=ultimRetal/lS;
                    if(nSegm<=qSR){
                        ultimRetal-=nSegm*lS;
                        retals-=nSegm*lS;
                        nSegm=0;                    
                    } else {
                        nSegm-=qSR;
                        retals-=qSR*lS;
                        ultimRetal-=qSR*lS;
                    }
                }
                long qSV=lV/lS;
                nVars+=nSegm/qSV;
                long rVE=lV%lS;
                retals+=(nSegm/qSV)*rVE;

                if(nSegm%qSV!=0){
                        nVars++;
                        ultimRetal=lV-lS*(nSegm%qSV);
                        retals+=ultimRetal;
                }
                
            }
            else{
                if(imposible || primero) System.out.println("IMPOSIBLE");
                else System.out.format("%d %d\n", nVars, retals);
                nVars=0;  
                retals=0;
                imposible=false;
                primero=true;
                ultimRetal=0;
                lV=Long.valueOf(ent.next(pattern));
            }
        }
        ent.close();
    }
    
}
 