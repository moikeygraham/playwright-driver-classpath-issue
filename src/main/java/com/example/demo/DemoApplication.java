package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        try (final Playwright playwright = Playwright.create();
             final Browser browser = playwright.chromium().launch()) {
            
            final BrowserContext context = browser.newContext();
            final Response response = context.newPage().navigate("https://github.com/microsoft/playwright-java/issues/306");
            
            LOGGER.info("{}", response.status());
        }
    }
}
