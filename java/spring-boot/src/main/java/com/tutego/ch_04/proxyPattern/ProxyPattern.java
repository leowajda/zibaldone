package com.tutego.ch_04.proxyPattern;

public class ProxyPattern {

    private static class Subject {
        public String operation(String input) {
            return input;
        }
    }

    private static class Proxy extends Subject {
        private final Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public String operation(String input) {
            // Preprocess the input
            // ....

            var result = subject.operation(input);

            // Postprocess the result
            // ...

            return result;
        }
    }

}
