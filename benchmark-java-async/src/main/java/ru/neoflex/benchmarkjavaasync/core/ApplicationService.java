package ru.neoflex.benchmarkjavaasync.core;

import ru.neoflex.benchmarkjavaasync.core.model.ApplicationServiceRequest;

public interface ApplicationService<T> {

    T process(ApplicationServiceRequest applicationServiceRequest);
}
