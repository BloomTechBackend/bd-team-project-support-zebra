package main.java.org.service.message.dependency;

import com.oxified.message.service.activity.CreateMessageActivity;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = { DaoModule.class })
@Singleton
public interface ServiceComponent {
    CreateMessageActivity provideCreateMessageActivity();

}
