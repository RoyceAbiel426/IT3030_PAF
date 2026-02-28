package com.example.labsheet;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingsController {
    private static final String template = "Hello, %s!";

    private final AtomicLong count = new AtomicLong();

    @GetMapping("/greetings")
    public Greetings greetings() {
        return new Greetings(count.incrementAndGet(), String.format(template, "World"));
    }

    @GetMapping("/greetings/name")
    public Greetings greetings(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greetings(count.incrementAndGet(), String.format(template, name));
    }
    
}
