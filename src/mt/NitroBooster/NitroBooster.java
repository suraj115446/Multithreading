package mt.NitroBooster;

import java.io.FileNotFoundException;

/**
 * Created by srawa5 on 3/17/2017.
 */
public interface NitroBooster {

    int BOOSTPOWER = 10;

    boolean DUALBOOST = true;

    void nitroBoost() throws FileNotFoundException;

    default void defaultBooster() {
        System.out.println("Default Booster is : 2X");
    }
}
