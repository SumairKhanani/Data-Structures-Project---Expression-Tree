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
public class TreeNode implements Comparable<TreeNode>
{
    
    TreeNode left;
    TreeNode right;
    String data;
    
    TreeNode(String data)
    {
        this.data = data;
    }

    @Override
    public int compareTo(TreeNode t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
