package com.ThomasLuna.Portfolio.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ThomasLuna.Portfolio.entities.Formulario;
import com.ThomasLuna.Portfolio.exceptions.MiException;
import com.ThomasLuna.Portfolio.repositories.FormularioRepositorio;

import jakarta.transaction.Transactional;

@Service
public class FormularioServicio {
    
    @Autowired
    private FormularioRepositorio formRepo;
    
    @Transactional
    public void crearFormulario(String nombre, String email)throws MiException{
        validar(nombre, email);
        Formulario form = new Formulario();

        form.setNombre(nombre);
        form.setEmail(email);

        formRepo.save(form);
    }

    public void modificarFormulario(String id,String nombre,String email)throws MiException{
        validar(nombre, email);
        Optional <Formulario> resp = formRepo.findById(id);
        

        if(resp.isPresent()){
            Formulario form = resp.get();
            form.setNombre(nombre);
            form.setEmail(email);
        }

    }

    public void validar(String nombre,String email)throws MiException{

        if(nombre==null || nombre.isEmpty()){
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }

        if(email==null || email.isEmpty()){
            throw new MiException("el email no puede ser nulo o estar vacio");
        }

    }
}
