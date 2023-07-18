/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Osama Hameed
 */
public class Stack<T extends Comparable<T>>{
    
    StackNode<T> top;
    
    Stack()
    {
        top = null;
    }
    
    public void Push(T data)
    {
        StackNode<T> temp = new StackNode<T>(data);
        
        if(top == null)
        {
           top = temp; 
        }
        else
        {
            temp.next = top;
            top = temp;
        }
    }
    
    public boolean isEmpty()
    {
        return top == null;
    }
    
    public T Pop()
    {
        if(top != null)
        {
            StackNode<T> temp = top;
            top = top.next;
            return temp.data;
        }
        return null;
    }
    
    public T Peek()
    {
        if(top != null)
        {
            return top.data;
        }
        return null;
    }
    
    @Override
    public String toString()
    {
        StackNode<T> temp = top;
        String str = "";
        
        while(temp != null)
        {
            str += temp.data + ",";
            temp = temp.next;
        }
        
        return str;
    }
    
    public static boolean validate(String Exp)
    {
        Stack<Character> newStack = new Stack();
        char[] temp = Exp.toCharArray();
        int count = 0;
        
        while(count != temp.length)
        {
            char symbol = temp[count];
            
            if(symbol == '(' || symbol =='[' || symbol == '{')
            {
                newStack.Push(symbol);
            }
            else if(symbol == ')' || symbol ==']' || symbol == '}')
            {
                if(newStack.isEmpty())      return false;
                else if(symbol == ')')
                {
                   if(newStack.Pop() != '(')
                   {
                       return false;
                   }
                }
                else if(symbol == ']')
                {
                   if(newStack.Pop() !=  '[')
                   {
                       return false;
                   }
                }
                else if(symbol == '}')
                {
                   if(newStack.Pop() !=  '{')
                   {
                       return false;
                   }
                }
            }
            count++;
        }
        
        return newStack.isEmpty();
        
    }
}
