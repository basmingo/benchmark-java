package ru.neoflex.benchmarkjavaasync.impl;

import java.security.SecureRandom;
import java.util.Random;
import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDUtils {
    protected static final ThreadLocal<Random> THREAD_LOCAL_RANDOM = ThreadLocal.withInitial(SecureRandom::new);
    public static UUID randomUUID() {
        return Generators.randomBasedGenerator(THREAD_LOCAL_RANDOM.get()).generate();
    }
}
