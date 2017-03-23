package mt;

import mt.NitroBooster.Employee;
import mt.NitroBooster.NitroBooster;
import mt.NitroBooster.Rectangle;
import mt.NitroBooster.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by srawa5 on 1/25/2017.
 */
public class Application {

    private static List<File> fileList = new ArrayList<File>();
    private static String itemName;

    public static void main(String[] args) throws InterruptedException, ExecutionException, FileNotFoundException {


/*      ***************************************  FileReadingMultithreading  ********************************************
        testingFileReadingViaExecutor();
*/

/*      ***************************************  NavigableMap  *********************************************************
        navigableMapMethodsPractise();
*/

/*      ***************************************  ScheduledExecutorService  *********************************************
        schedluedExecutorServicePractise();
*/

/*      **********************************  Study Signal w/o wait notify ***********************************************
        signallingWOwaitNotify();

*/

        //Lock lock = new ReentrantLock();

/*      *********************************  Collections Practice  ********************************************************
        collectionPractice();
*/

        System.out.println("Tree Set");
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("asd");
        treeSet.add("qee");
        treeSet.add("azxcccccccccccc");
        treeSet.forEach(z -> System.out.println(z));

        System.out.println("Hash Set");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("asd");
        hashSet.add("qee");
        hashSet.add("azxcccccccccccc");
        hashSet.forEach(z -> System.out.println(z));

        System.out.println("Linked Hash Set");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("asd");
        linkedHashSet.add("qee");
        linkedHashSet.add("azxcccccccccccc");
        linkedHashSet.forEach(z -> System.out.println(z));


        enumAndEnumSetPractice();

        PersonService ps1 = MyInstance.INSTANCE.getPersonServiceInstance();
        PersonService ps2 = MyInstance.INSTANCE.getPersonServiceInstance();

        PersonService ps3 = new PersonService();

        if (ps1.equals(ps2)) {
            System.out.println("Equal");
        } else if (!ps1.equals(ps3)) {
            System.out.println("Not Equal");
        }

        Date date = new Date();
        NitroBooster lamborghini = new Lamborghini();
        lamborghini.defaultBooster();

        lamborghini.nitroBoost();
        System.out.println("NitroBoost : "+NitroBooster.BOOSTPOWER);

        Shape shape = new Rectangle();
        Employee employee1 = new Employee(1,"Suraj","AL1");
        Employee employee2 = new Employee(2,"Shivanshu","AL2");


        List<Employee> list = new LinkedList<>();
        list.add(employee1);
        list.add(employee2);

        //Collections.sort(list);
        list.forEach(x-> System.out.println(x.getEmpName()));
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getEmpName().compareTo(o2.getEmpName());
            }

