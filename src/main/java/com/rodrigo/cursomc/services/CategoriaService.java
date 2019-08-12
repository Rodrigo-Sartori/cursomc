package com.rodrigo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rodrigo.cursomc.domain.Categoria;
import com.rodrigo.cursomc.repositories.CategoriaRepository;
import com.rodrigo.cursomc.services.execptions.DataIntegrityExecption;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Categoria update(Categoria obj) throws ObjectNotFoundException {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e ) {
			throw new DataIntegrityExecption("não é possível excluir uma categoria que possui produtos");
		}
	}
}	

