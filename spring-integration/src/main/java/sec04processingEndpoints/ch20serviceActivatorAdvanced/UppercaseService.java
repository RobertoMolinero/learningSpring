package sec04processingEndpoints.ch20serviceActivatorAdvanced;

import java.util.Locale;

public class UppercaseService {

    public String execute(Person p) {
        return (p.getFirstName() + " " + p.getLastName()).toUpperCase(Locale.ROOT);
    }
}
