/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmsc141_mp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MiriamMarie
 */
public class MP1 {
    static int[] state;
    static ArrayList list = new ArrayList();
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner in = new Scanner(new File(args[0]));
        
        while(in.hasNext()){
            list.add(in.nextLine());
        }
        
        String firstLine = list.get(0).toString();
        String [] temp = firstLine.split(" ");
        
        state = new int[temp.length];
        for(int i = 0; i < temp.length; i++){
            state[i] = Integer.valueOf(temp[i]);
        }
        
        execute();
    }
    
    static public void execute() throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter("mp1.out", "UTF-8");
        for (int i = 1; i < list.size(); i++){
            String temp = list.get(i).toString();
            char letter = temp.charAt(0);
            String [] tempArr = temp.split(" ");
            int arg1 = Integer.valueOf(tempArr[1]);
            int arg2;
            
            switch(letter){
                case 'S':
                    state[arg1] = state[arg1] + 1;
                    break;
                    
                case 'Z':
                    state[arg1] = 0;
                    break;
                    
                case 'J':
                    int jumpTo = Integer.valueOf(tempArr[3]);
                    arg2 = Integer.valueOf(tempArr[2]);
                    
                    if (state[arg1] == state[arg2]){
                        i = jumpTo - 1;
                    }
                    
                    break;
                    
                case 'C':
                    arg2 = Integer.valueOf(tempArr[2]);
                    state[arg2] = state[arg1];
                    break;
            }
            
            for (int j = 0; j < state.length; j++){
                System.out.print(state[j]+" ");
                writer.print(state[j]+" ");
            }
            System.out.println("");
            writer.println();
        }
        writer.close();
    }
}


