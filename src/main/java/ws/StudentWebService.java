package ws;// это аннотации, т.е. способ отметить наши классы и методы,
// как связанные с веб-сервисной технологией

import model.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

// говорим, что наш интерфейс будет работать как веб-сервис
@WebService
// говорим, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentWebService {
    // говорим, что этот метод можно вызывать удаленно
    @WebMethod
    public void setNewStudentInDB(Student student);

    @WebMethod
    public void deleteStudentById(int idstudent);

    @WebMethod
    public Student searchStudentById(int idstudent);

    @WebMethod
    public ArrayList<Student> getAllStudent();

    @WebMethod
    public void updateStudentById(Student student);

    @WebMethod
    public int getDBSize();
}