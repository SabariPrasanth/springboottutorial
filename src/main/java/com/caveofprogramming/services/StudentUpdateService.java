package com.caveofprogramming.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.caveofprogramming.model.StatusUpdate;
import com.caveofprogramming.model.StausUpdateDao;


@Service
public class StudentUpdateService {
	private final static int PAGESIZE = 3;
	@Autowired
	private StausUpdateDao statusUpdateDao;
	public void save (StatusUpdate statusUpdate) {
		statusUpdateDao.save(statusUpdate);
	}
public StatusUpdate getLatest() {
	return statusUpdateDao.findFirstByOrderByAddedDesc();
}

public Page<StatusUpdate> getPage(int pageNumber) {
	PageRequest request = PageRequest.of(pageNumber-1, PAGESIZE, Sort.Direction.DESC, "added");
	
	return statusUpdateDao.findAll(request);
}
public void delete(Long id) {
	statusUpdateDao.deleteById(id);
	
}
public StatusUpdate get(Long id) {
	
	return statusUpdateDao.findById(id).get();
}

}
