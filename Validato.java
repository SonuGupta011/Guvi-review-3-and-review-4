public class Validator {
    // Validate email
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    // Validate password (min 8 characters)
    public static boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    // Validate numeric input
    public static boolean isValidNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
