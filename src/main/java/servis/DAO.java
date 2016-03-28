package servis;


import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ws.Student;

import java.applet.Applet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static servis.Constants.DELETE;
import static servis.Constants.GET_ALL;
import static servis.Constants.INSERT;

public class DAO extends Applet{

    private final String URL = "jdbc:mysql://localhost:3306/StudentWebServiceDB";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private Connection connection = null;
    private PreparedStatement statement = null;

    public DAO(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setStudent(String name, String surname, int group, int averageScore) {
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, group);
            statement.setInt(4, averageScore);
            statement.execute();
            connection.close();
            statement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void deleteStudent(int idstudent) {

        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, idstudent);
            statement.executeUpdate();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getStudentTable() {

        ArrayList<Student> students = new ArrayList<Student>();
        Student student;

        try {
            statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                int id = resultSet.getInt("idstudent");
                String name = resultSet.getString("name");
                String secondName = resultSet.getString("surname");
                int averageScore = resultSet.getInt("score");
                int group = resultSet.getInt("brigada");
                System.out.println(id+name+secondName+averageScore+group);
                students.add(student.setIdStudent(id).setName(name).setSurname(secondName).
                        setAverageScore(averageScore).setGroup(group));
            }
            statement.execute();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return students;
    }
}
