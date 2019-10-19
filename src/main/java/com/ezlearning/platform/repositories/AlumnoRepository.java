package com.ezlearning.platform.repositories;

import com.ezlearning.platform.model.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
