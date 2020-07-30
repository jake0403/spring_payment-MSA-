package com.teamfive.payment.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamfive.payment.domain.PaymentRepository;
import com.teamfive.payment.web.dto.PaymentSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;
	
	
	@Transactional
	public Long save(PaymentSaveRequestDto requestDto) {
		EmailSend es = new EmailSend();
		es.sendEmail(requestDto);
		
		return paymentRepository.save(requestDto.toEntity()).getCustomerId();
	}
	
	
}
