import java.util.Scanner;

/**
 * Menu-driven console application that provides utility functions.
 * Offers factorial calculation, word counting, and exit options.
 */
public class handson {
    
    /**
     * Calculates the factorial of a non-negative integer.
     *
     * @param n the non-negative integer
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Counts the number of words in a given sentence.
     *
     * @param sentence the input sentence
     * @return the number of words in the sentence
     */
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        return sentence.trim().split("\\s+").length;
    }
    
    /**
     * Main method that runs the menu-driven application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== Menu ===");
            System.out.println("1 Calculate Factorial");
            System.out.println("2 Count Words in a Sentence");
            System.out.println("3 Exit");
            System.out.print("Enter your choice (1-3): ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter a non-negative integer: ");
                        int num = scanner.nextInt();
                        long result = factorial(num);
                        System.out.println("Factorial of " + num + " is: " + result);
                        break;
                    case 2:
                        System.out.print("Enter a sentence: ");
                        String sentence = scanner.nextLine();
                        int wordCount = countWords(sentence);
                        System.out.println("Number of words: " + wordCount);
                        break;
                    case 3:
                        System.out.println("Exiting application. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        scanner.close();
    }
}