package main.java.org.service;

import main.java.org.service.dependency.ServiceComponent;
import main.java.org.service.useraccount.activity.CreateUserAccountActivity;

public class main {
    public static void main(String[] args) {
        ServiceComponent dagger = null;
        CreateUserAccountActivity cua = dagger.provideCreateUserAccountActivity();
    }
}
