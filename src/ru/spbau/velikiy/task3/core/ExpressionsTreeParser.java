package spbau.velikiy.task3.core;

import java.util.ArrayList;


public class ExpressionsTreeParser {

    private final char[] expressionString;
    private ExpressionMark[] expressionMarks;
    
    private Tree kernelTree;
    
    private final int DEFAULT_VALUE;
    
    public ExpressionsTreeParser(String expression, int defaultValue){

        DEFAULT_VALUE = defaultValue;
        
        String s = expression.replace(" ", "");
        expressionString = s.toCharArray();

        fillMarkers();
        kernelTree = new OperationConstant(DEFAULT_VALUE);
        kernelTree = buildTree(0, expressionString.length);
                
    }
    
    public ExpressionType getValue(ExpressionType xValue){
        
        return kernelTree.value(xValue);
        
    }


    static class OperationIndex{

        public char c;
        public int i;
        
    }

    Tree buildFromOneRangByTrees(ArrayList<Tree> trees, ArrayList<Character> ops) {

        if (ops.isEmpty())
            return trees.get(0);

        for(int i = 0; i != ops.size(); i++) {
            if (ops.get(i) == '/') {
                Tree tr = new OperationDivision();
                tr.left = trees.get(i);
                tr.right = trees.get(i + 1);
                trees.set(i, tr);
                trees.remove(i+1);
                ops.remove(i);
                return buildFromOneRangByTrees(trees, ops);
            }
        }

        for(int i = 0; i != ops.size(); i++) {
            if (ops.get(i) == '*') {
                Tree tr = new OperationMultiplication();
                tr.left = trees.get(i);
                tr.right = trees.get(i + 1);
                trees.set(i, tr);
                trees.remove(i+1);
                ops.remove(i);
                return buildFromOneRangByTrees(trees, ops);
            }
        }

        for(int i = 0; i != ops.size(); i++) {
            if (ops.get(i) == '-') {
                Tree tr = new OperationMinus();
                tr.left = trees.get(i);
                tr.right = trees.get(i + 1);
                trees.set(i, tr);
                trees.remove(i+1);
                ops.remove(i);
                return buildFromOneRangByTrees(trees, ops);
            }
        }

        for(int i = 0; i != ops.size(); i++) {
            if (ops.get(i) == '+') {
                Tree tr = new OperationPlus();
                tr.left = trees.get(i);
                tr.right = trees.get(i + 1);
                trees.set(i, tr);
                trees.remove(i+1);
                ops.remove(i);
                return buildFromOneRangByTrees(trees, ops);
            }
        }

        return null;

    }

    Tree buildFromOneRang(int p, int q, OperationIndex[] ops) {

        if (ops.length == 1) {
            Tree t = kernelTree.operationsFabric(
                    expressionString[ops[0].i]
            );
            t.left = buildTree(p, ops[0].i);
            t.right = buildTree(ops[0].i + 1, q);
            return t;
        }

        ArrayList<Tree> trees = new ArrayList<Tree>(ops.length + 1);
        ArrayList<Character> opChs = new ArrayList<Character>(ops.length);

        opChs.add(ops[0].c);
        trees.add(buildTree(p, ops[0].i));
        for(int i = 1; i != ops.length; i++) {
            opChs.add(ops[i].c);
            trees.add(buildTree(ops[i - 1].i + 1, ops[i].i));
        }
        trees.add(buildTree(ops[ops.length - 1].i + 1, q));

        return buildFromOneRangByTrees(trees, opChs);

    }

    // q is right border. can`t read on q position.
    Tree buildTree(int p, int q) {

        int i = p;

        ArrayList<OperationIndex> ops = new ArrayList<OperationIndex>();

        // Loop executes only once or twice so it is the constant operation
        while (i < q) {

            if (expressionMarks[i] == null)
                break;

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

        if (ops.size() > 0)
            return buildFromOneRang(p, q, ops.toArray(new OperationIndex[ops.size()]));

        if (expressionMarks[p].type == ExpressionMark.MarkType.Bracket)
            return buildTree(p + 1, expressionMarks[p].value);

        if (expressionMarks[p].type == ExpressionMark.MarkType.Var)
            return new OperationVar<T>();

        if (expressionMarks[p].type == ExpressionMark.MarkType.Num) {            
            return new OperationConstant<T>(DEFAULT_VALUE, expressionString, p);
        }

        

        return null;

    }

    void fillMarkers() {
        expressionMarks = new ExpressionMark[expressionString.length];
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

        int deep = 0;
        boolean inDigit = false;

        for(int i = 0; i != expressionMarks.length; i++) {

            char c = expressionString[i];

            // If var
            if (c == 'x') {
                expressionMarks[i] = new ExpressionMark();
                expressionMarks[i].type = ExpressionMark.MarkType.Var;
                expressionMarks[i].value = i + 1;
                continue;
            }

            // If digit or not
            if (Character.isDigit(c) || c == '.') {
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
            if (c == '-' || c == '+' || c == '*' || c == '/' ) {
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

    }



}
