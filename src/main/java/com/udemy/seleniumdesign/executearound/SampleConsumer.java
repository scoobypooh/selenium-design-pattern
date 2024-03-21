package com.udemy.seleniumdesign.executearound;

import java.util.function.Consumer;

public class SampleConsumer {

    public static void main(String[] args){

        test((d) ->System.out.println(d));
        test((d) -> System.out.println("Hello " + d));

    }
    private static void test(Consumer<String> consumer){
        String s = "udemy";
        consumer.accept(s);
    }
}
