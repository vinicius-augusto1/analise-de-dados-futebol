package utils;

public class MenuEstilizado {

    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void printStylizedMessage(String message, String color) {
        int padding = 2;

        int totalWidth = message.length() + padding;

        String border = color + "╔" + "═".repeat(totalWidth) + "╗" + ANSI_RESET;
        String formattedMessage = color + "║ " + message + " ║" + ANSI_RESET;
        String bottomBorder = color + "╚" + "═".repeat(totalWidth) + "╝" + ANSI_RESET;

        System.out.println(border);
        System.out.println(formattedMessage);
        System.out.println(bottomBorder);
    }
}
