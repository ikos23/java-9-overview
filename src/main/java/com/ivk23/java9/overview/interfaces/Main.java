package main.java.com.ivk23.java9.overview.interfaces;

/**
 * @author Ivan Kos
 */
public class Main {

    public static void main(String[] args) {

        // Test our LoggerInterface
        LoggerInterface.info("Hello World !");

        LoggerInterface.error("Oops :(");

        // Isn't it ?)
        new LoggerInterface() {}.print("This is crazy o_O");
    }

}
