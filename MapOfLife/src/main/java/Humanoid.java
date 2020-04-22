public class Humanoid extends Animal{
    private int amountOfEyes, amountOfArms, height, iq;

    public Humanoid(String name, String scientificName, String color, int amountOfEyes, int amountOfArms, int height, int iq) {
        super(name, scientificName, color);
        this.amountOfEyes = amountOfEyes;
        this.amountOfArms = amountOfArms;
        this.height = height;
        this.iq = iq;
    }

    public Humanoid() {};

    public int getAmountOfEyes() {
        return amountOfEyes;
    }

    public void setAmountOfEyes(int amountOfEyes) {
        this.amountOfEyes = amountOfEyes;
    }

    public int getAmountOfArms() {
        return amountOfArms;
    }

    public void setAmountOfArms(int amountOfArms) {
        this.amountOfArms = amountOfArms;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return String.format("The %s has %d eyes, %d arms, is %d cm tall and has an IQ of %d",
                getScientificName(), amountOfEyes, amountOfArms, height, iq);
    }
}
