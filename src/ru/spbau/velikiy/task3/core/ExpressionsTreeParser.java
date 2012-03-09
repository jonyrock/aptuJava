package spbau.velikiy.task3.core;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExpressionsTreeParser {

    private final char[] expressionString;
    private ExpressionMark[] expressionMarks;
    private Tree rootTree;
    Pattern applicationPattern = Pattern.compile("([a-zA-Z]+)\\(");
    


    public ExpressionsTreeParser(String expression) {

        String s = preprocessor(expression);
        expressionString = s.toCharArray();

        fillMarkers();
        rootTree = buildTree(0, expressionString.length);

    }

    private String preprocessor(String s) {

        s = s.replace(" ", "");

        StringBuffer stringBuffer = new StringBuffer();

        Matcher matcher = applicationPattern.matcher(s);
        
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(1) + "@(");
        }

        matcher.appendTail(stringBuffer);
        
        return stringBuffer.toString();

    }

    /**
     * Evaluate expression
     *
     * @param xValue value of function param
     * @return evaluated value
     */
    public int getValue(int xValue) {

        return rootTree.value(xValue);

    }

    private Tree buildFromOneRangByTrees(ArrayList<Tree> trees, ArrayList<Character> ops) {

        if (ops.isEmpty()) {
            return trees.get(0);
        }

        for (int i = 0; i != ops.size(); i++) {
            if (ops.get(i) == '/') {
                Tree tr = new OperationDivision();
                tr.left = trees.get(i);
                tr.right = trees.get(i + 1);
                trees.set(i, tr);
                trees.remove(i + 1);
                ops.remove(i);
                return buildFromOneRangByTrees(trees, ops);
            }
        }

        for (int i = 0; i != ops.size(); i++) {
            if (ops.get(i) == '*') {
                Tree tr = new OperationMultiplication();
                tr.left = trees.get(i);
                tr.right = trees.get(i + 1);
                trees.set(i, tr);
                trees.remove(i + 1);
                ops.remove(i);
                return buildFromOneRangByTrees(trees, ops);
            }
        }

        for (int i = 0; i != ops.size(); i++) {
            if (ops.get(i) == '-') {
                Tree tr = new OperationMinus();
                tr.left = trees.get(i);
                tr.right = trees.get(i + 1);
                trees.set(i, tr);
                trees.remove(i + 1);
                ops.remove(i);
                return buildFromOneRangByTrees(trees, ops);
            }
        }

        for (int i = 0; i != ops.size(); i++) {
            if (ops.get(i) == '+') {
                Tree tr = new OperationPlus();
                tr.left = trees.get(i);
                tr.right = trees.get(i + 1);
                trees.set(i, tr);
                trees.remove(i + 1);
                ops.remove(i);
                return buildFromOneRangByTrees(trees, ops);
            }
        }

        return null;

    }

    private Tree buildFromOneRang(int p, int q, OperationIndex[] ops) {

        if (ops.length == 1) {
            Tree t = rootTree.operationsFabric(expressionString[ops[0].i]);
            t.left = buildTree(p, ops[0].i);
            t.right = buildTree(ops[0].i + 1, q);
            return t;
        }

        ArrayList<Tree> trees = new ArrayList<Tree>(ops.length + 1);
        ArrayList<Character> opChs = new ArrayList<Character>(ops.length);

        opChs.add(ops[0].c);
        trees.add(buildTree(p, ops[0].i));

        for (int i = 1; i != ops.length; i++) {
            opChs.add(ops[i].c);
            trees.add(buildTree(ops[i - 1].i + 1, ops[i].i));
        }

        trees.add(buildTree(ops[ops.length - 1].i + 1, q));

        return buildFromOneRangByTrees(trees, opChs);

    }

    /**
     * Building three from expression
     *
     * @param p begin position in expressionString
     * @param q after end position
     * @return Expression Tree
     */
    private Tree buildTree(int p, int q) {

        int i = p;

        ArrayList<OperationIndex> ops = new ArrayList<OperationIndex>();

        // Loop executes only once or twice so it is fast
        while (i < q) {

            if (expressionMarks[i] == null) {
                break;
            }

            if (expressionMarks[i].type == ExpressionMark.MarkType.BiOperation) {
                OperationIndex opi = new OperationIndex();
                opi.c = expressionString[i];
                opi.i = i;
                ops.add(opi);
                i++;
            } else {
                i = expressionMarks[i].value;
            }

        }

        if (ops.size() > 0) {
            return buildFromOneRang(p, q, ops.toArray(new OperationIndex[ops.size()]));
        }

        if (expressionMarks[p].type == ExpressionMark.MarkType.Bracket) {
            return buildTree(p + 1, expressionMarks[p].value);
        }

        if (expressionMarks[p].type == ExpressionMark.MarkType.Var) {
            return new OperationVar(expressionString, p);
        }

        if (expressionMarks[p].type == ExpressionMark.MarkType.Num) {
            return new OperationConstant(expressionString, p);
        }


        // TODO: throw there exception instead null
        return null;

    }

    private void fillMarkers() {

        expressionMarks = new ExpressionMark[expressionString.length];
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

        int deep = 0;
        boolean inDigit = false;
        boolean inVarName = false;

        for (int i = 0; i != expressionMarks.length; i++) {

            char c = expressionString[i];

            // If var name or not
            if (Character.isLetter(c)) {

                if (!inVarName) {
                    inVarName = true;
                    stack.push(i);
                }
                continue;

            } else if (inVarName) {
                int q = stack.pop();
                expressionMarks[q] = new ExpressionMark();
                expressionMarks[q].type = ExpressionMark.MarkType.Var;
                expressionMarks[q].value = i;
                inVarName = false;
            }

            // If digit or not
            if (Character.isDigit(c)) {

                if (!inDigit) {
                    inDigit = true;
                    stack.push(i);
                }
                continue;

            } else if (inDigit) {
                int q = stack.pop();
                expressionMarks[q] = new ExpressionMark();
                expressionMarks[q].type = ExpressionMark.MarkType.Num;
                expressionMarks[q].value = i;
                inDigit = false;
            }

            // If  operation
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                expressionMarks[i] = new ExpressionMark();
                expressionMarks[i].type = ExpressionMark.MarkType.BiOperation;
                expressionMarks[i].value = deep;
                continue;
            }

            // If open or close brackets
            if (c == '(') {
                stack.push(i);
                deep++;
                continue;
            }
            if (c == ')') {
                int q = stack.pop();
                expressionMarks[q] = new ExpressionMark();
                expressionMarks[q].type = ExpressionMark.MarkType.Bracket;
                expressionMarks[q].value = i + 1;
                deep--;
            }

        }

        if (inDigit) {
            int q = stack.pop();
            expressionMarks[q] = new ExpressionMark();
            expressionMarks[q].type = ExpressionMark.MarkType.Num;
            expressionMarks[q].value = expressionMarks.length;
        }

        if (inVarName) {
            int q = stack.pop();
            expressionMarks[q] = new ExpressionMark();
            expressionMarks[q].type = ExpressionMark.MarkType.Var;
            expressionMarks[q].value = expressionMarks.length;
        }

    }

    private static class OperationIndex {

        public char c;
        public int i;

    }

}
