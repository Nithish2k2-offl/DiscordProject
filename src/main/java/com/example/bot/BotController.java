package com.example.bot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class BotController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/search")
    public List<String> search(@RequestParam String query) {
        // Perform the search based on the query and return results
        List<String> results = new ArrayList<>();
        results.add("Result 1 for " + query);
        results.add("Result 2 for " + query);
        return results;
    }
}