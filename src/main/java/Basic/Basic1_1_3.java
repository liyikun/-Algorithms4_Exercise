package Basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Basic1_1_3 {

    public static void main(String[] args) {
        int count = 0;
        int inputNumber = 0;
        while (!StdIn.isEmpty()) {
            int curInputNumber = StdIn.readInt();
            if(count == 0) {
                inputNumber = curInputNumber;
            }
            if(count == 3) {
                StdOut.println("equal");
                break;
            }
            if(inputNumber == curInputNumber) {
                count++;
            } else {
                StdOut.println("not equal");
            }
        }
    }
}
