package main.java.com.ivk23.java9.overview.process.api;

import java.util.Optional;

public class Main {

    public static void main(String[] args) throws Exception {

        ProcessHandle process = ProcessHandle.current();

        System.out.println("\nPID : " + process.pid());

        System.out.println("\nINFO : " + process.info());


        final int pid = 2676;
        final Optional<ProcessHandle> someProcess = ProcessHandle.of(pid);

        someProcess.ifPresent((proc)-> {
            proc.onExit().whenComplete((p, e) -> {
                System.out.println("\nProcess # " + pid + " has been terminated.");
            });
        });

        Thread.sleep(7000);
        System.out.println("\nMain thread...");

    }

}
