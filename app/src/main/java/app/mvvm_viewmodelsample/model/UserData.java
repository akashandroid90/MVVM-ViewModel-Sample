package app.mvvm_viewmodelsample.model;

public class UserData {
    public int id;
    public String first_name, last_name, email, gender;

    public String getName() {
        return first_name + " " + last_name;
    }
}
