/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author marco
 */
class URL {
    private String longURL;
    private String shortURL;

    public URL(String longURL, String shortURL) {
        this.longURL = longURL;
        this.shortURL = shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public String getShortURL() {
        return shortURL;
    }    
}

class TableURL {
    private final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private int count;
    private Map<Integer,URL> URLs;
    public TableURL () {
        this.count = 1;
        URLs = new HashMap();
    }
    public void addURL(String longURL) {
        String shortURL = encode(count);
        URL newURL = new URL(longURL,shortURL);
        URLs.put(count, newURL);
        count++;
    }
    private String encode(int id) {
        int base = ALPHABET.length;
        String shortUrl = "";
        while(id>0) {
            char a = ALPHABET[id%base];
            shortUrl = shortUrl+a;
            id = id/base;
        }
        System.out.println("shortUrl:"+shortUrl);
        return shortUrl;
    }
    public String getURL(String shortURL) {
        int id = decode(shortURL);
        return URLs.get(id).getLongURL();
    }
    private int decode(String shortURL) {
        char[] urlArray = shortURL.toCharArray();
        int id = 0;
        for (int i=0; i<urlArray.length;i++) {
            for (int j=0; j<ALPHABET.length;j++) {
                if(urlArray[i] == ALPHABET[j]) {
                    //e9a62 = [4,61,0] = 4×622 + 61×621 + 0×620 = 1915810
                    id =  (int) (id + (j * Math.pow((double)ALPHABET.length, (double)(urlArray.length-i-1))));
                }
                
            }
        }
        return id;
    }
}

public class AlgorithmURLShortener {
    public static void main(String[] args) {
        TableURL table = new TableURL();
        
        for(int i=0; i< 1000; i++) {
            table.addURL("test"+i);
        }
        for(int i=0; i< 1000; i++) {
            System.out.println("for short Url b, long URL:"+table.getURL("test"+i));
        }
        
                
    }
}
