package Basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Basic1_1_21 {

    private static void readInput() {
        ArrayList<Person> persons = new ArrayList<Person>();
        StdOut.println("input name");
        while (!StdIn.isEmpty()) {
            try {
                String name = StdIn.readString();
                StdOut.println("name: "+name);

                StdOut.println("input hitCount");
                int hitCount = StdIn.readInt();
                StdOut.println("hitCount: "+hitCount);

                StdOut.println("input allCount");
                int allCount = StdIn.readInt();
                if(allCount < hitCount) {
                    throw new Exception("击球总数不能小于击中数");
                }
                StdOut.println("allCount: "+allCount);

                float hitRate = (float)hitCount/allCount;

                Person p = new Person(name,hitCount,allCount,hitRate);
                persons.add(p);
                StdOut.println("input name");

            } catch (Exception e){
                StdOut.println(e.getMessage());
            }
        }

        persons.forEach(p -> StdOut.printf("name: %s,hitCount: %d, allCount: %d,hitRate: %.2f", p.name, p.hitCount, p.allCount, p.hitRate));
    }

    public static void main(String[] args) {
        readInput();
    }

}


class Person {
    String name;
    int hitCount;
    int allCount;
    float hitRate;
    public Person(String name, int hitCount, int allCount, float hitRate) {
        this.name = name;
        this.hitCount = hitCount;
        this.allCount = allCount;
        this.hitRate = hitRate;
    }
}