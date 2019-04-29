package com.example.demo.Repositories;

import com.example.demo.Models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long>{
    Film findFilmsById(Long id);
}