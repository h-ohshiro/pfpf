package com.ohshiro.portfolio.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data //getter,setterを定義
@Entity //entityの認識.フィールドのtableを定義する
public class Todoentity {

	@Id //主キーを設定
	@GeneratedValue(strategy = GenerationType.IDENTITY) //主キーの値の生成方法の指定(自動採番)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "空白では登録できません。")
	@Size(max = 20, message = "20文字以内で登録してください。")
	@Column(name = "title") //テーブルに対応する変数を指定
	private String title;

	@Column(name = "done")
	private Boolean done = false;

	@Column(name = "date")
	private LocalDateTime date;

	@ManyToOne
	private Userentity user;

}
