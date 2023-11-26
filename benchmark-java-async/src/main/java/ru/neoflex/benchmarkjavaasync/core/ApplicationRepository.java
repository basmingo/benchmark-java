package ru.neoflex.benchmarkjavaasync.core;

import ru.neoflex.benchmarkjavaasync.core.model.CreditInformation;
import ru.neoflex.benchmarkjavaasync.core.model.Passport;
import ru.neoflex.benchmarkjavaasync.core.model.User;

public interface ApplicationRepository<R, V> {

    R saveUser(User user);

    V saveCreditInformation(CreditInformation creditInformation);

    V savePassport(Passport passport);
}
