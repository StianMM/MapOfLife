public class Location {
    private String name, biome, planet;
    private double longitude, latitude;

    public Location(String name, String biome, String planet, double longitude, double latitude) {
        this.name = name;
        this.biome = biome;
        this.planet = planet;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return String.format("%s on planet %s at the coordinates %.3f, %.3f",
                name, planet, latitude, longitude);
    }
}
