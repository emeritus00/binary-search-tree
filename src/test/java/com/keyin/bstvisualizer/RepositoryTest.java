package com.keyin.bstvisualizer;

import com.keyin.bstvisualizer.model.TreeData;
import com.keyin.bstvisualizer.repository.TreeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TreeRepository repository;

    @Test
    void testSaveAndRetrieveTree() {
        TreeData tree = new TreeData("5,3,7", "Test Visualization", "[3, 5, 7]");
        entityManager.persist(tree);
        entityManager.flush();

        TreeData found = repository.findById(tree.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("5,3,7", found.getInputNumbers());
        assertEquals("Test Visualization", found.getVisualization());
        assertEquals("[3, 5, 7]", found.getInOrderTraversal());
    }
}