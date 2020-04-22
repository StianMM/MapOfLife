import java.time.LocalDate;

public class Observation implements Comparable<Observation> {
    private int id, observationAmount;
    private String name, comment, pictureUrl;
    private Animal animal;
    private Location location;
    private LocalDate date;

    public Observation(int id, String name, Animal animal, Location location, LocalDate date, int observationAmount,
                       String pictureUrl, String comment) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.location = location;
        this.date = date;
        this.observationAmount = observationAmount;
        this.pictureUrl = pictureUrl;
        this.comment = comment;
    }

    public Observation() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getObservationAmount() {
        return observationAmount;
    }

    public void setObservationAmount(int observationAmount) {
        this.observationAmount = observationAmount;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public int compareTo(Observation compareObservation) {
        return this.id - compareObservation.id;
    }

    @Override
    public String toString() {
        return String.format("The %s was observed at %s. It was observed %d times. ID-number: %d",
                name, location, observationAmount, id);
    }
}
