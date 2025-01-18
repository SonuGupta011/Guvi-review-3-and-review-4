import java.util.ArrayList;
import java.util.Scanner;

public class LMSOperations {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<User> enrolledUsers = new ArrayList<>();
    
    // Register a new user
    public void register(Scanner scanner) {
        System.out.println("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        boolean isAdmin = false; // default user type is regular user

        User newUser = new User(username, password, isAdmin);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    // Login an existing user
    public void login(Scanner scanner) {
        System.out.println("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                userDashboard(scanner);
                return;
            }
        }
        System.out.println("Invalid credentials! Please try again.");
    }

    // User Dashboard (Enrolled courses, etc.)
    public void userDashboard(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n1. View Courses");
            System.out.println("2. Enroll in a Course");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewCourses(); // View available courses
                    break;
                case 2:
                    enrollInCourse(scanner); // Enroll in a course
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    // View available courses
    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                course.displayCourseInfo();
            }
        }
    }

    // Enroll in a course
    public void enrollInCourse(Scanner scanner) {
        System.out.println("\nEnter course code to enroll: ");
        String courseCode = scanner.nextLine();

        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                enrolledUsers.add(course);
                System.out.println("Successfully enrolled in the course: " + course.getCourseName());
                return;
            }
        }
        System.out.println("Course not found!");
    }
}
