package com.example.demo.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
	
	@Autowired StatusRepository statusRepository;

	public List<Status> findAll() {
		return (List<Status>) statusRepository.findAll();
		
	}

	public Status save(Status status) {
		return statusRepository.save(status);
		
	}

	public Status findById(Long id) {
		return statusRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}
	
}
