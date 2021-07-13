/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aliparser;

/**
 *
 * @author Admin
 */
public class Good {
    
    private String url;
    private String imgUrl;
    private String title;
    private String curPrice;
    private String originalPrice;
    private String sold;
    private String soldPercent;

    public Good() {
    }

    public Good(String url, String imgUrl, String title, String curPrice, String originalPrice, String sold, String soldPercent) {
        this.url = url;
        this.imgUrl = imgUrl;
        this.title = title;
        this.curPrice = curPrice;
        this.originalPrice = originalPrice;
        this.sold = sold;
        this.soldPercent = soldPercent;
    }
          

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(String curPrice) {
        this.curPrice = curPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getSoldPercent() {
        return soldPercent;
    }

    public void setSoldPercent(String soldPercent) {
        this.soldPercent = soldPercent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
       
    @Override
    public String toString() {
        return this.url+","+this.imgUrl+","+title+","+curPrice+","+originalPrice+","+sold+","+soldPercent;
    }
    
    
}
