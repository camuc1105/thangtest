package com.model;

import jakarta.validation.constraints.Pattern;

public interface KhachHangConstraints {
	 @Pattern(regexp = "^KH\\d{5}$", message = "Mã KH phải có định dạng KHxxxxx")
	String getMakh();
}
