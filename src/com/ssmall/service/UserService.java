package com.ssmall.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ssmall.pojo.Userpojo;

public interface UserService {
		//����ID��ѯ
		public Userpojo get(Integer id);
		//��ѯȫ��
		public PageInfo<Userpojo> getAll(Integer pageNum);
		//����idɾ��
		public boolean deleteById(Integer id);
		//����û�
		public boolean addUser(Userpojo user);
		//�޸��û�
		public boolean updateUser(Userpojo user);
}
