package com.keyin.bstvisualizer.model;

import java.util.ArrayList;
import java.util.List;

public class BSTree {
    private BSTNode root;
    private List<Integer> traversalOrder = new ArrayList<>();

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private BSTNode insertRec(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public List<Integer> inOrderTraversal() {
        traversalOrder.clear();
        inOrderRec(root);
        return traversalOrder;
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            traversalOrder.add(root.value);
            inOrderRec(root.right);
        }
    }

    public String visualize() {
        StringBuilder sb = new StringBuilder();
        visualizeRec(root, 0, sb);
        return sb.toString();
    }

    private void visualizeRec(BSTNode node, int level, StringBuilder sb) {
        if (node != null) {
            visualizeRec(node.right, level + 1, sb);
            sb.append("  ".repeat(level)).append(node.value).append("\n");
            visualizeRec(node.left, level + 1, sb);
        }
    }

    public BSTNode getRoot() {
        return root;
    }
}

