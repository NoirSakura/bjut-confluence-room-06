package sse.bjut.council.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.Staff;

public interface StaffInfoDao extends PagingAndSortingRepository<Staff, Integer>{
	Staff findByEmailAndDelFlag(String email, Boolean delFlag);
	Staff findByPhoneAndDelFlag(String phone, Boolean delFlag);
	List<Staff> findByNameAndDelFlag(String name, Boolean delFlag);
	List<Staff> findByDepartIDAndDelFlagAndStateAndStopFlag(Integer departID, Boolean delFlag, Boolean state, Boolean stopFlag);
	List<Staff> findByDelFlag(Boolean delFlag);
	List<Staff> findByStateAndDelFlag(Boolean state, Boolean delFlag);
}