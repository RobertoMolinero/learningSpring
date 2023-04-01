package sec04processingEndpoints.ch24inboundChannelAdapter;

public class PersonRegistrationService {

    public void registerEmail(Person person) {
        System.out.println("E-Mail created for: " + person.toString());
    }
}
