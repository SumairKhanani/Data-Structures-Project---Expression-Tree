/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.regex.Pattern;

/**
 *
 * @author Osama Hameed
 */
public class InfixToPostfixConvertor {
    
    InfixToPostfixConvertor()
    {
        
    }
    
    public String ConvertToPostfix(String str)
    {
        Stack<String> newStack = new Stack<>();
        String[] stringArray = str.split(" ");
        String postfix = "";
        
        for(int i = 0; i<stringArray.length; i++)
        {   
            String temp = stringArray[i];
            
            if(Pattern.matches("[-a-zA-Z0-9]*", temp))
            {
                postfix += temp + " ";
            }
            else if(temp.equals("-") || temp.equals("+"))
            {
                while(newStack.Peek() != null && !newStack.Peek().equals("("))
                {
                    postfix += newStack.Pop() + " ";
                }
                
                newStack.Push(temp);
            }
            else if(temp.equals("*") || temp.equals("/"))
            {
                if(newStack.Peek()!=null && (newStack.Peek().equals("*") || newStack.Peek().equals("/")))
                {
                    postfix += newStack.Pop() + " ";
                }
                
                newStack.Push(temp);
            }
            else if(temp.equals("("))
            {
                newStack.Push(temp);
            }
            else if(temp.equals(")"))
            {
                while(!newStack.Peek().equals("(")) 
                {
                    postfix += newStack.Pop() + " ";
                }
                
                newStack.Pop();
            }
        }
        
        while(!newStack.isEmpty())
        {
            postfix += newStack.Pop() + " ";
        }
        
        return postfix;
    }
    
}
