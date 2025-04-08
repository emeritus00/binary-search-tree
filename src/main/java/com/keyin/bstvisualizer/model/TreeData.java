package com.keyin.bstvisualizer.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TreeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String numbers;

    @Column(columnDefinition = "TEXT")
    private String visualization;

    @Column(length = 1000)
    private String inOrderTraversal;

    // Constructors, getters, and setters
    public TreeData() {}

    public TreeData(String numbers, String visualization, String inOrderTraversal) {
        this.numbers = numbers;
        this.visualization = visualization;
        this.inOrderTraversal = inOrderTraversal;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInputNumbers() { return numbers; }
    public void setNumbers(String numbers) { this.numbers = numbers; }
    public String getVisualization() { return visualization; }
    public void setVisualization(String visualization) { this.visualization = visualization; }

    public String getNumbers() {
        return numbers;
    }

    public String getInOrderTraversal() {
        return inOrderTraversal;
    }

    public void setInOrderTraversal(String inOrderTraversal) {
        this.inOrderTraversal = inOrderTraversal;
    }
}