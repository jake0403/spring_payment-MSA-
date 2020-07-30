package com.teamfive.payment.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamfive.payment.service.PaymentService;
import com.teamfive.payment.web.dto.PaymentSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PaymentApiController {
	
	private final PaymentService paymentService;
	
	@CrossOrigin("*")
	@PostMapping("/api/v1/payments")
	public Long save(@RequestBody PaymentSaveRequestDto requestDto) {
		System.out.println("save...");
		return paymentService.save(requestDto);
	}
	
}
