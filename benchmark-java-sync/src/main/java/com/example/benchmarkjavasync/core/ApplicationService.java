package com.example.benchmarkjavasync.core;

import com.example.benchmarkjavasync.core.model.ApplicationServiceRequest;

public interface ApplicationService<T> {

    T process(ApplicationServiceRequest applicationServiceRequest);
}
