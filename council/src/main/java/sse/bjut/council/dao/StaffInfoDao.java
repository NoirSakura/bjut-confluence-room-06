package sse.bjut.council.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.Staff;

public interface StaffInfoDao extends PagingAndSortingRepository<Staff, Integer>{
	
}
