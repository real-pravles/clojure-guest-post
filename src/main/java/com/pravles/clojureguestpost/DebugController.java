package com.pravles.clojureguestpost;

import clojure.java.api.Clojure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("newDebugController")
@RequestMapping("debug")
public class DebugController {
    @Autowired
    private ApplicationContext ctx;

    @GetMapping("run")
    public Object run() {
        return Clojure.var("com.pravles.clojureguestpost", "debug").invoke(ctx);
    }

}
