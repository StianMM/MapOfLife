import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class ObservationRepository implements IObservationRepository {
    HashMap<String, Observation> observationHashMap;
    HashMap<String, Invertebrate> invertebrateHashMap;
    HashMap<String, Amphibian> amphibianHashMap;
    HashMap<String, Humanoid> humanoidHashMap;
    HashMap<String, Location> locationHashMap;

    public ObservationRepository(HashMap<String, Observation> observationHashMap,
                                 HashMap<String, Invertebrate> invertebrateHashMap,
                                 HashMap<String, Amphibian> amphibianHashMap, HashMap<String, Humanoid> humanoidHashMap,
                                 HashMap<String, Location> locationHashMap, String fileName) {
        this.observationHashMap = observationHashMap;
        this.invertebrateHashMap = invertebrateHashMap;
        this.amphibianHashMap = amphibianHashMap;
        this.humanoidHashMap = humanoidHashMap;
        this.locationHashMap = locationHashMap;

        createInvertebrate("yes","yep", "science", "red", 2, 4, true);
        createLocation("plass", "plass", "skog", "jorda", 123.2, 11.1);
        createObservation("test", 7, "test", invertebrateHashMap.get("ya"), locationHashMap.get("plass"),
                LocalDate.of(2020, 11, 2), 2,
                "https://i.pinimg.com/originals/5b/b4/8b/5bb48b07fa6e3840bb3afa2bc821b882.jpg", "kommentar");
        updateObservation("test", 15, "updatetest", invertebrateHashMap.get("ya"), locationHashMap.get("plass"),
                LocalDate.of(20334, 1, 2), 1,
                "https://i.pinimg.com/originals/5b/b4/8b/5bb48b07fa6e3840bb3afa2bc821b882.jpg", "kommentar");

        writeToJson(fileName, observationHashMap);
        System.out.println(readFromJson(fileName));
    }

    public static void writeToJson(String fileName, HashMap<String, Observation> observationHashMap) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), observationHashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Observation> readFromJson(String fileName) {
        HashMap<String, Observation> hashMapFromFile = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            TypeReference<HashMap<String, Observation>> typeRef = new TypeReference<>() {};
            hashMapFromFile = objectMapper.readValue(new File(fileName), typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMapFromFile;
    }

    @Override
    public void createInvertebrate(String keyName, String name, String scientificName, String color, int amountOfLegs,
                                   int amountOfEyes, boolean canFly) {
         invertebrateHashMap.put(keyName, new Invertebrate(name, scientificName, color, amountOfLegs, amountOfEyes, canFly));
    }

    @Override
    public void createAmphibian(String keyName, String name, String scientificName, String color, boolean poisonous, boolean canJump) {
        amphibianHashMap.put(keyName, new Amphibian(name, scientificName, color, poisonous, canJump));
    }

    @Override
    public void createHumanoid(String keyName, String name, String scientificName, String color, int amountOfEyes,
                               int amountOfArms, int height, int iq) {
        humanoidHashMap.put(keyName, new Humanoid(name, scientificName, color, amountOfEyes, amountOfArms, height, iq));
    }

    @Override
    public void createLocation(String keyName, String name, String biome, String planet, double longitude, double latitude) {
        locationHashMap.put(keyName, new Location(name, biome, planet, longitude, latitude));
    }

    @Override
    public void createObservation(String keyName, int id, String name, Animal animal, Location location, LocalDate date,
                                  int observationAmount, String pictureUrl, String comment) {
        observationHashMap.put(keyName, (new Observation(id, name, animal, location, date, observationAmount,
                pictureUrl, comment)));
    }

    @Override
    public void readObservation(String keyName) {
        observationHashMap.get(keyName);
    }

    @Override
    public void updateObservation(String keyName, int id, String name, Animal animal,
                                              Location location, LocalDate date, int observationAmount,
                                              String pictureUrl, String comment) {
        observationHashMap.replace(keyName, (new Observation(id, name, animal, location, date, observationAmount, pictureUrl,
                comment)));
    }

    @Override
    public void deleteObservation(String keyName) {
        observationHashMap.remove(keyName);
    }

    @Override
    public HashMap<String, Observation> getObservationHashMap() {
        return observationHashMap;
    }
}
