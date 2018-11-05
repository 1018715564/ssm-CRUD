package com.ssmall.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmall.dao.PublicDao;
import com.ssmall.pojo.Userpojo;

@Service
public class IUserServiceImpl implements UserService {

	@Resource
	private PublicDao dao;
	
	//����ID��ѯ����
	public Userpojo get(Integer id) {
		
		return this.dao.get(id);
	}
	
	
	
	//��ѯȫ��
	public PageInfo<Userpojo> getAll(Integer pageNum) {
		return this.dao.getAll(pageNum);
	}


	//ɾ������
	public boolean deleteById(Integer id) {
		
		return this.dao.deleteById(id);
	}


	@Override
	public boolean addUser(Userpojo user) {
		
		return this.dao.addUser(user);
	}


	@Override
	public boolean updateUser(Userpojo user) {
		
		return this.dao.updateUser(user);
	}
		
}
