package com.model;

import jakarta.validation.constraints.Pattern;

public interface DichVuConstraints {
	
	@Pattern(regexp = "^DV\\d{3}$", message = "Mã DV phải có định dạng DVxxx")
	String getMadv();
}
