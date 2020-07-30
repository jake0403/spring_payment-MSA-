package com.teamfive.payment.web.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.teamfive.payment.domain.PaymentEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentSaveRequestDto {
	private int orderAmount;
	private int buyerTel;
	private Date orderApprovedAt;
	private String orderMethod;
	private String buyerName;
	private String buyerEmail;
	private String orderId;
	private String companyName;
	private String product;
	
	@Builder
	public PaymentSaveRequestDto(int orderAmount,
			int buyerTel, Date orderApprovedAt, String orderMethod,
			String buyerName, String buyerEmail, String orderId, String companyName, String product) {
		this.orderAmount = orderAmount;
		this.buyerTel = buyerTel;
		this.orderApprovedAt = orderApprovedAt;
		this.orderMethod = orderMethod;
		this.buyerName = buyerName;
		this.buyerEmail = buyerEmail;
		this.orderId = orderId;
		this.companyName = companyName;
		this.product = product;
	}
	
	public PaymentEntity toEntity() {
		return PaymentEntity.builder()
				.orderAmount(orderAmount)
				.buyerTel(buyerTel)
				.orderApprovedAt(orderApprovedAt)
				.orderMethod(orderMethod)
				.buyerName(buyerName)
				.buyerEmail(buyerEmail)
				.orderId(orderId)
				.companyName(companyName)
				.product(product)
				.build();
	}
}
