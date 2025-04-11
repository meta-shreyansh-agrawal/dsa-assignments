package Session4;

import java.util.Scanner;
import java.util.Stack;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        while(true){    
            try{
                System.out.println("Enter the formula in uppercase"); 
                String formula = sc.nextLine(); 
                Stack<Integer> massStack = new Stack<>(); 
                int i = 0; 
                int C_MASS = 12; 
                int O_MASS = 16; 
                int H_MASS = 1;
                massStack.push(0); 
                while(i<formula.length()){
                    char c = formula.charAt(i); 
                    if(c=='C'){
                        massStack.push(C_MASS);
                        i++; 
                    }else if(c=='O'){
                        massStack.push(O_MASS);
                        i++; 
                    }else if(c=='H'){
                        massStack.push(H_MASS);
                        i++;
                    }else if(c=='('){
                        massStack.push(0); 
                        i++; 
                    }else if(c==')'){
                        i++; 
                        int multiplier = 0;
                        while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                            multiplier = multiplier * 10 + (formula.charAt(i) - '0');
                            i++;
                        }
                        multiplier = (multiplier == 0) ? 1 : multiplier;
                        int groupMass = 0; 
                        while(!(massStack.peek()==0))groupMass+=massStack.pop(); 
                        massStack.push(massStack.pop() + groupMass * multiplier); 
                    }else if(Character.isDigit(c)){
                        int count = 0;
                        while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                            count = count * 10 + (formula.charAt(i) - '0');
                            i++;
                        }
                        int lastMass = massStack.pop();
                        massStack.push(lastMass * count);
                    }else{
                        throw new IllegalArgumentException(); 
                    }
                }
                int mass = 0; 
                while(!massStack.isEmpty())mass+=massStack.pop(); 
                System.out.println("Molecular mass of " + formula + " is: " + mass);
                sc.close();
                return; 
            }catch(IllegalArgumentException e){
                System.out.println("Enter valid Formula");
            }
        }
    }
}