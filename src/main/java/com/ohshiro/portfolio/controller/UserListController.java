package com.ohshiro.portfolio.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ohshiro.portfolio.form.UserListForm;
import com.ohshiro.portfolio.model.MUser;
import com.ohshiro.portfolio.service.UserService;

@Controller
public class UserListController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	//ユーザー一覧画面を表示	
	@GetMapping({ "/list", "user/list" })
	public String getUserList(@ModelAttribute UserListForm form, Model model) {

		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);

		//ユーザー検索
		List<MUser> userList = userService.getUsers(user);

		//Modelに登録
		model.addAttribute("userList", userList);

		//ユーザー一覧画面を表示
		return "user/list";
	}

	//ユーザー検索処理
	@PostMapping("/list")
	public String postUserList(@ModelAttribute UserListForm form, Model model) {

		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);

		//ユーザー検索
		List<MUser> userList = userService.getUsers(user);

		//Modelに登録
		model.addAttribute("userList", userList);

		//ユーザー一覧画面を表示
		return "user/list";
	}

}
