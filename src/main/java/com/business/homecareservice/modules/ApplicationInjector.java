package com.business.homecareservice.modules;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class ApplicationInjector {
    private static final Injector INJECTOR = Guice.createInjector(new AWSModule());

    private ApplicationInjector() {}

    public static Injector getInjector() {
        return INJECTOR;
    }
    
}
