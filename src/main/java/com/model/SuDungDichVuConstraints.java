package com.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public interface SuDungDichVuConstraints {
	
	@NotNull(message = "Ngày sử dụng không được để trống")
	@PastOrPresent(message = "Ngày sử dụng phải là ngày hiện tại hoặc trước đó")
	LocalDate getNgaysudung();

	@NotNull(message = "Giờ sử dụng không được để trống")
	LocalTime getGiosudung();
	
	@Positive(message = "Số lượng phải là số nguyên dương")
	int getSoluong();
	
}
