package com.eccomerce.demo.Repository;

import com.eccomerce.demo.Entity.Category;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository

public interface categoryRepository extends JpaRepository<Category,Integer> {

}
