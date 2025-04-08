package com.keyin.bstvisualizer.repository;

import com.keyin.bstvisualizer.model.TreeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<TreeData, Long> {
    List<TreeData> findAllByOrderByIdDesc();
}