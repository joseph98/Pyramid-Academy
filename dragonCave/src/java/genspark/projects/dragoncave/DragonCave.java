package genspark.projects.dragoncave;

public class DragonCave {
    private static final String GOOD_MSG="You approach the cave...\nIt is dark and spooky...\nA large dragon jumps out in front of you! He opens his jaws and...\nCompliments you on your courage!\nAs a reward, you can take as much treasure back to your village as you can carry.";
    private static final String BAD_MSG="You approach the cave...\nIt is dark and spooky...\nA large dragon jumps out in front of you! He opens his jaws and...\nGobbles you down in one bite!";
    public DragonCave(boolean isGood) {
        this.isGood = isGood;
    }
    @Override
    public String toString()
    {return isGood? GOOD_MSG : BAD_MSG;}

    public boolean isGood() {
        return isGood;
    }

    boolean isGood;

}
