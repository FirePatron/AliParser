/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aliparser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Saver {
    
    private File file;
    private String head;

    public Saver() {
        this.file = new File("output//output.csv");
        this.head = "number;main ref;img;title;curPrice;originalPrice;sold;soldPercent\n";
    }
    
    public Saver(String path, String head) {
        this.file = new File(path);
        this.head = head;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
    
    /**
     *
     * @param goodList
     * @throws IOException
     */
    public void saveFile(List<Good> goodList) throws IOException{
        try (FileWriter fw = new FileWriter(file)) {
            int i=1;
            fw.write(head);
            for(Good g:goodList){
                fw.write(i+";"+g.toString()+"\n");
                i++;
            }
        }
    }
    
    
    
}
