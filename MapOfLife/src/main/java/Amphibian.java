public class Amphibian extends Animal{
    private boolean poisonous;
    private boolean canJump;

    public Amphibian(String name, String scientificName, String color, boolean poisonous, boolean canJump) {
        super(name, scientificName, color);
        this.poisonous = poisonous;
        this.canJump = canJump;
    }

    public Amphibian() {}

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }

    public boolean isCanJump() {
        return canJump;
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public String isOrIsntPoisonous() {
        if(poisonous = true) {
            return "not poisonous";
        }
        else {
            return "poisonous";
        }
    }

    public String canOrCantJump() {
        if(canJump = true) {
            return "can jump";
        }
        else {
            return "can't jump";
        }
    }

    @Override
    public String toString() {
        return String.format("The %s is %s, %s and %s",
                getScientificName(), getColor(), isOrIsntPoisonous(), canOrCantJump());
    }
}
