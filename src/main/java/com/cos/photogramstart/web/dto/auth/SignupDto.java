package com.cos.photogramstart.web.dto.auth;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

//DTO: DATA Transfer Object : 통신할떄 필요한 데이터를 담아두는 오브젝트

@Data // Getter, Setter 만드는 어노테이션
public class SignupDto {
	//https://bamdule.tistory.com/35(@Valid 어노테이션 종류)
	@Size(min =2, max=20)
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	@NotBlank
	private String name;
	
	public User toEntitiy() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
}
