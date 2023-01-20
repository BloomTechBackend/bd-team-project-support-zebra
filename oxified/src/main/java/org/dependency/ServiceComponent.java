package main.java.org.dependency;

import dagger.Component;
import main.java.org.service.useraccount.activity.CreateUserAccountActivity;
import main.java.org.service.useraccount.activity.GetUserAccountActivity;
import main.java.org.service.useraccount.activity.UpdateUserAccountActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateUserAccountActivity provideCreateUserAccountActivity();
    GetUserAccountActivity provideGetUserAccountActivity();
    UpdateUserAccountActivity provideUpdateUserAccountActivity();
}
