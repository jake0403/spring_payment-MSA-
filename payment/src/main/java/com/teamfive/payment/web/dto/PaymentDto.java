package com.teamfive.payment.web.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PaymentDto {
	
	private final Long customer_id;
	private final String order_id;
	private final int order_amount;
	private final LocalDateTime order_approved_at;
	private final String order_method;
	private final String buyer_name;
	private final String buyer_email;
	private final int buyer_tel;
	private final String company_name;
	private final String product;

}
