package ws;// таже аннотация, что и при описании интерфейса,

import model.Student;
import servis.DAO.DAO;

import javax.jws.WebService;
import java.util.ArrayList;

// но здесь используется с параметром endpointInterface,
// указывающим полное имя класса интерфейса нашего веб-сервиса
@WebService(endpointInterface = "ws.StudentWebService")   //????????
public class StudentWebServiceImpl implements StudentWebService {

    private DAO dao;

    public StudentWebServiceImpl(){
        dao = new DAO();
    }

    @Override
    public void setNewStudentInDB(Student student) {
        dao.setStudent(student);
    }

    @Override
    public void deleteStudentById(int idstudent) {
        dao.deleteStudentById(idstudent);
    }

    @Override
    public Student searchStudentById(int idstudent) {
        Student student = new Student();
        if(dao.searchStudentById(idstudent)!=null)
        return dao.searchStudentById(idstudent);
        else return student;
    }

    @Override
    public ArrayList<Student> getAllStudent() {
        return dao.getAllStudent();
    }

    @Override
    public void updateStudentById(Student student) {
        System.out.println(student.getName());
        dao.updateStudentById(student);
    }

    @Override
    public int getDBSize() {
        int sizeDB = dao.getAllStudent().size()-1;
        return dao.getAllStudent().get(sizeDB).getIdStudent()+3;
    }
}