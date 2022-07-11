package com.tgt.rysetti.learningresourcesapi.repository;

import com.tgt.rysetti.learningresourcesapi.entity.LearningResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningResourceRepository extends JpaRepository<LearningResource, Integer> {
}
