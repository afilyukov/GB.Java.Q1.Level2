public class Treadmill extends Interference {
    protected int lenght;
    public Treadmill(int lenght) { this.lenght = lenght; }

    @Override
    public void doAction() {
        System.out.println("Running. Booooring");
    }
}
