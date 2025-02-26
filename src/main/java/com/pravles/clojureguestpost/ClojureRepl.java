package com.pravles.clojureguestpost;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class ClojureRepl {
    @PostConstruct
    public void init() {
        final IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("com.pravles.clojureguestpost"));
        require.invoke(Clojure.read("nrepl.server"));

        final IFn start = Clojure.var("nrepl.server", "start-server");
        int port = 5555;
        start.invoke(Clojure.read(":port"),
                Clojure.read(Integer.toString(port)));
    }

    @PreDestroy
    public void shutDown() {
        Clojure.var("clojure.core.server", "stop-server").invoke(Clojure.read("{:name spring-repl}"));
    }
}
