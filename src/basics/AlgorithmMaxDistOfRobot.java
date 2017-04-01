/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
 * Given a robot which is on Origin in a number line and a string that contains either ‘L’ , ‘R’ or ‘?’. 
 * ‘L’ means turn left and ‘R’ means turn right. ‘?’ can be assumed to be ‘L’ or ‘R’. 
 * Find the maximum distance from origin the robot can go at any point of time. 
 */
public class AlgorithmMaxDistOfRobot {
    
    public static int countChar(String s, char c) {
        int count = 0;
        for (int i=0;i<s.length();i++) {
            if(s.charAt(i) == c) {
                count++;
            }
        }
        
        return count;
    }
    public static int findMaxDist(String path) {
        if(countChar(path,"L".charAt(0)) >= countChar(path,"R".charAt(0))){
            path = path.replace("?", "L");
            System.out.println("new path:"+path);
            return countChar(path,"L".charAt(0)) - countChar(path,"R".charAt(0));
        } else {
            path = path.replace("?", "R");
            System.out.println("new path:"+path);
            return countChar(path,"R".charAt(0)) - countChar(path,"L".charAt(0));
        }
    }
    
    public static void main(String[] args) {
        String path = "LRRRL??R??LRRL?RL??LRRL?LLLLLLLLLLLLLLL";
        System.out.println("path:"+path);
        int maxDist = findMaxDist(path);
        System.out.println("maxDist:"+maxDist);
    }
}
