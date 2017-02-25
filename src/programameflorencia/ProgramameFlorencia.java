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
        while (lV!=-1) {
            
            long nN=Long.valueOf(ent.next(pattern));
            while(nN!=-1){
                long nS=Long.valueOf(ent.next(pattern));
                long lS=Long.valueOf(ent.next(pattern));
                if(imposible){
                    nN=Long.valueOf(ent.next(pattern));
                    continue;
                }
//                if(lS==0 || nS==0 || nN==0 || lV==0){
//                    continue;
//                }
//                if(lS==0 || nS==0 || nN==0 || lV==0){
//                    continue;
//                }
                if(lS>lV){
                    nN=Long.valueOf(ent.next(pattern));
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
                if(nSegm==0){
                    nN=Long.valueOf(ent.next(pattern));
                    continue;
                }                
                long qSV=lV/lS;
                nVars+=nSegm/qSV;
                long rVE=lV%lS;
                retals+=(nSegm/qSV)*rVE;
                ultimRetal=rVE;
                if(nSegm%qSV!=0){
                    nVars++;
                    ultimRetal=lV-lS*(nSegm%qSV);
                    retals+=ultimRetal;
                }
                nN=Long.valueOf(ent.next(pattern));
            }
            
            if(imposible) System.out.println("IMPOSIBLE");
            else System.out.println(nVars+" "+retals);
            nVars=0;  
            retals=0;
            imposible=false;
            ultimRetal=0;
            lV=Long.valueOf(ent.next(pattern));

        }
        ent.close();
    }
    
}
 