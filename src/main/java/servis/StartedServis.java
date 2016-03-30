package servis;


// класс, для запуска веб-сервера с веб-сервисами
    import javax.xml.ws.Endpoint;
// класс нашего веб-сервиса
    import ws.StudentWebServiceImpl;

public class StartedServis {
        public static void main(String... args) {
            Endpoint.publish("http://localhost:1996/wss/hello", new StudentWebServiceImpl());
        }
}
