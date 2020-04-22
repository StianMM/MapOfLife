import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Invertebrate.class, name = "Invertebrate"),
        @JsonSubTypes.Type(value = Amphibian.class, name = "Amphibian"),
        @JsonSubTypes.Type(value = Humanoid.class, name = "Humanoid"),
})

public abstract class Animal {
    private String name, scientificName, color;

    public Animal(String name, String scientificName, String color) {
        this.name = name;
        this.scientificName = scientificName;
        this.color = color;
    }

    public Animal() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("The %s is %s",
                scientificName, color);
    }
}
