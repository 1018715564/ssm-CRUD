package com.ssmall.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ssmall.pojo.Userpojo;
import com.ssmall.service.UserService;

@Controller
public class UserAction {
	@Resource
	private UserService userService;

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @param null
	 * @return
	 */
	@RequestMapping("/user/all/{index}")
	public ModelAndView getUserAll(@PathVariable("index") Integer index) {
		ModelAndView model = new ModelAndView("list");
		PageInfo<Userpojo> all = userService.getAll(index);
		List<Userpojo> list = all.getList();
		model.addObject("allList", list);
		//�洢��ǰ����������
		model.addObject("index", index);
		//�����ֶܷ���ҳ
		int pages = all.getPages();
		model.addObject("lastnum", pages);
		return model;
	}

	/**
	 * ����id��ѯ������Ϣ
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/user/get/{id}")
	public String getUserById(@PathVariable("id") Integer id) {
		Userpojo userpojo = userService.get(id);
		return "success";
	}

	/**
	 * ����idɾ��
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	public String DeleteById(@RequestParam("id") Integer id) {
		// ִ��ɾ��
		boolean deleteById = userService.deleteById(id);
		// ɾ���ɹ����ѯ
		return "redirect:/user/all/1";
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/user/addUser")
	public String addUser(Userpojo user) {
		userService.addUser(user);
		return "redirect:/user/all";
	}

	// �����û�����ת����
	@RequestMapping("/user/addready")
	public String addReady(Model model) {
		model.addAttribute("itemForm", "form");
		// ����û�֮���������������һ���ж���ӻ����޸�ҳ�������
		// ����������ݣ�����ͨ��jstl����form.jspҳ��
		return "form";
	}

	/**
	 * �޸��û�
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Userpojo user){
		userService.updateUser(user);
		return "redirect:/user/all/1";
	}
	@RequestMapping("/updateById")
	public String updateReady(@RequestParam("id") Integer id,Model model) {
		Userpojo userpojo = userService.get(id);
		model.addAttribute("userlist", userpojo);
		return "form";
	}
	
	
}
