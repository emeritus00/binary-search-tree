package com.keyin.bstvisualizer;

import com.keyin.bstvisualizer.controller.BSTController;
import com.keyin.bstvisualizer.repository.TreeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BSTControllerTest {
    @Autowired private BSTController controller;
    @Autowired private TreeRepository repository;

    @Test
    void testSubmitNumbers() {
        Model model = new BindingAwareModelMap();
        String result = controller.submitNumbers("5,3,7", model);

        assertEquals("index", result);
        assertNotNull(model.getAttribute("tree"));
        assertTrue(repository.count() > 0);
    }
}
