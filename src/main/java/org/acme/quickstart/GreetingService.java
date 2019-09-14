package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService implements Greeting {

    public String greeting(String name) {
        return "hello " + name + "\n";
    }
}