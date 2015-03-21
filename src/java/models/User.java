package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class User {

    protected int id;
    protected String type;
    protected String username;
    protected String email;
    protected String password;
    protected String fullname;
    protected String phone;
    protected String address;
    protected String avatar;
    protected int lastLogin;
    protected int lastActivity;
    protected String activation;
    public static final ArrayList<String> USER_COLUMN = new ArrayList<>();

    static {
        USER_COLUMN.add("id");
        USER_COLUMN.add("type");
        USER_COLUMN.add("username");
        USER_COLUMN.add("email");
        USER_COLUMN.add("password");
        USER_COLUMN.add("fullname");
        USER_COLUMN.add("phone");
        USER_COLUMN.add("address");
        USER_COLUMN.add("avatar");
        USER_COLUMN.add("lastLogin");
        USER_COLUMN.add("lastActivity");
        USER_COLUMN.add("activation");
    }
    public static final ArrayList<String> TABLES_OF_USER = new ArrayList<>();

    static {
        TABLES_OF_USER.add("sw_users");
        TABLES_OF_USER.add("sw_student_awards");
        TABLES_OF_USER.add("sw_student_basic");
        TABLES_OF_USER.add("sw_student_certifications");
        TABLES_OF_USER.add("sw_student_exp");
        TABLES_OF_USER.add("sw_student_interests");
        TABLES_OF_USER.add("sw_student_languages");
        TABLES_OF_USER.add("sw_student_posts");
        TABLES_OF_USER.add("sw_student_projects");
        TABLES_OF_USER.add("sw_student_skills");
        TABLES_OF_USER.add("sw_student_volunteers");
    }

    public User() {
        super();
    }

    public User(int id, String type, String username, String email,
            String password, String fullname, String phone, String address,
            String avatar, int lastLogin, int lastActivity, String activation) {
        super();
        this.id = id;
        this.type = type;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.lastLogin = lastLogin;
        this.lastActivity = lastActivity;
        this.activation = activation;
    }

    /**
     * Returns an ArrayList of Students that can get from student's table in
     * database
     *
     * @param columnName : name of column in table
     * @param value : value of columnName for searching
     * @return ArrayList of Student, if columnName and value is empty string,
     * return all students
     * @author HongSon
     * @see
     */
    public static ArrayList<User> getUsers(String columnName, String value) {
        String sql = "SELECT * FROM sw_users WHERE " + columnName + "=?;";
        String sqlToGetAll = "SELECT * FROM sw_users;";

        //if columnName is not a column name, finish and return null
        ArrayList<User> userList = new ArrayList<User>();
        if (!USER_COLUMN.contains(columnName)) {
            if (columnName == "" && value == "") {
                sql = sqlToGetAll;
            } else {
                //Ghi log
                System.out.println("Table has no the column called " + columnName);
                return userList;
            }
        }
        Connection connection = null;
        PreparedStatement prepstmt = null;
        try {
            connection = MyConnection.getConnection();
            prepstmt = connection.prepareStatement(sql);
            if (sql != sqlToGetAll) {
                prepstmt.setString(1, value);
            }
            ResultSet result = prepstmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String type = result.getString("type");
                String username = result.getString("username");
                String email = result.getString("email");
                String password = result.getString("password");
                String fullname = result.getString("fullname");
                String phone = result.getString("phone");
                String address = result.getString("address");
                String avatar = result.getString("avatar");;
                int lastLogin = Integer.parseInt(result.getString("lastLogin"));
                int lastActivity = Integer.parseInt(result.getString("lastActivity"));
                String activation = result.getString("activation");
                userList.add(new User(id, type, username, email, password, fullname, phone, address, avatar, lastLogin, lastActivity, activation));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (prepstmt != null) {
                    prepstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return userList;
    }

    public int addToDB() {
        String sql = "INSERT INTO sw_users(type,username,email,password,fullname,"
                + "phone,address,avatar,lastLogin,lastActivity,activation) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement prepstmt = null;
        int result = 0;
        try {
            connection = MyConnection.getConnection();
            prepstmt = connection.prepareStatement(sql);
            prepstmt.setString(1, this.type);
            prepstmt.setString(2, this.username);
            prepstmt.setString(3, this.email);
            prepstmt.setString(4, this.password);
            prepstmt.setString(5, this.fullname);
            prepstmt.setString(6, this.phone);
            prepstmt.setString(7, this.address);
            prepstmt.setString(8, this.avatar);
            prepstmt.setInt(9, this.lastLogin);
            prepstmt.setInt(10, this.lastActivity);
            prepstmt.setString(11, this.activation);

            result = prepstmt.executeUpdate();
            System.out.print("insert Thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (prepstmt != null) {
                    prepstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return result;
    }

    public static int update(User user) {
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(int lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(int lastActivity) {
        this.lastActivity = lastActivity;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public static void main(String[] a) {

    }
}
