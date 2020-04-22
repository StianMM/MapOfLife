
import io.javalin.http.Context;
import java.util.HashMap;

public class ObservationController {
    private IObservationRepository observationRepository;

    public ObservationController(IObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public void getAllObservations(Context context){
        HashMap<String,Observation> allObservations = new HashMap<>(observationRepository.getObservationHashMap());
        context.json(allObservations);
    }
}