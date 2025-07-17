package com.tcs;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BirthdayController {

	 private final List<String> quotes = List.of(
		        "You are the sunshine that lights up my day ❤️",
		        "With every heartbeat, I love you more 💖",
		        "Forever isn’t long enough with you 💞",
		        "You're my today and all of my tomorrows 💌"
		    );
	 
	 @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	 @GetMapping("/birthday")
	    public String birthday(Model model) {
	        model.addAttribute("message", "Happy Birthday My Love 🎂🎉");
	        model.addAttribute("note", "You're the most beautiful reason I smile every day!");
	        model.addAttribute("quote", getRandomQuote());
	        return "birthday";
	    }

	    private String getRandomQuote() {
	        Random random = new Random();
	        return quotes.get(random.nextInt(quotes.size()));
	    }
}
