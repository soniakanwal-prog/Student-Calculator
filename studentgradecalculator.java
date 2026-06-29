import java.util.Scanner;

public class studentgradecalculator {
    public static void main(String[] args) {
        // Initialize the Scanner as the system input gatekeeper
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=========================================");
        System.out.println("   DECODELABS RULES ENGINE: GRADE CALC   ");
        System.out.println("=========================================");
        
        // Step 1: Acquisition - Determine the number of subjects
        System.out.print("Enter the total number of subjects: ");
        int totalSubjects = scanner.nextInt();
        
        // Validate input to avoid arithmetic exceptions (e.g., division by zero)
        if (totalSubjects <= 0) {
            System.out.println("Error: Number of subjects must be greater than zero.");
            scanner.close();
            return;
        }
        
        // Step 2: Data Accumulation & Processing
        int totalMarks = 0; // Stores raw integer marks
        
        for (int i = 1; i <= totalSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + i + " (out of 100): ");
                int marks = scanner.nextInt();
                
                // Rules Engine Enforcement: Grade input validation
                if (marks >= 0 && marks <= 100) {
                    totalMarks += marks;
                    break; // Valid input, move to next subject
                } else {
                    System.out.println("Invalid Input! Marks must be strictly between 0 and 100.");
                }
            }
        }
        
        // Step 3: Transformation - Compute average percentage
        double averagePercentage = (double) totalMarks / totalSubjects;
        
        // Step 4: Rule Execution Core - Deterministic Grade Assignment
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        // Step 5: Presentation - Display the Polished Output
        System.out.println("\n=========================================");
        System.out.println("             ACADEMIC REPORT             ");
        System.out.println("=========================================");
        System.out.println("Total Marks Obtained : " + totalMarks + " / " + (totalSubjects * 100));
        System.out.printf("Average Percentage   : %.2f%%\n", averagePercentage);
        System.out.println("Assigned Grade       : " + grade);
        System.out.println("=========================================");
        
        // Gracefully close the scanner resource
        scanner.close();
    }
}
