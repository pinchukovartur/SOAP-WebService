package servis;

/**
 * Created by pinch on 25.3.16.
 */
public class Constants {

    static final String INSERT= "INSERT INTO student(name, surname, score, brigada) VALUES (?,?,?,?)";

    static final String DELETE = "DELETE FROM student WHERE idstudent=?";

    static final String GET_ALL = "SELECT * FROM student";
}
