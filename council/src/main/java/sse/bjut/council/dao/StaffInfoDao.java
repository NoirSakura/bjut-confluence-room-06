package sse.bjut.council.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.Staff;

public interface StaffInfoDao extends PagingAndSortingRepository<Staff, Integer>{
	List<Staff> findByName(String name);
	Staff findByEmail(String email);
	Staff findByPhone(Integer phone);
	List<Staff> findByNameAndDelFlag(String name, Boolean DelFlag);
}