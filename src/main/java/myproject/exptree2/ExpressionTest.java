package myproject.exptree2;

public class ExpressionTest {

	public static void main(String[] args) {
        String s = "1+2+3-4*5/6";
        
        String result = evaluate(s);
        
        System.out.println("result: " + result);
    }
    
    private static boolean isConstant(String s) {
        return "1234567890".indexOf(s) != -1;
    }
    
    private static String operator(String s) {
        return String.valueOf(s.charAt(1));
    }
    
    private static String leftOperand(String s) {
        return String.valueOf(s.charAt(0));
    }
    
    private static String rightOperand(String s) {
        return s.substring(2);
    }
    
    private static String evaluate(String s) {
        if (s == "") {
            return "";
        }
        
        if (isConstant(s)) {
            return s;
        } else {
            return applyOperator(evaluate(leftOperand(s)), evaluate(rightOperand(s)), operator(s));
        }
    }

    private static String applyOperator(String e1, String e2, String operator) {
        System.out.println("e1: " + e1 +", e2: " + e2 + ", op: " + operator);
        switch (operator) {
        case "+": return Integer.parseInt(e1) + Integer.parseInt(e2) + "";
        case "-": return Integer.parseInt(e1) - Integer.parseInt(e2) + "";
        case "*": return Integer.parseInt(e1) * Integer.parseInt(e2) + "";
        case "/": return Integer.parseInt(e1) / Integer.parseInt(e2) + "";
        }
        
        throw new IllegalArgumentException("Not support operation");
    }

}
