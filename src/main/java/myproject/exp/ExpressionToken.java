package myproject.exp;

import java.util.Scanner;

/**
 * The ExpressionToken enumeration is used to describe the type of an expression token,
 * as well as to provide the operation associated with that type.
 * 
 * @author Peter Jensen
 */
public enum ExpressionToken
{
    // Do not change the order of these declarations.
    
    UNKNOWN, 
    PLUS   {double apply (double left, double right) {return left+right;} public String toString() {return "+";}},
    MINUS  {double apply (double left, double right) {return left-right;} public String toString() {return "-";}},
    TIMES  {double apply (double left, double right) {return left*right;} public String toString() {return "*";}},
    DIVIDE {double apply (double left, double right) {return left/right;} public String toString() {return "/";}},
    MOD    {double apply (double left, double right) {return left%right;} public String toString() {return "%";}},
    NUMBER;
    
    /**
     * Applies the operation.  Note that the parameters are specified in reverse order.
     * 
     * @param right the right operand
     * @param left the left operand
     * @return the result of applying this type of operation to the operands
     * @throws RuntimeException if this token is not an operation
     */
    double apply (double right, double left)
    {
        throw new RuntimeException ("Cannot apply token: " + this);
    }
    
    /**
     * Determines the type of this token.  Given a String, this method
     * will return the Token that corresponds to the type of token
     * represented by the String.  For example, if "+" is given, then
     * ExpressionToken.PLUS will be returned.
     * 
     * @param token a string containing a token
     * @return an ExpressionToken object specifying the type of token
     */
    public static ExpressionToken determineType (String token)
    {
        Scanner s = new Scanner (token.trim());
        if (s.hasNextDouble())
            return ExpressionToken.NUMBER;
        else
            return ExpressionToken.values()["+-*/%".indexOf(token.trim())+1];  // Depends on order of declarations.
        
    }        
}
