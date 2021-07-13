/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aliparser;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class Aliparser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
            
            ShowFrame sf = new ShowFrame();
            sf.setVisible(true);
        
            HtmlPage page = null;
            
            HttpThread t = new HttpThread();
            t.start();            
            while(t.isAlive()){
            }
            page=t.returnPage();
            
            Document doc = Jsoup.parse(page.asXml());            
            Elements h1El = doc.getElementsByClass("deals-item-inner");
            System.out.println(h1El.size());
                                    
            List<Good> lg = Scrapper.getGood(h1El);
        
            File f = new File("output\\output.csv");
            f.delete();
            FileWriter fw = new FileWriter(f);
            int i=1;
            fw.write("number,main ref,img,title,curPrice,originalPrice,sold,soldPercent\n");
            for(Good g:lg){
                fw.write(i+","+g.toString()+"\n");
                i++;
            }
            fw.close();
        
            sf.setExitEnable();
    }
 
    
}
