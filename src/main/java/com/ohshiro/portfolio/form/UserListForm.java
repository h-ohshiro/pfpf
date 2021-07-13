package com.ohshiro.portfolio.form;

import lombok.Data;

//画面から入力されたユーザー検索条件をもつためのクラス
@Data
public class UserListForm {
	private String userId;
	private String userName;
}
