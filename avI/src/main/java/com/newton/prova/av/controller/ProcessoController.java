package com.newton.prova.av.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.prova.av.api.ProcessoDto;
import com.newton.prova.av.domain.entity.Processo;
import com.newton.prova.av.service.ProcessoService;


@RestController
public class ProcessoController {

	private final ProcessoService processoService;
	
	public ProcessoController(ProcessoService processoService) {
		this.processoService = processoService;
	}
	
	@GetMapping("/processo/{id}")
	public ProcessoDto getById(@PathVariable String id) {
		var processo = processoService.get(id);
		
		return new ProcessoDto(processo);
	}
	
	@GetMapping("/processos")
	public List<ProcessoDto> getAll() {
		var processos = processoService.getAll();
		
		var processoDtos = new ArrayList<ProcessoDto>();
		
		for (var processo: processos) {
			processoDtos.add(new ProcessoDto(processo));
		}
		
		return processoDtos;
	}
	
	@PostMapping("/processos")
	public ProcessoDto create(@RequestBody ProcessoDto p) {
		var processo = new Processo(p); 
		
		processo = processoService.create(processo);
		
		return new ProcessoDto(processo); 
	}
	
	@PutMapping("/processos/{id}")
	public ProcessoDto update(@PathVariable String id, @RequestBody ProcessoDto p) {
		var processo = new Processo(p);

		processo = processoService.update(id, processo);
		
		return new ProcessoDto(processo);
	}
	
	@DeleteMapping("/processos/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		processoService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
