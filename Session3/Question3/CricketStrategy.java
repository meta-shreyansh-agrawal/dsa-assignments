package Session3.Question3;

import java.util.PriorityQueue;
import java.util.Scanner;

import Utility.Utils;

public class CricketStrategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of bowlers: ");
        int numBowlers = Utils.inputNaturalNumber(scanner); 
        
        // adding ballers to priority queue based on the numbers of balls
        PriorityQueue<Bowler> priorityQueue = new PriorityQueue<>();
        System.out.println("Enter the quota of each bowler (number of balls they can bowl): ");
        for (int i = 0; i < numBowlers; i++) {
            System.out.print("Enter the name of Bowler: ");
            String name = scanner.nextLine(); 
            System.out.print("Enter the number of Balls: ");
            int balls = Utils.inputNaturalNumber(scanner); 
            priorityQueue.add(new Bowler(name, balls)); 
        }

        System.out.print("Enter the total number of balls Virat will play: ");
        int ballsToPlay = Utils.inputNaturalNumber(scanner);

        // using priority queue to get the stragety sequence of bowlers
        System.out.println("Bowling order:");
        while (ballsToPlay > 0 && !priorityQueue.isEmpty()) {
            Bowler currentBowler = priorityQueue.poll();
            System.out.println("Bowler: " + currentBowler.getName());
            currentBowler.decrementBalls();
            ballsToPlay--;
            if (currentBowler.getBalls() > 0) {
                priorityQueue.add(currentBowler);
            }
        }
        if (ballsToPlay > 0) {
            System.out.println("All bowlers exhausted their quotas!");
        } else {
            System.out.println("Bowling completed successfully.");
        }
    }
  
}
