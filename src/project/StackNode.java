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
public class StackNode<T> {
    
    StackNode<T> next;
    T data;
    
    StackNode(T data)
    {
        next = null;
        this.data = data;
    }
    
}

