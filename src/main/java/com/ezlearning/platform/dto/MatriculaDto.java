package com.ezlearning.platform.dto;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatriculaDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private User user;
    private Curso curso;
}
