package com.devsuperior.bds02.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;

	@Transactional
	public List<CityDTO> findAll() {
									// Variação do findAll utilizando o Sort.by para passarmos a ordenação desejada.
		List<City> list = repository.findAll(Sort.by("name"));
		return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
	}
}
