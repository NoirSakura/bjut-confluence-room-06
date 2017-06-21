package sse.bjut.council.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.Council;

public interface CouncilInfoDao extends PagingAndSortingRepository<Council, Integer> {
	List<Council> findByReserveID(Integer reserveID);
	List<Council> findByName(String name);
	List<Council> findByCouncilRoomID(Integer CouncilRoomID);
}
