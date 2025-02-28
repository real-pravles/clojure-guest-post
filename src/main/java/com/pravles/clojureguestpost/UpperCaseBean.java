package com.pravles.clojureguestpost;

import org.springframework.stereotype.Component;

@Component
public class UpperCaseBean {
    public String upperCase(final String input) {
        if (input == null) {
            return "";
        }
        return input.toUpperCase();
    }
}
