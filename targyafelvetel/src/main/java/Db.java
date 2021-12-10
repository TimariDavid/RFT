import java.sql.*;

public class Db {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public Db(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Db() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return"URL: " + url + "\nUsername: " + username + "\npassword: " + password;
    }

    public void connectDatabase(){
        setUrl("jdbc:mysql://localhost:3306/rft");
        setUsername("rftuser");
        setPassword("9R]Y/Hh3U147VUt5");

        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        System.out.println("Connecting database...");

        try {
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public ResultSet sqlSelect(String sqlcode){

        Statement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlcode);

        } catch (SQLException e){
            throw new RuntimeException("Failed the select.");
        }

        return resultSet;
    }
}
