package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MobileCallRecords {

	public MobileCallRecords(String callerMSISDN, Long callCellTowerId, String receiverMSISDN, Long receiverTowerId) {
		super();
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverTowerId = receiverTowerId;
	}

	public MobileCallRecords(String timestamp, String callerMSISDN, Long callCellTowerId, String receiverMSISDN,
			Long receiverTowerId) {
		super();
		this.timestamp = timestamp;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverTowerId = receiverTowerId;
	}

	public MobileCallRecords() {
		super();
	}
	
	@Id
	@Column(name = "timestamp")
	private String timestamp;
		
	@ManyToOne
	@JoinColumn(name="caller_MSISDN", nullable=false)
	private PeopleMobile callerMSISDN;
		
	@Column(name = "call_cell_tower_id")
	private Long callCellTowerId;
	
	@Column(name = "receiver_MSISDN")
	private String receiverMSISDN;
	
	@Column(name = "receiver_tower_id")
	private Long receiverTowerId;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getCallCellTowerId() {
		return callCellTowerId;
	}

	public void setCallCellTowerId(Long callCellTowerId) {
		this.callCellTowerId = callCellTowerId;
	}

	public String getReceiverMSISDN() {
		return receiverMSISDN;
	}

	public void setReceiverMSISDN(String receiverMSISDN) {
		this.receiverMSISDN = receiverMSISDN;
	}

	public Long getReceiverTowerId() {
		return receiverTowerId;
	}

	public void setReceiverTowerId(Long receiverTowerId) {
		this.receiverTowerId = receiverTowerId;
	}

	public PeopleMobile getCallerMSISDN() {
		return callerMSISDN;
	}

	public void setCallerMSISDN(PeopleMobile callerMSISDN) {
		this.callerMSISDN = callerMSISDN;
	}


}
