package main.java.com.ivk23.java9.overview.optional;

import lombok.Data;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    @Data
    private static class User {
        private String name;
        private Address address;
    }

    @Data
    private static class Address {
        private String city;
        private int postCode;
    }

    // some service
    private interface UserService {
        default Optional<User> findUserByName(final String name) { return Optional.empty(); }
        default Optional<User> findUserByAddress(final Address address) { return Optional.empty(); }
    }

    public Optional<User> getUser(final String name, final Address address) {
        // chain optionals
        return this.service.findUserByName(name)
                .or(() -> this.service.findUserByAddress(address));
    }


    private UserService service = new UserService() {};

    public static void main(String[] args) {

        // ======== or ============
        final Optional<User> user = new Main().getUser("Test", new Address());

        // Java 8 style
        if (user.isPresent()) {
            System.out.println(user);
        } else {
            // no user action
        }

        // Java 9 style
        user.ifPresentOrElse(System.out::println, () -> {
            System.out.println("No user data :(");
        });

        System.out.println("");

        // ======== optional as stream ========
        System.out.println(Optional.of("ABC").map(item -> item.toLowerCase()));
        // vs.
        System.out.println(Optional.of("ABC").stream().map((item) -> { return item.toLowerCase(); }));

    }

}
