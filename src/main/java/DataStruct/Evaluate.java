package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;
import java.util.regex.Pattern;

public class Evaluate {
    public static void main(String[] args){

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        String pattern = "[\\+\\-\\*\\/]";

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("));
            else if(Pattern.matches(pattern, s)) ops.push(s);
            else if(s.equals(")"))
            {
                String op = ops.pop();
                Double v = vals.pop();
                if(op.equals("+")) v = vals.pop() + v;
                else if(op.equals("-")) v = vals.pop() - v;
                else if(op.equals("*")) v = vals.pop() * v;
                else if(op.equals("-")) v = vals.pop() / v;
                vals.push(v);
            } else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());

    }
}
