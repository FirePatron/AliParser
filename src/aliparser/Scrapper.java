/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aliparser;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class Scrapper {
    
    public static List<Good> getGood(Elements elements){
        List<Good> goodList = new ArrayList<>();            
        for(Element e:elements){
            Element lvl1E = e.child(0);
            String url = lvl1E.attr("href"); //main reference

            Elements lvl2E = lvl1E.children();
            String imgUrl = lvl2E.get(0).child(0).attr("src"); //image ref

            Elements lvl3E = lvl2E.get(1).children();
            String title = lvl3E.get(0).text();
            String curPrice = lvl3E.get(1).text();
            String originalPrice = lvl3E.get(2).text();
                //stock
                Elements lvl4E = lvl3E.get(3).children();
                Elements lvlStock = lvl4E.get(1).children();
                String sold = lvlStock.get(0).text();
                String soldPercent = lvlStock.get(1).text();

            goodList.add(new Good(url, imgUrl, title, curPrice, originalPrice, sold, soldPercent));
        }
        return goodList;
    }
     
}
