package mt;

/**
 * Created by srawa5 on 3/15/2017.
 */
public enum MyInstance {

    INSTANCE;

    private final PersonService instance;

    MyInstance(){
        this.instance = new PersonService();
    }

    public PersonService getPersonServiceInstance() {
        return instance;
    }
}
