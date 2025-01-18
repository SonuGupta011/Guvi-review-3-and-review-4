import java.util.*;

class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Course {
    String courseName;
    String courseCode;
    String instructor;

    public Course(String courseName, String courseCode, String instructor) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return courseName + " (" + courseCode + ") - Instructor: " + instructor;
    }
}

class Student extends User {
    List<Course> enrolledCourses = new ArrayList<>();

    public Student(String username, String password) {
        super(username, password);
    }

    public void enroll(Course course) {
        enrolledCourses.add(course);
    }

    public void viewEnrolledCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
        } else {
            System.out.println("Enrolled Courses:");
            for (Course course : enrolledCourses) {
                System.out.println(course);
            }
        }
    }
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void addCourse(List<Course> courses, String name, String code, String instructor) {
        courses.add(new Course(name, code, instructor));
        System.out.println("Course added successfully!");
    }

    public void gradeStudent(Student student, Course course, int grade) {
        System.out.println("Grading student " + student.username + " in " + course.courseName + ": " + grade);
    }
}

public class LearningManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Course> courses = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static Admin admin;
    private static Student loggedInStudent;

    public static void main(String[] args) {
        admin = new Admin("admin", "admin123");
        users.add(admin);

        // Add some sample courses
        admin.addCourse(courses, "Java Programming", "CS101", "Dr. Smith");
        admin.addCourse(courses, "Data Structures", "CS102", "Dr. Brown");

        while (true) {
            System.out.println("Welcome to the Learning Management System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                login();
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = authenticate(username, password);

        if (user != null) {
            if (user instanceof Admin) {
                adminPanel();
            } else if (user instanceof Student) {
                studentPanel((Student) user);
            }
        } else {
            System.out.println("Invalid credentials, try again.");
        }
    }

    private static User authenticate(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                if (user instanceof Student) {
                    return (Student) user;
                } else {
                    return user;
                }
            }
        }
        return null;
    }

    private static void adminPanel() {
        while (true) {
            System.out.println("\nAdmin Panel");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                addCourse();
            } else if (choice == 2) {
                viewCourses();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void addCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine();

        admin.addCourse(courses, courseName, courseCode, instructor);
    }

    private static void viewCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void studentPanel(Student student) {
        loggedInStudent = student;

        while (true) {
            System.out.println("\nStudent Panel");
            System.out.println("1. Enroll in a course");
            System.out.println("2. View enrolled courses");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                enrollInCourse();
            } else if (choice == 2) {
                student.viewEnrolledCourses();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void enrollInCourse() {
        System.out.println("Available Courses to Enroll:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }

        System.out.print("Enter course number to enroll: ");
        int courseNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if (courseNumber >= 0 && courseNumber < courses.size()) {
            loggedInStudent.enroll(courses.get(courseNumber));
            System.out.println("Enrolled in course: " + courses.get(courseNumber).courseName);
        } else {
            System.out.println("Invalid course number.");
        }
    }
}
