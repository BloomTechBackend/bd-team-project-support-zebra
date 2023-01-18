package main.java.org.service.useraccount.model.request;


import java.util.Objects;

public class CreateUserAccountRequest {
    private String uaId;
    private String email;
    private String password;
    private String userType;
    private String status;
    private String lastName;
    private String firstName;


    public CreateUserAccountRequest(Builder builder) {
        this.uaId = builder.uaId;
        this.email = builder.email;
        this.password = builder.password;
        this.userType = builder.userType;
        this.status = builder.status;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
    }

    public String getUaId() {
        return uaId;
    }

    public void setUaId(String uaId) {
        this.uaId = uaId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static final Builder builder() {return new Builder();}
    public static final class Builder {
        private String uaId;
        private String email;
        private String password;
        private String userType;
        private String status;
        private String lastName;
        private String firstName;

        public Builder withUaId(String uaId) {
            this.uaId = uaId;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder withUserType(String userType) {
            this.userType = userType;
            return this;
        }
        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }
        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CreateUserAccountRequest build(){ return new CreateUserAccountRequest(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserAccountRequest)) return false;
        CreateUserAccountRequest that = (CreateUserAccountRequest) o;
        return Objects.equals(uaId, that.uaId) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(userType, that.userType) && Objects.equals(status, that.status) && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uaId, email, password, userType, status, lastName, firstName);
    }


}
