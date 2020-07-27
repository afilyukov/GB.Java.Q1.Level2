public class Human implements Challenger {
    private final String name;
    private final int maxRun;
    private final int maxJump;
    private final ThingType type;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.type = ThingType.HUMAN;
    }
    @Override
    public boolean doSomething(ActionToDo action) {
        if (action instanceof Wall){   //не могу придумать , как сделать более коротко и красиво
            System.out.println(String.format("%s[%s] is tried to jump", name, type));
            if (((Wall) action).height > this.maxJump) {
                System.out.println("Failed. Too highNext one");
                return false;
            } else {
                action.doSomething();
                return true;
            }
        }
        if (action instanceof Treadmill){   //не могу придумать , как сделать более коротко и красиво
            System.out.println(String.format("%s[%s] is tried to run", name, type));
            if (((Treadmill) action).lenght > this.maxRun) {
                System.out.println("Failed. Too longNext one");
                return false;
            } else {
                action.doSomething();
                return true;
            }
        }
        return false;
    }
}
