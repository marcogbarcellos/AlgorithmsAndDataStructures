/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class AlgorithmCountAnagramsInFile {
    public static boolean isAnagram(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }
        if(word1.length() == 0 && word2.length() == 0) {
            return true;
        }
        if(word2.indexOf(word1.substring(0, 1)) > -1) {
            StringBuilder sb = new StringBuilder(word2);
            sb.deleteCharAt(word2.indexOf(word1.substring(0, 1)));
            return isAnagram(word1.substring(1,word1.length()), sb.toString());
            
        } else {
            return false;
        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new FileInputStream("/Users/marco/Documents/anagrams.txt"));
        
        Map<String,List<Integer>> map = new HashMap();
        int count = 1;
        while(scan.hasNext()) {
            String currentLine = scan.next();
            if(map.size() > 0) {
                Iterator it = map.entrySet().iterator();
                List valuesList = new ArrayList();
                List<String> keysList = new ArrayList();
                boolean hasAnagram = false;
                while (it.hasNext())
                {
                    Map.Entry item = (Map.Entry) it.next();
                    if (isAnagram(currentLine, (String)item.getKey())) {
                        hasAnagram = true;
                        valuesList = (ArrayList)item.getValue();
                        keysList.add((String)item.getKey());
                        
                    }
                }
                valuesList.add(count);
                map.put(currentLine, valuesList);
                for(String item: keysList) {
                    map.put(item, valuesList);
                }
                
                
            } else {
                List<Integer> value = new ArrayList();
                value.add(count);
                map.put(currentLine, value);
            }
            count++;
        }
        FileWriter writer = new FileWriter(new File("/Users/marco/Documents/anagramsInserted.txt"));
        
        Iterator it = map.entrySet().iterator();
        List valuesList = new ArrayList();
        List<String> keysList = new ArrayList();
        boolean hasAnagram = false;
        while (it.hasNext())
        {
            Map.Entry item = (Map.Entry) it.next();
            String str = (String) item.getKey();
            for(Integer i: (List<Integer>)item.getValue()){
                str = str+" "+i;
            }
            System.out.println("string:"+str);
            writer.write(str);
            writer.write(System.getProperty("line.separator"));
            
        }
        writer.flush();
        writer.close();
        System.out.println("isAnagram:");
    }
}

