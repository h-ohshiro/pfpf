package com.ohshiro.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohshiro.portfolio.model.MUser;
import com.ohshiro.portfolio.repository.UserMapper;
import com.ohshiro.portfolio.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	//	ユーザー登録
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1);//部署
		user.setRole("ROLE_GENERAL");//ロール
		//パスワード暗号化
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		mapper.insertOne(user);
	}

	//ユーザー取得
	@Override
	public List<MUser> getUsers(MUser user) {
		return mapper.findMany(user);
	}

	//ユーザー1件取得
	@Override
	public MUser getUserOne(String userId) {
		return mapper.findOne(userId);
	}

	//ユーザー1件更新
	@Transactional
	@Override
	public void updateUserOne(String userId, String password, String userName) {
		mapper.updateOne(userId, password, userName);
		//パスワード暗号化
		String encryptPassword = encoder.encode(password);
		mapper.updateOne(userId, encryptPassword, userName);
		//例外を発生させるテスト用
		//		int i = 1 / 0;

	}

	//ユーザー1件削除
	@Override
	public void deleteUserOne(String userId) {
		int count = mapper.deleteOne(userId);
	}

	//ログインユーザー情報取得
	@Override
	public MUser getLoginUser(String userId) {
		return mapper.findLoginUser(userId);
	}
}