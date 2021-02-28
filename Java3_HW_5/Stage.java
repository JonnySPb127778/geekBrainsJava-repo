import java.util.concurrent.Semaphore;

public abstract class Stage {
    protected int length;
    protected int capacity;
    protected Semaphore smp;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}