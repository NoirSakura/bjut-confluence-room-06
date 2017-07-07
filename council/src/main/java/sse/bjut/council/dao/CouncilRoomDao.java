package sse.bjut.council.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.CouncilRoom;

public interface CouncilRoomDao extends PagingAndSortingRepository<CouncilRoom, Integer> {
	CouncilRoom findByIdAndDelFlagAndStopFlag(Integer id, Boolean delFlag, Short stopFlag);
	CouncilRoom findByIdAndDelFlag(Integer id, Boolean delFlag);
	CouncilRoom findByRoomNoAndDelFlag(Integer roomNo, Boolean delFlag);
	CouncilRoom findByRoomNameAndDelFlag(String roomName, Boolean delFlag);
	List<CouncilRoom> findByDelFlagAndStopFlag(Boolean delFlag,Short StopFlag);
}