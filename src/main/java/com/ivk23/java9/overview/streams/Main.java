package main.java.com.ivk23.java9.overview.streams;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        // dropWhile
        System.out.println("dropWhile | " + Stream.of(1,2,3,4,5,6,7,5,8).collect(toList()));
        Stream.of(1,2,3,4,5,6,7,5,8)
                .dropWhile((item) -> { return item < 7;})
                .forEach(Main::print);

        System.out.printf("\n\n");

        // takeWhile
        System.out.println("takeWhile | " + Stream.of(1,2,3,4,5,6,7,5,8).collect(toList()));
        Stream.of(1,2,3,4,5,6,7,5,8)
                .takeWhile((item) -> { return item < 7; })
                .forEach(Main::print);

        System.out.printf("\n\n");

        // Java 9 iterate()
        // Question : i++ ?)
        System.out.println("iterate");
        IntStream.iterate(0, i -> i < 5, i -> /*i++*/++i).forEach(Main::print);

    }

    private static void print(Object value) {
        System.out.print(value + " ");
    }

}
