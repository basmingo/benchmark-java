package ru.neoflex.benchmarkjavaasync.core;

import ru.neoflex.benchmarkjavaasync.core.model.*;

public interface ApplicationService<T> {

    T process(ApplicationRequest applicationRequest);
}
