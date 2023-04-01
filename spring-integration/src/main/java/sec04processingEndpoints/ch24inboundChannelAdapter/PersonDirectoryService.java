package sec04processingEndpoints.ch24inboundChannelAdapter;

public class PersonDirectoryService {

    public Person findNewPeople() {
        return new Person("Alan", "Turing");
    }
}
