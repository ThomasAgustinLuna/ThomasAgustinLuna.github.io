package com.ThomasLuna.Portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ThomasLuna.Portfolio.entities.Formulario;

@Repository
public interface FormularioRepositorio extends JpaRepository<Formulario,String>{

    @Query("SELECT f FROM Formulario f WHERE f.nombre = :nombre")
    public Formulario buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT f FROM Formulario f WHERE f.email = :email")
    public Formulario buscarPorEmail(@Param("email")String email);

}
