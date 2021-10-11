public class Wall extends Interference {
    protected int height;
    public Wall(int height) {
         this.height = height;
    }



    @Override
    protected void doAction() {
        System.out.println("Aaaaand jump!!");
    }
}
