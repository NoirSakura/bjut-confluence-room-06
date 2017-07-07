package sse.bjut.council.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.Council;

public interface CouncilInfoDao extends PagingAndSortingRepository<Council, Integer> {
	List<Council> findByReserveIDAndState(Integer reserveID, Integer state);
	List<Council> findByName(String name);
	List<Council> findByCouncilRoomID(Integer CouncilRoomID);
	List<Council> findByState(Integer state);
}
