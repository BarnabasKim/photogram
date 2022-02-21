package com.cos.photogramstart.web.dto.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Data;

// @NotNull = null 값 체크
// NotEmpty  빈값이거나 null 체크
// NotBlank  빈값이거나 null 체크 그리고 빈(스페이스) 공백까지


@Data
public class CommentDto {
	@NotBlank // 빈값이거나 null 체크 그리고 빈 공백까지
	private String content;
	@NotNull //  null 체크
	private Integer imageId;
	
	// toEntity는 필요 없다.
}
