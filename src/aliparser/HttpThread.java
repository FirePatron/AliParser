/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aliparser;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class HttpThread extends Thread{

    public HttpThread() {
    }

    private HtmlPage page1 = null;
    
    private final WebClient web = new WebClient(BrowserVersion.EDGE);
    
    @Override
    public void run() {
        
        try {
           
            web.getOptions().setJavaScriptEnabled(true);
         
            web.getOptions().setThrowExceptionOnScriptError(false);
            web.getOptions().setCssEnabled(false);
            
            web.getCurrentWindow().setInnerHeight(90000);
            web.getOptions().setScreenHeight(90000);
            page1 = web.getPage("https://flashdeals.aliexpress.com/en.htm");
            
            
            page1.executeJavaScript("window.scrollTo(0, 90000);");
            
            System.out.println(page1.getWebClient().getCurrentWindow().getInnerHeight());    
            web.waitForBackgroundJavaScript(12000);
            
            
            
        } catch (FailingHttpStatusCodeException | IOException e) {
            System.out.println(e.toString());
        }
        web.close();
    }
    
    public HtmlPage returnPage(){
        return this.page1;
    }

    
}
