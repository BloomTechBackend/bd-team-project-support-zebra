package com.oxified.message.service.dependency;

import dagger.Component;

import javax.inject.Singleton;

@Component(modules = { DaoModule.class })
@Singleton
public interface ServiceComponent {

}
