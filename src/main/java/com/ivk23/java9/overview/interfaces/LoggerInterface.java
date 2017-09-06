package main.java.com.ivk23.java9.overview.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Ivan Kos
 */
public interface LoggerInterface {

    // default and static methods were added in Java 8
    default void print() {
        toConsole("Hello World !");
    }

    default void print(final String message) {
        toConsole(message);
    }

    static void info(final String message) {
        log(1, message);
    }

    static void debug(final String message) {
        log(2, message);
    }

    static void error(final String message) {
        log(3, message);
    }

    // private method within an interface
    private void toConsole(final String message) {
        System.out.println("\nDefault method says : " + message);
    }

    private static void log(final int level, final String message) {
        switch (level) {
            case 1 :
                System.out.println("[INFO] " + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " " + message);
                break;
            case 2 :
                System.out.println("[DEBUG] " + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " " + message);
                break;
            case 3 :
                System.err.println("[ERROR] " + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " " + message);
                break;
            default:
                break;

        }
    }
}
