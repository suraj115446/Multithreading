package mt;

import java.util.concurrent.locks.Lock;

/**
 * Created by srawa5 on 3/14/2017.
 */
public class TaskToPractiseLocks implements Runnable{

    private final Lock lock;

    public TaskToPractiseLocks(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

    }
}
