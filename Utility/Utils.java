package Utility;
import java.util.Scanner;
import java.util.InputMismatchException; 

public class Utils {
    public static int inputNumberInRange(Scanner sc,int start,int end){
        while(true){
            try{
                int num = sc.nextInt(); 
                if(num<start||num>end){
                    throw new IllegalArgumentException(); 
                }else{
                    sc.nextLine(); 
                    return num; 
                }
            }catch(InputMismatchException e){
                System.out.println("Enter valid Number"); 
                sc.nextLine();
            }catch(IllegalArgumentException e){
                System.out.println("Enter number between "+start+" and "+end); 
                sc.nextLine(); 
            }
        }
    }

    public static int inputNaturalNumber(Scanner sc){
        while(true){
            try{
                int num = sc.nextInt(); 
                if(num<1){
                    throw new IllegalArgumentException(); 
                }else{
                    sc.nextLine(); 
                    return num; 
                }
            }catch(InputMismatchException e){
                System.out.println("Enter valid Number"); 
                sc.nextLine(); 
            }catch(IllegalArgumentException e){
                System.out.println("Enter natural number"); 
                sc.nextLine(); 
            }
        }
    }

    public static int inputWholeNumber(Scanner sc){
        while(true){
            try{
                int num = sc.nextInt(); 
                if(num<0){
                    throw new IllegalArgumentException(); 
                }else{
                    sc.nextLine(); 
                    return num; 
                }
            }catch(InputMismatchException e){
                System.out.println("Enter valid Number"); 
                sc.nextLine(); 
            }catch(IllegalArgumentException e){
                System.out.println("Enter natural number"); 
                sc.nextLine(); 
            }
        }
    }

    public static int inputInteger(Scanner sc){
        while(true){
            try {
                int num = sc.nextInt(); 
                sc.nextLine(); 
                return num; 
            } catch (Exception e) {
                System.out.println("Enter Integer");
                sc.nextLine(); 
            }
        }
    }
}