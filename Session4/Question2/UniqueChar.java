package Session4.Question2;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueChar {
    public static void printMap(HashMap<Character,Integer> map){
        for(HashMap.Entry<Character,Integer> entry: map.entrySet()){
            System.out.println("key: "+entry.getKey()+"\tValue: "+entry.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        HashMap<String,HashMap<Character,Integer>> inputs = new HashMap<>(); 
        while(true){
            System.out.println("Enter String or 0 to exit");
            String str = sc.nextLine().trim(); 
            if(str.equals("0")){
                sc.close();
                return; 
            }
            if(inputs.containsKey(str)){
                System.out.println("Fetching Previous stored data");
                HashMap<Character,Integer> map = inputs.get(str);
                printMap(map);  
            }else{
                System.out.println("Processing");
                HashMap<Character,Integer> map = new HashMap<>(); 
                for(char c:str.toCharArray()){
                    if(c==' ')continue; 
                    map.put(c, map.getOrDefault(c, 0)+1); 
                }
                inputs.put(str, map); 
                printMap(map);  
            }
        }
    }    
}
