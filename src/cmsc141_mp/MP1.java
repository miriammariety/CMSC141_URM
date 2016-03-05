/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmsc141_mp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MiriamMarie
 */
public class MP1 {
    static int[] state;
    static ArrayList list = new ArrayList();
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File(args[0]));
        
        while(in.hasNext()){
            list.add(in.nextLine());
        }
        
        String firstLine = list.get(0).toString();
        firstLine = firstLine.replaceAll(" ", "");
        System.out.println(firstLine);
        
        state = new int[firstLine.length()];
        for(int i = 0; i < firstLine.length(); i++){
            state[i] = (int) firstLine.charAt(i) - 48;
            System.out.print(state[i]);
        }
        
        execute();
    }
    
    static public void execute(){
        for (int i = 1; i < list.size()-1; i++){
            String temp = list.get(i).toString();
            int arg1 = (int) temp.charAt(1) - 48;
            int arg2 = (int) temp.charAt(2) - 48;
            
            temp = temp.replaceAll(" ", "");
            
            char letter = temp.charAt(0);
            switch(letter){
                case 'S':
                    state[arg1] = state[arg1] + 1;
                    break;
                    
                case 'Z':
                    state[arg1] = 0;
                    break;
                    
                case 'J':
                    int jumpTo = (int) temp.charAt(3) - 48;
                    
                    if (state[arg1] == state[arg2]){
                        i = jumpTo - 1;
                    }
                    
                    break;
                    
                case 'C':
                    state[arg1] = state[arg2];
                    break;
            }
                    
        }
    }
}


