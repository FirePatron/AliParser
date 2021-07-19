/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aliparser;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Aliparser {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
            
            ShowFrame sf = new ShowFrame();
            sf.setVisible(true);
        
            HttpThread t = new HttpThread();
            t.start();            
            while(t.isAlive()){
            }            
            
            Scrapper scrapper = new Scrapper();
            List<Good> lg = scrapper.getGood(t.returnPage());
        
            Saver saver = new Saver();
            saver.saveFile(lg);
            sf.setExitEnable();
    }
 
    
}
