package com.caveofprogramming.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StausUpdateDao extends PagingAndSortingRepository<StatusUpdate, Long> {
	StatusUpdate findFirstByOrderByAddedDesc();
}
