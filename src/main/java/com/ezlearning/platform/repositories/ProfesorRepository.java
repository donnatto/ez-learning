package com.ezlearning.platform.repositories;

import com.ezlearning.platform.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
