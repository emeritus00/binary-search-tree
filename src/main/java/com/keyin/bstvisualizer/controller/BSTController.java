package com.keyin.bstvisualizer.controller;

import com.keyin.bstvisualizer.model.BSTree;
import com.keyin.bstvisualizer.model.TreeData;
import com.keyin.bstvisualizer.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BSTController {

    @Autowired
    private TreeRepository treeRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/submit")
    public String submitNumbers(@RequestParam String numbers, Model model) {
        try {

            List<Integer> numList = Arrays.stream(numbers.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());


            BSTree tree = new BSTree();
            numList.forEach(tree::insert);

            String visualization = tree.visualize();
            String inOrderTraversal = tree.inOrderTraversal().toString();

            TreeData treeData = new TreeData(numbers, visualization, inOrderTraversal);
            treeRepository.save(treeData);

            model.addAttribute("tree", visualization);
            model.addAttribute("numbers", numbers);
            model.addAttribute("inOrder", tree.inOrderTraversal());

        } catch (NumberFormatException e) {
            model.addAttribute("error", "Please enter valid numbers separated by commas");
        }

        return "index";
    }

    @GetMapping("/previous")
    public String showPrevious(Model model) {
        List<TreeData> trees = treeRepository.findAllByOrderByIdDesc();
        model.addAttribute("trees", trees);
        return "previous";
    }
}