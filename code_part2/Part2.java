import java.util.*;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Part2 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        int[] array = new int[600000];
        long start = System.nanoTime();
        for (int i=0; i<600000; i++){
            arrayList.add(random.nextInt(10));
        }
        long end = System.nanoTime();
        System.out.println("Arraylist: "+TimeUnit.NANOSECONDS.toMillis(end-start));
        start = System.nanoTime();
        for (int i=0; i<600000; i++){
            vector.add(random.nextInt(10));
        }
        end = System.nanoTime();
        System.out.println("Vector: "+TimeUnit.NANOSECONDS.toMillis(end-start));
        start = System.nanoTime();
        for (int i=0; i<600000; i++){
            array[i]=(random.nextInt(10));
        }
        end = System.nanoTime();
        System.out.println("Array: "+TimeUnit.NANOSECONDS.toMillis(end-start));

        long sum = 0;
        Iterator<Integer> iterator = arrayList.iterator();
        start = System.nanoTime();
        while(iterator.hasNext()){
            sum+= iterator.next();
        }
        end = System.nanoTime();
        System.out.println("ArrayList Sum: "+TimeUnit.NANOSECONDS.toMillis(end-start));

        sum = 0;
        Iterator<Integer> iterator1 = vector.iterator();
        start = System.nanoTime();
        while(iterator1.hasNext()){
            sum+= iterator1.next();
        }
        end = System.nanoTime();
        System.out.println("Vector Sum: "+TimeUnit.NANOSECONDS.toMillis(end-start));

        sum = 0;
        start = System.nanoTime();
        for (int i=0; i<600000; i++){
            sum+=(array[i]);
        }
        end = System.nanoTime();
        System.out.println("Array Sum: "+TimeUnit.NANOSECONDS.toMillis(end-start));

    }

}
