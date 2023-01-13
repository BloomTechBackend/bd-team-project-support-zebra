package com.oxified.message.service.dependency;

import com.oxified.message.service.activity.CreateMessageActivity;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = { DaoModule.class })
@Singleton
public interface ServiceComponent {
    CreateMessageActivity provideCreateMessageActivity();

}
