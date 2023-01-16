package com.oxified.useraccount.service.model.result;

import com.oxified.useraccount.service.model.UserAccountModel;

public class CreateUserAccountResult {
    private UserAccountModel userAccount;

    public CreateUserAccountResult(Builder builder) {
        this.userAccount = builder.userAccount;
    }
    public UserAccountModel getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountModel userAccount) {
        this.userAccount = userAccount;
    }

    public static Builder builder() {return new Builder();}

    public final static class Builder {
        private UserAccountModel userAccount;

        public Builder withUserAccount(UserAccountModel userAccount) {
            this.userAccount = userAccount;
            return this;
        }

        public CreateUserAccountResult build() {
            return new CreateUserAccountResult(this);
        }
    }
}
