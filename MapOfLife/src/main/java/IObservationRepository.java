import java.time.LocalDate;
import java.util.HashMap;

public interface IObservationRepository {
    void createInvertebrate(String keyName, String name, String scientificName, String color, int amountOfLegs,
                            int amountOfEyes, boolean canFly);
    void createAmphibian(String keyName, String name, String scientificName, String color, boolean poisonous, boolean canJump);
    void createHumanoid(String keyName, String name, String scientificName, String color, int amountOfEyes,
                        int amountOfArms, int height, int iq);
    void createLocation(String keyName, String name, String biome, String planet, double longitude, double latitude);
    void createObservation(String keyName, int id, String name, Animal animal, Location location,
                           LocalDate date, int observationAmount, String pictureUrl, String comment);
    void readObservation(String keyName);
    void updateObservation(String keyName, int id, String name, Animal animal,
                           Location location, LocalDate date, int observationAmount,
                           String pictureUrl, String comment);
    void deleteObservation(String keyName);
    HashMap<String, Observation> getObservationHashMap();
}
