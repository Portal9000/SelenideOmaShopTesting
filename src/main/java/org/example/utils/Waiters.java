package org.example.utils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Waiters {

    public static void sleep() {
        log.info("Sleep-3000");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void sleep(int millis) {
        log.info("Sleep-" + millis);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}