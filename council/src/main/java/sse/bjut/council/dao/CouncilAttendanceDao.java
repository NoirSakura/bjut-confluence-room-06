package sse.bjut.council.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.CouncilAttendance;

public interface CouncilAttendanceDao extends PagingAndSortingRepository<CouncilAttendance, Integer> {
	List<CouncilAttendance> findByAttIdAndDelFlag(Integer attId, Boolean delFlag);
}
