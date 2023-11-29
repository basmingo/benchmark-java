package com.example.benchmarkjavasync.core;

import com.example.benchmarkjavasync.core.model.CreditInformation;
import com.example.benchmarkjavasync.core.model.Passport;
import com.example.benchmarkjavasync.core.model.User;

public interface ApplicationRepository<R, V> {

    R saveUser(User user);

    V saveCreditInformation(CreditInformation creditInformation);

    V savePassport(Passport passport);
}
