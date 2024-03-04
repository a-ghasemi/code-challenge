package leetcode.EvenOddTree;

import leetcode.EvenOddTree.abstractions.Strategy;
import leetcode.EvenOddTree.abstractions.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class BruteforceStrategy implements Strategy {

    Map<Integer, Integer> minMaxValues = new HashMap<>();

    @Override
    public boolean run(TreeNode root){
        return check(root, 0);
    }

    private boolean check(TreeNode node, int level){
        if(level % 2 == 0){
            if(Math.abs(node.val) % 2 == 0) return false;
            if(!minMaxValues.containsKey(level)){
                minMaxValues.put(level, node.val);
            }else{
                if(minMaxValues.get(level) >= node.val) return false;
                else minMaxValues.put(level, node.val);
            }
        }
        else {
            if(Math.abs(node.val) % 2 == 1) return false;
            if(!minMaxValues.containsKey(level)){
                minMaxValues.put(level, node.val);
            }else{
                if(minMaxValues.get(level) <= node.val) return false;
                else minMaxValues.put(level, node.val);
            }
        }
        if(node.left == null && node.right == null) return true;
        if(node.left == null) return check(node.right, level + 1);
        if(node.right == null) return check(node.left, level + 1);
        return check(node.left, level + 1) && check(node.right, level + 1);
    }

}

