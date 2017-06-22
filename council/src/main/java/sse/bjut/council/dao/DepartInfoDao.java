package sse.bjut.council.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.Depart;

public interface DepartInfoDao extends PagingAndSortingRepository<Depart, Integer> {
	Depart findByDepartName(String departName);
	Depart findByManagerID(Integer managerID);
}