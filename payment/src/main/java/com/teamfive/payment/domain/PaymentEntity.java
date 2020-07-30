package com.teamfive.payment.domain;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(nullable = false)
	private int orderAmount;

	@Column(nullable = true)
	private Date orderApprovedAt;

	@Column(nullable = false)
	private String orderMethod;

	@Column(nullable = false)
	private String buyerName;

	@Column(nullable = false)
	private String buyerEmail;

	private int buyerTel;

	private String companyName;

	private String orderId;
	
	private String product;

	@Builder
	public PaymentEntity(int orderAmount, Date orderApprovedAt, String orderMethod,
			String buyerName, String buyerEmail, int buyerTel, String companyName, String orderId, String product) {
		this.orderAmount = orderAmount;
		this.orderApprovedAt = orderApprovedAt;
		this.orderMethod = orderMethod;
		this.buyerName = buyerName;
		this.buyerEmail = buyerEmail;
		this.buyerTel = buyerTel;
		this.companyName = companyName;
		this.orderId = orderId;
		this.product = product;
	}

}
