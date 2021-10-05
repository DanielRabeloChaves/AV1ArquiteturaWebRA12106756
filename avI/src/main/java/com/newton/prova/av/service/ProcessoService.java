package com.newton.prova.av.service;

import java.time.LocalDateTime;
import java.util.List;

import com.newton.prova.av.domain.entity.Processo;
import com.newton.prova.av.domain.repository.ProcessoRepository;
import com.newton.prova.av.exception.NotFoundException;

import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProcessoService {

	private final ProcessoRepository processoRepository;
	
	public Processo create(Processo p) {
		var now  = LocalDateTime.now();
		
		p.setCreatedAt(now);
		p.setModifiedAt(now);
		
		processoRepository.save(p);
		
		return p;
	}
	
	public Processo update(String id, Processo p) {
		var existing = get(id);

		existing.setDescricao(p.getDescricao());
		existing.setAutor(p.getAutor());
		existing.setLocal(p.getLocal());
		existing.setDataDePublicacao(p.getDataDePublicacao());
		existing.setStatus(p.getStatus());
		
		existing.setModifiedAt(LocalDateTime.now());
		
		processoRepository.save(existing);
		
		return existing; 
	}
	
	public Processo get(String id) {
		var processo = processoRepository.findById(id);
		
		if (processo.isEmpty()) {
			throw new NotFoundException("Processo with ID " + id + " not found");
		}
		
		return processo.get();
	}
	
	public List<Processo> getAll() {
		return processoRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		
		processoRepository.deleteById(id);
	}
}
