package com.qa.citizen.rest.DTOs;

public class MobileCallRecordsDTO {

	public MobileCallRecordsDTO(String timestamp, String callerMSISDN, Long callCellTowerId, String receiverMSISDN,
			String receiverName) {
		super();
		this.timestamp = timestamp;
		this.callerMSISDN = callerMSISDN;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverName = receiverName;
	}

	public MobileCallRecordsDTO(String timestamp, String callerMSISDN, Long callCellTowerId, String receiverMSISDN) {
		super();
		this.timestamp = timestamp;
		this.callerMSISDN = callerMSISDN;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
	}

	public MobileCallRecordsDTO() {
		super();
	}

	private String timestamp;

	private String callerMSISDN;

	private Long callCellTowerId;

	private String receiverMSISDN;

	private String receiverName;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCallerMSISDN() {
		return callerMSISDN;
	}

	public void setCallerMSISDN(String callerMSISDN) {
		this.callerMSISDN = callerMSISDN;
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

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((callCellTowerId == null) ? 0 : callCellTowerId.hashCode());
		result = prime * result + ((callerMSISDN == null) ? 0 : callerMSISDN.hashCode());
		result = prime * result + ((receiverMSISDN == null) ? 0 : receiverMSISDN.hashCode());
		result = prime * result + ((receiverName == null) ? 0 : receiverName.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MobileCallRecordsDTO other = (MobileCallRecordsDTO) obj;
		if (callCellTowerId == null) {
			if (other.callCellTowerId != null)
				return false;
		} else if (!callCellTowerId.equals(other.callCellTowerId))
			return false;
		if (callerMSISDN == null) {
			if (other.callerMSISDN != null)
				return false;
		} else if (!callerMSISDN.equals(other.callerMSISDN))
			return false;
		if (receiverMSISDN == null) {
			if (other.receiverMSISDN != null)
				return false;
		} else if (!receiverMSISDN.equals(other.receiverMSISDN))
			return false;
		if (receiverName == null) {
			if (other.receiverName != null)
				return false;
		} else if (!receiverName.equals(other.receiverName))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MobileCallRecordsDTO [timestamp=" + timestamp + ", callerMSISDN=" + callerMSISDN + ", callCellTowerId="
				+ callCellTowerId + ", receiverMSISDN=" + receiverMSISDN + ", receiverName=" + receiverName + "]";
	}

}
