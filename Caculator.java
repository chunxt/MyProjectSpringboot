package com.example.pojo;

import java.util.Scanner;

/**
 * @Author Cxt
 * @Date 2022-04-2022/4/27-10:32
 */
public class Caculator {
    public static void main(String[] args) {
        //表达式的运算
        String expression="70+2*6-4";
        //创建两个栈，一个数栈，一个符号栈
        StackArrary2 numStack=new StackArrary2(10);
        StackArrary2 operStack=new StackArrary2(10);
        //定义一个扫描的索引index
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        //用于拼接多位数
        String keepNum="";
        //将每次扫描到的char保存到ch中
        char ch=' ';
        //while循环，扫描到expression最后一个结束
        while (true){
            ch=expression.substring(index,index+1).charAt(0);
            //判断ch是什么
            if(operStack.isOper(ch)){
                //如果是运算符，判断符号栈是否为空
                if(operStack.isEmpty()){
                    operStack.push(ch);
                }
                else {
                    //不为空，处理，比较优先级
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        //pop数栈中的2个数，进行计算
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        //把运算结果入栈
                        numStack.push(res);
                        //把当前运算符入栈
                        operStack.push(ch);
                    }
                    else {
                        //当前操作符的优先级大于栈中的操作符，直接如符号栈
                        operStack.push(ch);
                    }
                }
            }
            //如果是数栈，直接入栈
            else {
                //ascii的原因，真正的数是对应字符要减去48
                //入数栈时，需要看是否为多位数，不能立马入栈
                //numStack.push(ch-48);
                keepNum+=ch;
                if(index==expression.length()-1){
                    //如果ch已经是expression的最后一位，直接入栈
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一位是否为数字，如果是数字就继续扫描，如果是运算符，就继续入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";
                    }
                }
            }
            //让index+1，判断是否扫描到expression最后一位
            index++;
            if(index>=expression.length()){
                break;  //扫描结束
            }
        }
        //当扫描结束，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true){
            //当符号栈为空，则计算到最后的结果，数栈中只有一个数字（结果）
            if(operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            //把运算结果入栈
            numStack.push(res);
        }
        System.out.printf("表达式:%s = %d ",expression,numStack.pop());

    }
}
class StackArrary2 {
    private int maxSize;    //栈的的大小
    private int[] stack;
    private int top = -1;    //表示栈顶，初始化为-1


    public StackArrary2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满的情况
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        } else {
            top++;
            stack[top] = num;
        }
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空！");
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }
    //返回栈顶元素，不出栈
    public int peek(){
        return stack[top];
    }

    //遍历栈
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
    //返回运算符的优先级，用数字表示
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }
        else if(oper=='+'||oper=='-'){
            return 0;
        }
        else {
            return -1;  //操作符只含有+-*/
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return (val=='+'||val=='-'||val=='*'||val=='/');
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
         int res=0;
         switch (oper){
             case '+':
                 res=num1+num2;
                 break;
             case '-':
                 res=num2-num1;   //注意顺序
                 break;
             case '*':
                 res=num1*num2;
                 break;
             case '/':
                 res=num2/num1;
                 break;
         }
         return res;
    }
}
