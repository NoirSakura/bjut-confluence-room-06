package sse.bjut.council.dao;

import java.util.Date;

import org.springframework.data.repository.PagingAndSortingRepository;

import sse.bjut.council.entity.LoginInfo;

public interface LoginInfoDao extends PagingAndSortingRepository<LoginInfo, Integer> {
	LoginInfo findByLastLoginTime(Date lastLoginTime);
	LoginInfo findByPrivilege(Boolean privilege);
	LoginInfo findByAccount(String account);
}
