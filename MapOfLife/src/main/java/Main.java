import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

import java.time.LocalDate;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();
        app.config.enableWebjars();


        HashMap<String, Observation> observationHashMap = new HashMap<>();
        HashMap<String, Invertebrate> invertebrateHashMap = new HashMap<>();
        HashMap<String, Amphibian> amphibianHashMap = new HashMap<>();
        HashMap<String, Humanoid> humanoidHashMap = new HashMap<>();
        HashMap<String, Location> locationHashMap = new HashMap<>();

        // Er ikke kreativ nok til å komme på dyrearter på egenhånd,
        // så har tatt det fra virkeligheten og DnD.
        // Kilder ligger i rapporten.

        // Locations
        locationHashMap.put("My house", new Location("My house", "Urban", "Earth",
                59.283,11.082));
        locationHashMap.put("Ice Mountain", new Location("Ice Mountains", "Tundra", "Neptune",
                71.241, 31.093));
        locationHashMap.put("Fitzroy river", new Location("Fitzroy river", "River", "Earth",
                150.883, -23.526));
        locationHashMap.put("Grindstone March", new Location("Grindstone March", "Wetland", "Earth",
                143.871, 5.439));
        locationHashMap.put("Olympus Mons", new Location("Olympus Mons", "Mountain", "Mars",
                129.564, 21.001));


        // Invertebrates
        invertebrateHashMap.put("Drosophila melanogaster", new Invertebrate("Fruit fly",
                "Drosophila melanogaster", "Light yellow",6, 5, true));
        invertebrateHashMap.put("Remorhaz", new Invertebrate("Polar worm", "Remorhaz", "Ice-blue",
                100, 2, false));


        // Amphibians
        amphibianHashMap.put("Rhinella marina", new Amphibian("Cane toad", "Rhinella marina",
                "Yellow-brown",true, true));
        amphibianHashMap.put("Ambystoma maculatum", new Amphibian("Spotted salamander",
                "Ambystoma maculatum", "Black with yellow spots", true, false));


        // Humanoid
        humanoidHashMap.put("Gigantus Cyclopsius", new Humanoid("Cyclops","Gigantus Cyclopsius",
                "Light tan", 1, 2, 268, 29));


        // Observations
        observationHashMap.put("Fruit fly", new Observation(1, "Fruit fly",
                invertebrateHashMap.get("Drosophila melanogaster"), locationHashMap.get("Ice Mountain"),
                LocalDate.of(2337, 1, 12), 2,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/" +
                        "Drosophila_melanogaster_Proboscis.jpg/1280px-Drosophila_melanogaster_Proboscis.jpg",
                "Died shortly after observation."));
        observationHashMap.put("Polar worm", new Observation(2, "Polar worm",
                invertebrateHashMap.get("Remorhaz"), locationHashMap.get("Ice Mountain"),
                LocalDate.of(2337, 3, 5), 1,
                "https://vignette.wikia.nocookie.net/forgottenrealms/images/5/5b/" +
                        "Remorhaz5e.jpg/revision/latest/scale-to-width-down/350?cb=20171010191253",
                "Charged at us and killed one of our team members. Very aggressive creature."));
        observationHashMap.put("Cane toad", new Observation(3, "Cane toad",
                amphibianHashMap.get("Rhinella marina"), locationHashMap.get("Fitzroy river"),
                LocalDate.of(2337, 6, 27), 15,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/" +
                        "Canetoadmale.jpg/330px-Canetoadmale.jpg",
                "One of our team members licked it's back for some reason. " +
                        "After a couple of seconds he started babbling, it seemed like he suddenly got drunk." +
                        "This led to the rest of the team licking the toad and " +
                        "the whole team started seeing all kinds of stuff."));
        observationHashMap.put("Spotted salamander", new Observation(4, "Spotted salamander",
                amphibianHashMap.get("Ambystoma maculatum"), locationHashMap.get("Grindstone March"),
                LocalDate.of(2337, 7, 11), 3,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/" +
                        "SpottedSalamander.jpg/330px-SpottedSalamander.jpg", ""));
        observationHashMap.put("Cyclops", new Observation(5, "Cyclops",
                humanoidHashMap.get("Gigantus Cyclopsius"), locationHashMap.get("Olympus Mons"),
                LocalDate.of(2337, 11, 17), 1,
                "https://i.pinimg.com/236x/57/36/64/" +
                        "573664b57d38de323be42130f25ff978--mythological-creatures-mythical-creatures.jpg",
                "It came out of the cave and ran towards us with open arms. " +
                        "When it got to us, it hugged us all, it was a gentle giant."));


        new ObservationRepository(observationHashMap, invertebrateHashMap, amphibianHashMap, humanoidHashMap,
                locationHashMap, "Observations");

        System.out.println(observationHashMap.get("Fruit fly"));
        System.out.println(observationHashMap.get("Polar worm"));
        System.out.println(observationHashMap.get("Cane toad"));
        System.out.println(observationHashMap.get("Spotted salamander"));
        System.out.println(observationHashMap.get("Cyclops"));
        System.out.println(observationHashMap.get("test"));


        app.get("/observations", new VueComponent("observations-overview"));

        ObservationRepository observationRepository = new ObservationRepository(observationHashMap, invertebrateHashMap,
                amphibianHashMap, humanoidHashMap, locationHashMap, "observations.json");
        ObservationController observationController = new ObservationController(observationRepository);

        app.get("/api/observations", observationController::getAllObservations);
    }
}
