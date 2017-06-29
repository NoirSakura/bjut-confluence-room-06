package sse.bjut.council.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.CouncilRoom;

public interface CouncilRoomDao extends PagingAndSortingRepository<CouncilRoom, Integer> {
	CouncilRoom findByIdAndDelFlagAndStopFlag(Integer id, Boolean delFlag, Boolean stopFlag);
	List<CouncilRoom> findByDelFlag(Boolean delFlag);
}