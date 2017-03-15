package mt;

/**
 * Created by srawa5 on 3/14/2017.
 */
public class TaskToStudySignal implements Runnable {

    private Signal signal;
    private int counter = 0;

    public TaskToStudySignal(Signal signal) {
        this.signal = signal;
    }


    @Override
    public void run() {

            if (!signal.isSignalled()) {
                incrementCounter();
                signal.setSignalled(true);
            } else {
                printCounter();
                signal.setSignalled(false);

            }





    }

    private void incrementCounter() {
        System.out.println(Thread.currentThread().getName()+" : "+ counter);
        counter++;
    }

    private void printCounter() {
        System.out.println(Thread.currentThread().getName()+" : "+ counter);
        //counter+=2;
    }
}
