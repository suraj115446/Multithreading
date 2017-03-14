package mt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by srawa5 on 1/25/2017.
 */
public class Task implements Callable<List<String>> {
    private final List<File> fileList;
    private final List<String> itemPriceList;
    private String itemName;

    public Task(List<File> fileList, String itemName) {
        this.fileList = fileList;
        this.itemName = itemName;
        itemPriceList = new ArrayList<>();
    }

    @Override
    public List<String> call() throws Exception, FileNotFoundException {

        mergeShopResult();
        return itemPriceList;
    }

    public void mergeShopResult() {
        fileList.forEach((file) -> {
            try {
                itemPriceList.add(getPriceOfItem(file, itemName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public String getPriceOfItem(File file, String itemName) throws IOException {


        String price = getItemPrice(file,itemName);

        return price;


    }

    private String getItemPrice(File file, String itemName) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line= "";
        String price ="NotFound";
        String [] lineSplitArray = new String[2];
        while((line =bufferedReader.readLine())!=null){
            lineSplitArray = line.split(",");

            if(lineSplitArray[0].equals(itemName)){
                price = lineSplitArray[1];
               break;
            }

        }
        return price;
    }
}
