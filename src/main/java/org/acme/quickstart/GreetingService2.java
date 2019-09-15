package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@Original
@ApplicationScoped
public class GreetingService2 implements Greeting {

    private static int times = 0;
    private int bug = 0;
    private String name;

    public GreetingService2() {
        System.out.printf("GreetingService2 constructor called %d times.",
                ++times);
        ++bug;
    }

    public String greeting(String name) {
        return "2- hello " + name + " bug: " + bug + "\n";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}