package main.java.com.ivk23.java9.overview.stack.walker;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

public class Main {

    public static void main(String[] args) {

        // Prior to Java 9
        //Thread.currentThread().getStackTrace();
        new Main().test();
    }

    public void test() {
        new ExampleClass1().test1();
    }

    private class ExampleClass1 {
        public void test1() {
            new ExampleClass2().test2();
        }
    }

    private class ExampleClass2 {
        public void test2() {
            new ExampleClass3().test3();
        }
    }

    private class ExampleClass3 {
        public void test3() {
            final List<StackFrame> stack = StackWalker.getInstance(RETAIN_CLASS_REFERENCE)
                    .walk((st) -> st.collect(Collectors.toList()));

            System.out.println("All frames :");
            stack.forEach(System.out::println);


            System.out.println("\nFrames for some class :");
            final List<Class> classes = List.of(ExampleClass2.class);
            final Optional<StackFrame> interestingClasses = StackWalker.getInstance(RETAIN_CLASS_REFERENCE)
                    .walk(st -> st.filter(el -> classes.contains(el.getDeclaringClass())).findFirst());
            System.out.println(interestingClasses.get().toString());


            System.out.println("\nLimit :");
            final List<StackFrame> limited = StackWalker.getInstance(RETAIN_CLASS_REFERENCE)
                    .walk(s -> s.limit(3).collect(Collectors.toList()));
            limited.forEach(System.out::println);

        }
    }

}
