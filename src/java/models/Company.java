package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Company {

    protected int id;
    protected String type;
    protected String username;
    protected String email;
    protected String password;
    protected String fullname; // company name
    protected String phone;
    protected String address;
    protected String avatar;
    protected String more;
    protected int lastLogin;
    protected int lastActivity;
    protected String activation;
    public static final ArrayList<String> STUDENT_COLUMN = new ArrayList<>();

    public static ArrayList<Company> getCompanies(String column, String value) {
        // TODO Auto-generated method stub
        return null;
    }

}
