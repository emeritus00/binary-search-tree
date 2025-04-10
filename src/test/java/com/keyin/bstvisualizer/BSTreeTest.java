package com.keyin.bstvisualizer;

import com.keyin.bstvisualizer.model.BSTree;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BSTreeTest {
    private BSTree tree;

    @BeforeEach
    void setUp() {
        tree = new BSTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
    }

    @Test
    void testInOrderTraversal() {
        assertEquals("[2, 3, 5, 7]", tree.inOrderTraversal().toString());
    }

    @Test
    void testVisualization() {
        String expected = "  7\n5\n  3\n    2\n";
        assertEquals(expected, tree.visualize());
    }

    @Test
    void testEmptyTree() {
        BSTree emptyTree = new BSTree();
        assertTrue(emptyTree.inOrderTraversal().isEmpty());
        assertEquals("", emptyTree.visualize());
    }
}