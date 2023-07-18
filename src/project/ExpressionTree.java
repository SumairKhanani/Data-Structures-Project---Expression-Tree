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
public class ExpressionTree {
    
    TreeNode root;
    
    ExpressionTree()
    {
        root = null;
    }
    
    
    public void MakeExpressionTree(String expression)
    {
        String[] arr = expression.split(" ");
        Stack<TreeNode> tree;
        tree = new Stack<>();
        
        for(int i =0; i<arr.length; i++)
        {
            String temp = arr[i];
            TreeNode newNode = new TreeNode(temp);
            
            if(temp.equals("*") || temp.equals("/") || temp.equals("+") || temp.equals("-"))
            {
                newNode.right = tree.Pop();
                newNode.left = tree.Pop();
                
                tree.Push(newNode);
            }
            else
            {
                tree.Push(newNode);
            }
            
        }
        
        root = tree.Pop();
    }
    
    public void LNR(TreeNode n)  //In-Order traversal
    {
        if(n.left != null)
        {
            LNR(n.left);
        }
        
        System.out.print(n.data + " ");
        
        if(n.right != null)
        {
            LNR(n.right);
        }
    }
    
    public void GiveInfixExpression()
    {
        LNR(this.root);
        System.out.println();
    }
    
    public void GivePostfixExpression()
    {
        LRN(this.root);
        System.out.println();
    }
    
    public void LRN(TreeNode n)  //Post-Order Traversal
    {
        if(n.left != null)
        {
            LRN(n.left);
        }
        
        if(n.right != null)
        {
            LRN(n.right);
        }
        
        System.out.print(n.data + " ");
    }
    
    private double Evaluate(TreeNode n)
    {
        if(n == null)
        {
            return 0;
        }
        else if(n.data.equals("+") || n.data.equals("-") || n.data.equals("/") || n.data.equals("*"))
        {
            if(n.data.equals("+"))
            {
                return Evaluate(n.left) + Evaluate(n.right);
            }
            else if(n.data.equals("-"))
            {
                return Evaluate(n.left) - Evaluate(n.right);
            }
            else if(n.data.equals("*"))
            {
                return Evaluate(n.left) * Evaluate(n.right);
            }
            else
            {
                return Evaluate(n.left) / Evaluate(n.right);
            }
        }
        else
        {
            return Double.parseDouble(n.data);
        }
    }
    
    public double EvaluateExpression()
    {
        return Evaluate(this.root);
    }
}
