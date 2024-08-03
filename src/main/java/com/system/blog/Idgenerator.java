package com.system.blog;

import org.springframework.util.IdGenerator;
import org.springframework.util.JdkIdGenerator;

import java.util.UUID;

public class Idgenerator {
    public static String getId() {
//        IdGenerator idGenerator = new JdkIdGenerator();
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-","");
    }
}
