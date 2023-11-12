package Registration;


public abstract class Registration {
    private String username;
    private String password;
    private String email;
    private String phone;
//    private Validator validator;
//    private Verifier verifier;
    public abstract void completeRegistration();

    public void setEmail(String email) {
        this.email = email;
    }
    public void register(){

    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
}
