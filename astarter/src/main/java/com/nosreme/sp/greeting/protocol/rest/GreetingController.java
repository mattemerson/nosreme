package com.nosreme.sp.greeting.protocol.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nosreme.svc.greeting.Greeting;
import com.nosreme.svc.greeting.GreetingService;

@RestController
public class GreetingController
{    
    @Autowired
    private GreetingService greetingService;
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name)
    {
        return greetingService.getGreeting(name);
    }
    
    @RequestMapping("/canned-greeting")
    public Greeting cannedGreeting()
    {
        return greetingService.getCannedGreeting();
    }
}
