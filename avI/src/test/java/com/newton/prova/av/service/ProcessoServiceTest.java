package com.newton.prova.av.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.newton.prova.av.domain.entity.Processo;
import com.newton.prova.av.domain.repository.ProcessoRepository;

@ExtendWith(MockitoExtension.class)
class ProcessoServiceTest {
	
	@Mock
	private ProcessoRepository processoRepository;
	
	private ProcessoService unit;

	@BeforeEach
	public void setup() {
		unit = new ProcessoService(processoRepository);
	}
	
	@Test
	void test_getById_RetornarObj() {
		// given:
		var processo = new Processo();
		processo.setId("processo1");
		
		// mock definitions: 
		Mockito.when(processoRepository.findById("processo1"))
			.thenReturn(Optional.of(processo));

		// test:
		var result = unit.get("processo1");
		
		// assert:
		Assertions.assertEquals(result, processo);
		
		// verify: 
		Mockito.verify(processoRepository).findById("processo1");
	}
}
