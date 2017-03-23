package mt;

import mt.NitroBooster.NitroBooster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by srawa5 on 3/17/2017.
 */
public class Lamborghini implements NitroBooster {

    @Override
    public void nitroBoost() throws FileNotFoundException {
        System.out.println("My Speed boosted to 210KPH");
/*        File file= new File("D:/suraj.txt");
        FileInputStream fileInputStream = new FileInputStream(file);*/

    }

}
