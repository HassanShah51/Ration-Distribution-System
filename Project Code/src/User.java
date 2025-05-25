public class User {
    String name, cnic, phone, city, email, password;
    double income;

    public User(String name, String cnic, String phone, String city, double income, String email, String password) {
        this.name = name;
        this.cnic = cnic;
        this.phone = phone;
        this.city = city;
        this.income = income;
        this.email = email;
        this.password = password;
    }

    public boolean isEligible() {
        return income <= 30000;
    }
}

