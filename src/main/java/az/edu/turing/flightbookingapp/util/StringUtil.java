package az.edu.turing.flightbookingapp.util;

public class StringUtil {

    public static String capitalizeWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return input;
        }
        String[] words = input.split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            capitalized.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return capitalized.toString().trim();
    }

    public static String removeExtraSpaces(String input) {
        return input == null ? null : input.trim().replaceAll("\\s+", " ");
    }

    public static boolean isEmptyOrNull(String input) {
        return input == null || input.trim().isEmpty();
    }
}
