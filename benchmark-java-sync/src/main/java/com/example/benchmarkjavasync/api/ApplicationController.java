package com.example.benchmarkjavasync.api;

import com.example.benchmarkjavasync.core.model.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {

    private final ServiceAdapter applicationService;

    @PostMapping("users/create")
    public Optional<ApplicationResponse> postUser(@RequestBody ApplicationRequestDto userRequestDto) {
        return applicationService.process(userRequestDto);
    }
}
