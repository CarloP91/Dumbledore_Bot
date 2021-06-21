package db;

public class DbCredentials {
    private String username = "root";
    private String password = "";
    private String db = "test";
    private String url = "jdbc:mysql://localhost:3306/" + db;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDb() {
        return db;
    }

    public String getUrl() {
        return url;
    }


}
