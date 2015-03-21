package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Student {

    protected int id;
    protected String type;
    protected String username;
    protected String email;
    protected String password;
    protected String fullname;
    protected String gender;
    protected String birthday;
    protected String phone;
    protected String address;
    protected String avatar;
    protected String college; // university or company
    protected String role; // role in the college
    protected String more;
    protected int lastLogin;
    protected int lastActivity;
    protected String activation;
    public static final ArrayList<String> STUDENT_COLUMN = new ArrayList<>();

    static {
        STUDENT_COLUMN.add("id");
        STUDENT_COLUMN.add("type");
        STUDENT_COLUMN.add("username");
        STUDENT_COLUMN.add("email");
        STUDENT_COLUMN.add("password");
        STUDENT_COLUMN.add("fullname");
        STUDENT_COLUMN.add("gender");
        STUDENT_COLUMN.add("birthday");
        STUDENT_COLUMN.add("phone");
        STUDENT_COLUMN.add("address");
        STUDENT_COLUMN.add("avatar");
        STUDENT_COLUMN.add("college");
        STUDENT_COLUMN.add("role");
        STUDENT_COLUMN.add("more");
        STUDENT_COLUMN.add("lastLogin");
        STUDENT_COLUMN.add("lastActivity");
        STUDENT_COLUMN.add("activation");

    }

    public Student() {
        // TODO Auto-generated constructor stub
    }

    public Student(int id, String type, String username, String email,
            String password, String fullname, String gender, String birthday,
            String phone, String address, String avatar, String college,
            String role, String more, int lastLogin, int lastActivity,
            String activation) {
        super();
        this.id = id;
        this.type = type;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.college = college;
        this.role = role;
        this.more = more;
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
    public static ArrayList<Student> getStudents(String columnName, String value) {
        String sql = "SELECT * FROM sw_students WHERE " + columnName + "=?;";
        String sqlToGetAll = "SELECT * FROM sw_students;";

        //if columnName is not a column name, finish and return null
        ArrayList<Student> studentList = new ArrayList<Student>();
        if (!STUDENT_COLUMN.contains(columnName)) {
            if (columnName == "" && value == "") {
                sql = sqlToGetAll;
            } else {
                //Ghi log
                System.out.println("Table has no the column called " + columnName);
                return studentList;
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
                String gender = result.getString("gender");
                String birthday = result.getString("birthday");
                String phone = result.getString("phone");
                String address = result.getString("address");
                String avatar = result.getString("avatar");
                String college = result.getString("college");
                String role = result.getString("role");
                String more = result.getString("more");
                int lastLogin = Integer.parseInt(result.getString("lastLogin"));
                int lastActivity = Integer.parseInt(result.getString("lastActivity"));
                String activation = result.getString("activation");
                studentList.add(new Student(id, type, username, email, password, fullname, gender, birthday, phone,
                        address, avatar, college, role, more, lastLogin, lastActivity, activation));
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
        return studentList;
    }

    public int addToDB() {
        String sql = "INSERT INTO sw_students(type,username,email,password,fullname,gender,birthday,"
                + "phone,address,avatar,college,role,more,lastLogin,lastActivity,activation) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            prepstmt.setString(6, this.gender);
            prepstmt.setString(7, this.birthday);
            prepstmt.setString(8, this.phone);
            prepstmt.setString(9, this.address);
            prepstmt.setString(10, this.avatar);
            prepstmt.setString(11, this.college);
            prepstmt.setString(12, this.role);
            prepstmt.setString(13, this.more);
            prepstmt.setInt(14, this.lastLogin);
            prepstmt.setInt(15, this.lastActivity);
            prepstmt.setString(16, this.activation);

            result = prepstmt.executeUpdate();
            System.out.print("insertThanh cong");
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

    public static int delete(int id) {
        String sql = "DELETE FROM sw_students WHERE id = ?;";
        Connection connection = null;
        PreparedStatement prepstmt = null;
        int result = 0;
        try {
            connection = MyConnection.getConnection();
            prepstmt = connection.prepareStatement(sql);
            prepstmt.setInt(1, id);
            result = prepstmt.executeUpdate();
            System.out.print("Deldete Thanh cong");
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
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
}
