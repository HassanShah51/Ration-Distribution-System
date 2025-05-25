public class Request {
    String email, city, status, reason;

    public Request(String email, String city) {
        this.email = email;
        this.city = city;
        this.status = "Pending";
        this.reason = "";
    }

    public void approve() {
        this.status = "Approved";
    }

    public void reject(String reason) {
        this.status = "Rejected";
        this.reason = reason;
    }
}

