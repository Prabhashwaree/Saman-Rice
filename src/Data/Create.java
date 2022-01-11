package Data;

public class Create {
    private String first;
    private String last;
    private String email;
    private String password;
    private String confirm;

    public Create() {
    }

    public Create(String first, String last, String email, String password, String confirm) {
        this.setFirst(first);
        this.setLast(last);
        this.setEmail(email);
        this.setPassword(password);
        this.setConfirm(confirm);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
