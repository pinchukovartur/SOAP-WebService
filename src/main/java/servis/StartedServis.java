package servis;


import javax.xml.ws.Endpoint;
// класс нашего веб-сервиса
import servis.DAO.DAO;
import ws.StudentWebServiceImpl;

public class StartedServis {
    public static void main(String... args) {
        Endpoint.publish("http://localhost:1234/wss/hello", new StudentWebServiceImpl());
    }
}
