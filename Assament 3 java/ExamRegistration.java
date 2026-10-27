package Assamentcawa;

    import java.util.NoSuchElementException;
import java.util.Scanner;

    class InvalidRegistrationException extends Exception {
        public InvalidRegistrationException(String message) {
            super(message);
        }
    }

    public class ExamRegistration {

        private String studentId;
        private String studentName;
        private int age;
        private double examMark;
        private int numSubjects;

        private int readInt(Scanner sc, String fieldName) throws InvalidRegistrationException {
            String text = sc.nextLine().trim();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                throw new InvalidRegistrationException(fieldName + " must be a whole number.");
            }
        }

        private double readDouble(Scanner sc, String fieldName) throws InvalidRegistrationException {
            String text = sc.nextLine().trim();
            try {
                return Double.parseDouble(text);
            } catch (NumberFormatException e) {
                throw new InvalidRegistrationException(fieldName + " must be a number.");
            }
        }

        public void collectDetails(Scanner sc) throws InvalidRegistrationException {
            System.out.print("Enter Student ID: ");
            studentId = sc.nextLine();

            System.out.print("Enter Student Name: ");
            studentName = sc.nextLine();

            System.out.print("Enter Age: ");
            age = readInt(sc, "Age");

            System.out.print("Enter Exam Mark: ");
            examMark = readDouble(sc, "Exam mark");

            System.out.print("Enter Number of Subjects: ");
            numSubjects = readInt(sc, "Number of subjects");
        }

        public void validate() throws InvalidRegistrationException {
            if (studentId == null || studentId.trim().isEmpty()) {
                throw new InvalidRegistrationException("Student ID cannot be empty.");
            }
            if (studentName == null || studentName.trim().isEmpty()) {
                throw new InvalidRegistrationException("Student name cannot be empty.");
            }
            if (age < 18) {
                throw new InvalidRegistrationException("Student must be at least 18 years old.");
            }
            if (examMark < 0 || examMark > 100) {
                throw new InvalidRegistrationException("Exam mark must be between 0 and 100.");
            }
            if (numSubjects < 1) {
                throw new InvalidRegistrationException("Minimum number of subjects is 1.");
            }
            if (numSubjects > 5) {
                throw new InvalidRegistrationException("Maximum allowed subjects is 5.");
            }
        }

        public void displaySuccess() {
            System.out.println("\nRegistration Successful!");
            System.out.println("Student: " + studentName);
            System.out.println("Registered Subjects: " + numSubjects);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ExamRegistration reg = new ExamRegistration();

            System.out.println("===== EXAM REGISTRATION SYSTEM =====\n");

            try {
                reg.collectDetails(sc);
                reg.validate();
                reg.displaySuccess();

            } catch (InvalidRegistrationException e) {
                System.out.println("\nRegistration Failed!");
                System.out.println("Error: " + e.getMessage());

            } catch (NoSuchElementException e) {
                System.out.println("\nRegistration Failed!");
                System.out.println("Error: Incomplete input.");

            } finally {
                System.out.println("\nRegistration attempt completed.");
                sc.close();
            }
        }
    }

