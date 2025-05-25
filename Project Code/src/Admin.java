
    public class Admin {
        String username;
        String password;

        public Admin(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean isValidAdmin() {
            return password.endsWith("ADMIN123");
        }
    }


