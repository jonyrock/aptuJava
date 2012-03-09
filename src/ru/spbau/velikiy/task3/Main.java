package spbau.velikiy.task3;

import spbau.velikiy.task3.core.ExpressionsTreeParser;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Bad params\nExample: calc -f \"(15.9 + 12.9) * x + 20\"");
            System.exit(1);
        }

        if (args[0].length() == 0) {
            System.out.println("Bad expression");
            System.exit(1);
        }


        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String evalExpr = reader.readLine();

        ExpressionsTreeParser e = new ExpressionsTreeParser(evalExpr);

        System.out.println(e.getValue(10));

    }


}
