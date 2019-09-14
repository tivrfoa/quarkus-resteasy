package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@Original
@ApplicationScoped
public class GreetingService2 implements Greeting {

    public String greeting(String name) {
        return "2- hello " + name + "\n";
    }
}