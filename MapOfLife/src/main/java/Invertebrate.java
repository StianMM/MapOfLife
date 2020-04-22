public class Invertebrate extends Animal {
    private int amountOfLegs, amountOfEyes;
    private boolean canFly;

    public Invertebrate(String name, String scientificName, String color, int amountOfLegs, int amountOfEyes, boolean canFly) {
        super(name, scientificName, color);
        this.amountOfLegs = amountOfLegs;
        this.amountOfEyes = amountOfEyes;
        this.canFly = canFly;
    }

    public Invertebrate() {}

    public int getAmountOfLegs() {
        return amountOfLegs;
    }

    public void setAmountOfLegs(int amountOfLegs) {
        this.amountOfLegs = amountOfLegs;
    }

    public int getAmountOfEyes() {
        return amountOfEyes;
    }

    public void setAmountOfEyes(int amountOfEyes) {
        this.amountOfEyes = amountOfEyes;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public String canOrCantFly() {
        if(canFly = true) {
            return "can fly";
        }
        else {
            return "can't fly";
        }
    }

    @Override
    public String toString() {
        return String.format("The %s has %d legs, %d eyes, is %s and %s",
                getScientificName(), amountOfLegs, amountOfEyes, getColor(), canOrCantFly());
    }
}
