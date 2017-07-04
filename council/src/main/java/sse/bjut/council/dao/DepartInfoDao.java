package sse.bjut.council.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.Depart;

public interface DepartInfoDao extends PagingAndSortingRepository<Depart, Integer> {
	Depart findByDepartNameAndDelFlag(String departName,Boolean delFlag);
	List<Depart> findByDelFlag(Boolean delFlag);
	Depart findByManagerID(Integer managerID);
}