package spbau.velikiy.task3.core;

import spbau.velikiy.task3.core.operations.*;
import spbau.velikiy.task3.exceptions.ParserParsingException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse expression and build evaluation tree from it
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */

public class ExpressionsTreeParser {

    private final Tree rootTree;

    private final char[] expressionString;
    private ExpressionMark[] expressionMarks;

    private static final Pattern applicationPattern = Pattern.compile("([a-zA-Z]+)\\(");

    /**
     * build evaluation tree from source code
     *
     * @param expression source code line to build evaluation tree
     * @throws ParserParsingException if can't parse
     */
    public ExpressionsTreeParser(String expression) throws ParserParsingException {

        String s = preprocessor(expression);
        expressionString = s.toCharArray();

        fillMarkers();
        rootTree = buildTree(0, expressionString.length);

    }

    /**
     * get evaluation tree
     *
     * @return evaluation tree
     */
    public Tree getRootTree() {
        return rootTree;
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

    private Tree buildFromOneRangByTrees(ArrayList<Tree> trees, ArrayList<Character> ops) 
            throws ParserParsingException{

        if (ops.isEmpty()) {
            return trees.get(0);
        }

        int i;

        i = ops.indexOf('@');
        if (i != -1) {
            return operatorParse(i, new OperationApply(), trees, ops);
        }
        
        i = ops.indexOf('/');
        if (i != -1) {
            return operatorParse(i, new OperationDivision(), trees, ops);
        }

        i = ops.indexOf('*');
        if (i != -1) {
            return operatorParse(i, new OperationMultiplication(), trees, ops);
        }

        i = ops.indexOf('-');
        if (i != -1) {
            return operatorParse(i, new OperationMinus(), trees, ops);
        }

        i = ops.indexOf('+');
        if (i != -1) {
            return operatorParse(i, new OperationPlus(), trees, ops);
        }

       
        throw new ParserParsingException("Undefined operator");

    }

    private Tree operatorParse(int opCharPosition, Tree opObj,
                               ArrayList<Tree> trees, ArrayList<Character> ops) throws ParserParsingException{

        opObj.left = trees.get(opCharPosition);
        opObj.right = trees.get(opCharPosition + 1);
        trees.set(opCharPosition, opObj);
        trees.remove(opCharPosition + 1);
        ops.remove(opCharPosition);

        return buildFromOneRangByTrees(trees, ops);

    }

    private Tree buildFromOneRang(int p, int q, OperationIndex[] ops) throws ParserParsingException {

        if (ops.length == 1) {
            Tree t = Tree.operationsFabric(expressionString[ops[0].i]);
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
     * @throws ParserParsingException if can't parse
     */
    private Tree buildTree(int p, int q) throws ParserParsingException {

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

            // If operation
            if (c == '-' || c == '+' || c == '*' || c == '/' || c == '@') {
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
