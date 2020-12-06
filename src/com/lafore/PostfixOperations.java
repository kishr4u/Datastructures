package com.lafore;

import javafx.geometry.Pos;

public class PostfixOperations {

    private String input,output = new String();
    private Stack stack = new Stack();

    public void doTrans(){
        for (int j = 0; j < input.length();j++){
            char ch = input.charAt(j);
            switch(ch){
                case '*':
                case '/':
                    stack.push(ch);
                    break;
                case '+':
                case '-':
                    char outChar ;
                    while (stack.peek() != '(' && stack.peek() != 0) {
                        outChar= stack.pop();
                        output = output + outChar;

                    }
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                   char outChar1;
                    while (stack.peek() != '(') {
                        outChar1 = stack.pop();
                        output = output + outChar1;
                    }
                    stack.pop();
                    break;
                default:
                    output = output + ch;
            }

        }
        while (!stack.isEmpty()){
            output = output + stack.pop();
        }
    }

    public void evaluate(String output){
        for(int j=0; j < output.length();j++){

        }
    }

    public static void main(String[] args) {
        PostfixOperations po = new PostfixOperations();
        po.input="A+B*C-(D*L+R)+F";
        po.doTrans();
        System.out.println(po.output);
    }
}
