package main.java.com.ivk23.java9.overview.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {

        // delay
        CompletableFuture<String> future = new CompletableFuture<>();
        future.completeAsync(() -> "Hello World",
                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS))
                    .whenComplete((value, error) -> {
                        if (error == null) {
                            System.out.println(value);
                        } else {
                            System.out.println("Error !");
                        }
                    });

        Thread.sleep(2000);
        System.out.println("Main method !");

    }

}
