package mt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by srawa5 on 1/25/2017.
 */
public class Application {

    private static List<File> fileList = new ArrayList<File>();
    private static String itemName;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();
        List<Callable<List<String>>> list = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        //itemName ="pant";

        String pathname = "D:/mtfolder";

        List<File> files = getFiles(pathname, fileList);

        int batchSize = 5;

        createBatchForTask(list, files, batchSize, itemName);

        ExecutorService executorService = createThreadPool(5);
        List<Future<List<String>>> futures = getresult(list, executorService);

        resultList = processedTaskResult(resultList, futures);


        printResults(resultList);
        long end = System.currentTimeMillis();

        System.out.println("Time taken for mt is : " + (end- start)/1000 );

        shutdown(executorService);




    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
    }

    private static void printResults(List<String> resultList) {
        System.out.println("Smallest price for sneaker is : "+ resultList.stream().max( (x,y) -> {
            if(Integer.parseInt(x) > Integer.parseInt(y)){
                return 1;
            }
            else
                return -1;
        }).get());
    }

    private static List<String> processedTaskResult(List<String> resultList, List<Future<List<String>>> futures) throws InterruptedException, ExecutionException {
        for (Future<List<String>> future : futures) {
            resultList.addAll(future.get());
            System.out.println("Thread completed: ");
        }
        return resultList;
    }

    private static List<Future<List<String>>> getresult(List<Callable<List<String>>> list, ExecutorService executorService) throws InterruptedException {
        return executorService.invokeAll(list);
    }

    private static ExecutorService createThreadPool(int threadCount) {

        return Executors.newFixedThreadPool(threadCount);
    }

    private static void createBatchForTask(List<Callable<List<String>>> list, List<File> files, int diff, String itemName) {
        for (int i = 0; i < files.size(); i+=diff) {
            int fromIndex = i ;
            int toIndex = i+ diff - 1;
            List<File> listofFile = new ArrayList<>();

            if( files.size()>= fromIndex && files.size() > toIndex) {
                listofFile.addAll(files.subList(fromIndex, toIndex));
            }
            else if( files.size()>= fromIndex){
                listofFile.addAll(files.subList(fromIndex, files.size()));
            }
                Task task = new Task(listofFile, itemName);
                list.add(task);

        }
    }


    private static List<File> getFiles(String pathname, List<File> tempFileList) {
        File file = new File(pathname);
        for (File tempFile : file.listFiles()) {
            if (tempFile.isDirectory()) {
                List<File> temp = new ArrayList<>();
                tempFileList.addAll(getFiles(pathname + "\\" + tempFile.getName(), temp));
            } else {

                tempFileList.add(tempFile);
            }


        }
        return tempFileList;
    }

}
