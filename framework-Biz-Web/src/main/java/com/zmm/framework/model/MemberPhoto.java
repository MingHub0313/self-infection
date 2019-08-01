package com.zmm.framework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @Name MemberPhoto
 * @Author 900045
 * @Created by 2019/8/1 0001
 */
@ApiModel
@SuppressWarnings("serial")
public class MemberPhoto implements Serializable {


	@ApiParam(name = "会员编号")
	private Long memberId;
	@ApiParam(name = "头像数据", required = true)
	private MultipartFile dataFile;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public MultipartFile getDataFile() {
		return dataFile;
	}

	public void setDataFile(MultipartFile dataFile) {
		this.dataFile = dataFile;
	}
}
