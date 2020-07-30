package com.teamfive.payment.web.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SendEmailDto {
	private final String buyer_email;
	private final String product;

}
