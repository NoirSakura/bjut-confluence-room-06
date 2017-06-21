package sse.bjut.council.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.CouncilCancel;

public interface CouncilCancelDao extends PagingAndSortingRepository<CouncilCancel, Integer>  {
	
}