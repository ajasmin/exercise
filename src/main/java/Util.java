import java.util.List;
import java.util.regex.Pattern;

public class Util {
    /**
     * Return true if passed a valid email address
     */
    public static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{0,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     * <p>
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     *
     * @returns Distance in Meters
     */
    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    /**
     * Return a string with the characters reversed
     * TODO: I haven't tested this yet
     */
    static String reverseString(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i++) {
            reversed = reversed + str.charAt(i);
        }

        return reversed;
    }

    /**
     * Return true if str is a palindrome
     * i.e. reads the same backward as forward
     * TODO: Implement
     */
    public static boolean isPalindrome(String str) {
        return false;
    }

    public static String snake_case_to_camel_case(String str) {
        while(str.contains("_")) {
            str = str.replaceFirst("_[a-z]", String.valueOf(Character.toUpperCase(str.charAt(str.indexOf("_") + 1))));
        }

        return str;
    }

    /**
     * Return the average of a list of numbers
     */
    public double average(List<Double> numbers) {
        double sum = numbers.stream().reduce(0d, Double::sum);
        return sum / numbers.size();
    }
}
