public abstract class Interference implements ActionToDo {
    protected abstract void doAction();

    @Override
    public void doSomething() {
        doAction();
    }
}