            @Override
            public Comparator<Employee> reversed() {
                return this.reversed();
            }
        });

        list.forEach(x-> System.out.println(x.getEmpName()));
    }

    private static void enumAndEnumSetPractice() {
        System.out.println(Colors.RED);
        /*System.out.println(Colors.RED);

        Set<Colors> enumSet= EnumSet.allOf(Colors.class);

        System.out.println(Colors.VIOLET.ordinal());
        System.out.println(Colors.VIOLET.name());

        for(Colors colors : enumSet){
            System.out.println(colors.name()+" (Details- " +"Red: "+colors.getR()+" green: "+colors.getG()+" blue: "+ colors.getB()+")");
        }

        for (int val : Colors.RED.mixColors(Colors.BLUE,Colors.GREEN)){
            System.out.println("Red: "+" Green: "+ " Blue: ");
            System.out.println(val);
        }*/
    }

    private static void collectionPractice() {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("suraj");
        list.add("sandeep");

        //System.out.println(list.remove("sandeep"));
        //list.forEach(x -> System.out.println(x));

        //list.addAll(list.size(), list);
        //list.forEach(x -> System.out.println(x));
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }

        System.out.println(list.size());

        list.forEach(x -> System.out.println(x));
    }

    private static void signallingWOwaitNotify() {
        Signal signal = new Signal();
        Runnable taskToStudySignal1 = new TaskToStudySignal(signal);

        Thread thread1 = new Thread(taskToStudySignal1);
        Thread thread2 = new Thread(taskToStudySignal1);
        Thread thread3 = new Thread(taskToStudySignal1);
        Thread thread4 = new Thread(taskToStudySignal1);
        Thread thread5 = new Thread(taskToStudySignal1);
        Thread thread6 = new Thread(taskToStudySignal1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }

    private static void schedluedExecutorServicePractise() {
        System.out.println("start");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

//    ****************************  schedule  *************************************************************************
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executed!");

            }
        }, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule with Fixed Rate");
                System.out.println("Executed!");

            }
        }, 2, 2, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule with Fixed Delay");
                System.out.println("Executed!");

            }
        }, 2, 5, TimeUnit.SECONDS);
    }

    private static void navigableMapMethodsPractise() {
        NavigableMap<String, String> navigableMap = new TreeMap<>();
        navigableMap.put("1", "suraj");
        navigableMap.put("2", "surajs");
        navigableMap.put("3", "surajsr");
        navigableMap.put("4", "surajsra");
        navigableMap.put("5", "surajsrs");
        navigableMap.put("6", "surajsrss");

        System.out.println("DescendingKeySet Map");
        NavigableSet<String> descendingKeySet = navigableMap.descendingKeySet();
        descendingKeySet.forEach((x) -> {
            System.out.println("keys : " + x);
        });

        System.out.println("Descending Map");
        SortedMap<String, String> descendingMap = navigableMap.descendingMap();
        descendingMap.forEach((x, y) -> {
            System.out.println(x + " : " + y);
        });


        System.out.println("Head Map");
        SortedMap<String, String> headMap = navigableMap.headMap("5", true);
        headMap.forEach((x, y) -> {
            System.out.println(x + " : " + y);
        });

        System.out.println("Tail Map");
        SortedMap<String, String> tailMap = navigableMap.tailMap("5", true);
        tailMap.forEach((x, y) -> {
            System.out.println(x + " : " + y);
        });

        System.out.println("Sub Map");
        SortedMap<String, String> subMap = navigableMap.subMap("2", true, "5", true);
        subMap.forEach((x, y) -> {
            System.out.println(x + " : " + y);
        });

        Map.Entry<String, String> ceilingEntry = navigableMap.ceilingEntry("2");
        Map.Entry<String, String> floorEntry = navigableMap.floorEntry("2");
        Map.Entry<String, String> higherEntry = navigableMap.higherEntry("2");
        Map.Entry<String, String> lowerEntry = navigableMap.lowerEntry("2");

        System.out.println("ceiling, floor, higherEntry, lowerEntry");
        System.out.println(ceilingEntry.getKey() + " : " + ceilingEntry.getValue());
        System.out.println(floorEntry.getKey() + " : " + floorEntry.getValue());
        System.out.println(higherEntry.getKey() + " : " + higherEntry.getValue());
        System.out.println(lowerEntry.getKey() + " : " + lowerEntry.getValue());

        System.out.println("Poll first Entry");
        Map.Entry<String, String> pollFirstEntry = navigableMap.pollFirstEntry();
        System.out.println("first entry : " + pollFirstEntry.getValue());

        System.out.println("Poll Last Entry");
        Map.Entry<String, String> pollLastEntry = navigableMap.pollLastEntry();
        System.out.println("Last entry : " + pollLastEntry.getValue());
    }

    private static void testingFileReadingViaExecutor() throws InterruptedException, ExecutionException {
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

        System.out.println("Time taken for mt is : " + (end - start) / 1000);

        shutdown(executorService);
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
    }

    private static void printResults(List<String> resultList) {
        System.out.println("Smallest price for sneaker is : " + resultList.stream().max((x, y) -> {
            if (Integer.parseInt(x) > Integer.parseInt(y)) {
                return 1;
            } else
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
        for (int i = 0; i < files.size(); i += diff) {
            int fromIndex = i;
            int toIndex = i + diff - 1;
            List<File> listofFile = new ArrayList<>();

            if (files.size() >= fromIndex && files.size() > toIndex) {
                listofFile.addAll(files.subList(fromIndex, toIndex));
            } else if (files.size() >= fromIndex) {
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
