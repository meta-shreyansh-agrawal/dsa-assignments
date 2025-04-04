package Question3;

import java.util.*;

import Utility.Utils;

public class CollegeCouncelling {

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for programs
        System.out.print("Enter the number of programs: ");
        int numPrograms = Utils.inputNaturalNumber(scanner); 

        Map<Integer, Program> programsMap = new HashMap<>();
        for (int i = 0; i < numPrograms; i++) {
            System.out.println("Enter details for program " + (i + 1) + " (name and capacity): ");
            String programName = scanner.nextLine();
            int capacity = Utils.inputNaturalNumber(scanner); 
            Program program = new Program(programName, capacity);
            programsMap.put(program.getId(), program);
        }

        // Input for students
        System.out.print("Enter the number of students: ");
        int numStudents = Utils.inputNaturalNumber(scanner); 

        Queue<Student> studentQueue = new LinkedList<>();
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter name of student " + (i + 1) + ": ");
            String studentName = scanner.nextLine();

            System.out.println("Enter 5 program preferences (IDs) for " + studentName + ": ");
            int[] preferences = new int[5];
            for (int j = 0; j < 5; j++) {
                preferences[j] = Utils.inputNaturalNumber(scanner); 
            }

            Student student = new Student(studentName, preferences);
            studentQueue.add(student);
        }

        // Process the queue
        Map<String, String> allocationResult = processQueue(studentQueue, programsMap);

        // Output the results
        System.out.println("Allocation Results:");
        for (Map.Entry<String, String> entry : allocationResult.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        scanner.close();
    }

    /**
     * Processes the queue of students and allocates programs based on preferences.
     *
     * @param studentQueue The queue of students to be processed.
     * @param programsMap  The map of program IDs to Program objects.
     * @return A map of student names to their allocated programs.
     */
    public static Map<String, String> processQueue(Queue<Student> studentQueue, Map<Integer, Program> programsMap) {
        Map<String, String> allocationResult = new LinkedHashMap<>();

        // mapping student name to program name for which it has been allocated
        while (!studentQueue.isEmpty()) {
            Student student = studentQueue.poll();
            boolean allocated = false;

            for (int programId : student.getPreferenceProgramIDs()) {
                Program program = programsMap.get(programId);
                if (program != null && program.hasCapacity()) {
                    allocationResult.put(student.getName(), program.getName());
                    program.decrementCapacity();
                    allocated = true;
                    break;
                }
            }

            if (!allocated) {
                allocationResult.put(student.getName(), "Not Allocated");
            }
        }

        return allocationResult;
    }
}