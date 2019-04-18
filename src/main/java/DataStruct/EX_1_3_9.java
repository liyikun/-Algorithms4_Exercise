package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;
import java.util.regex.Pattern;

public class EX_1_3_9 {

    public static void main(String[] args){

        java.util.Stack<String> ops = new java.util.Stack<String>();
        java.util.Stack<String> vals = new Stack<String>();

        String pattern = "[\\+\\-\\*\\/]";

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("));
            else if(Pattern.matches(pattern, s)) ops.push(s);
            else if(s.equals(")"))
            {
                String op = ops.pop();
                String v = vals.pop();
                v = String.format("( %s %s %s )",vals.pop(),op,v);
                System.out.println(v);
                vals.push(v);
            } else vals.push(s);
        }
        StdOut.println(vals.pop());

    }

}
