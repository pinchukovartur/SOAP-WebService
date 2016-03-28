package ws;// это аннотации, т.е. способ отметить наши классы и методы,
// как связанные с веб-сервисной технологией
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

// говорим, что наш интерфейс будет работать как веб-сервис
@WebService
// говорим, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentWebService {
    // говорим, что этот метод можно вызывать удаленно
    @WebMethod
    public String setNewStudentInDB(String name, String surname, int group, int averageScore);

    @WebMethod
    public String deleteStudent(int idstudent);

    @WebMethod
    public List<Student> getStudentTable();
}