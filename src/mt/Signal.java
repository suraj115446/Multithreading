package mt;

/**
 * Created by srawa5 on 3/14/2017.
 */
public class Signal {

    private boolean isSignalled = false;

    public boolean isSignalled() {
        return isSignalled;
    }

    public synchronized void setSignalled(boolean signalled) {
        isSignalled = signalled;
    }
}
