package com.newton.prova.av.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.newton.prova.av.api.ProcessoDto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Processo {

	@Id
	private String id;
	
	private String descricao;
	
	private String autor;
	
    private String local;
    
    private LocalDate dataDePublicacao;

    private String status;
	
	private LocalDateTime createdAt; 
	
	private LocalDateTime modifiedAt;	
	
	public Processo(ProcessoDto p) {
		this.setDescricao(p.getDescricao());
		this.setAutor(p.getAutor());
		this.setLocal(p.getLocal());
		this.setDataDePublicacao(p.getDataDePublicacao());
		this.setStatus(p.getStatus());
	}
}