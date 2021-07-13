package com.ohshiro.portfolio.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ohshiro.portfolio.form.UserDetailForm;
import com.ohshiro.portfolio.model.MUser;
import com.ohshiro.portfolio.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserDetailController {

	@Autowired
	private UserService userService;

	//	@Autowired
	//	private Salary salary;

	@Autowired
	private ModelMapper modelMapper;

	//ユーザー詳細画面を表示
	//メールアドレスをuserIdにしているためgetは正規表現を使用
	@GetMapping("/detail/{userId:.+}")
	public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId) {

		//ユーザー1件を取得
		MUser user = userService.getUserOne(userId);
		System.out.println(user);//後で消す
		user.setPassword(null);

		//userをformに変換
		form = modelMapper.map(user, UserDetailForm.class);
		form.setSalaryList(user.getSalaryList());

		//Modelに登録
		model.addAttribute("userDetailForm", form);

		//ユーザー詳細画面を表示
		return "user/detail";

	}

	//ユーザー更新処理
	@PostMapping(value = "/detail", params = "update")
	public String updateUser(UserDetailForm form, Model model) {

		try {
			//ユーザーを更新
			userService.updateUserOne(form.getUserId(), form.getPassword(), form.getUserName());
		} catch (Exception e) {
			log.error("ユーザー更新でエラー", e);
		}
		return "redirect:list";
	}

	//ユーザー削除処理
	@PostMapping(value = "/detail", params = "delete")
	public String deleteUserOne(UserDetailForm form, Model model) {

		//ユーザーを削除
		userService.deleteUserOne(form.getUserId());

		//ユーザー一覧画面リダイレクト
		return "redirect:user/list";
	}

}
