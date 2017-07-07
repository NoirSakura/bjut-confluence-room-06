package sse.bjut.council.dao;

import java.util.Date;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.LoginInfo;

public interface LoginInfoDao extends PagingAndSortingRepository<LoginInfo, Integer> {
	LoginInfo findByAccount(String account);
	LoginInfo findByAccountAndDelFlag(String account, Boolean delFlag);
	LoginInfo findByAccountAndPrivilege(String account, Boolean Privilege);
	LoginInfo findByLastLoginTime(Date lastLoginTime);
	LoginInfo findByPrivilege(Boolean privilege);
	LoginInfo findByStaffIdAndDelFlag(Integer staffId, Boolean delFlag);
}
