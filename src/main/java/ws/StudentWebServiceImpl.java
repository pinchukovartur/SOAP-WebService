package ws;// таже аннотация, что и при описании интерфейса,
import servis.DAO;

import javax.jws.WebService;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

// но здесь используется с параметром endpointInterface,
// указывающим полное имя класса интерфейса нашего веб-сервиса
@WebService(endpointInterface = "ws.StudentWebService")   //????????
public class StudentWebServiceImpl implements StudentWebService {

    private DAO dao;

    public StudentWebServiceImpl(){
        dao = new DAO();
    }

    @Override
    public String setNewStudentInDB(String name, String surname, int group, int averageScore) {
        dao.setStudent(name,surname,group,averageScore);
        return "Студент успешно добавлен) добро пожаловать в семью!!!";
    }

    @Override
    public String deleteStudent(int idstudent) {
        dao.deleteStudent(idstudent);
        return "Вы удалили студента :( надеюсь не отчислили";
    }

    @Override
    public String searchStudent(int idstudent) {
        return dao.searchStudent(idstudent);
    }
}