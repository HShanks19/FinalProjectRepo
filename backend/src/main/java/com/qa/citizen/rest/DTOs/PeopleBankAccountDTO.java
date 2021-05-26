package com.qa.citizen.rest.DTOs;

import java.util.Set;

public class PeopleBankAccountDTO {

	public PeopleBankAccountDTO(Set<BankcardDTO> bankcardDTOs, String bank, Long accountNumber, String forenames,
			String surname) {
		super();
		this.bankcardDTOs = bankcardDTOs;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.forenames = forenames;
		this.surname = surname;
	}

	public PeopleBankAccountDTO(String bank, Long accountNumber, String forenames, String surname) {
		super();
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.forenames = forenames;
		this.surname = surname;
	}

	public PeopleBankAccountDTO() {
		super();
	}

	private Set<BankcardDTO> bankcardDTOs;

	private String bank;

	private Long accountNumber;

	private String forenames;

	private String surname;

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<BankcardDTO> getBankcardDTOs() {
		return bankcardDTOs;
	}

	public void setBankcardDTOs(Set<BankcardDTO> bankcardDTOs) {
		this.bankcardDTOs = bankcardDTOs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((bankcardDTOs == null) ? 0 : bankcardDTOs.hashCode());
		result = prime * result + ((forenames == null) ? 0 : forenames.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		PeopleBankAccountDTO other = (PeopleBankAccountDTO) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (bankcardDTOs == null) {
			if (other.bankcardDTOs != null)
				return false;
		} else if (!bankcardDTOs.equals(other.bankcardDTOs))
			return false;
		if (forenames == null) {
			if (other.forenames != null)
				return false;
		} else if (!forenames.equals(other.forenames))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PeopleBankAccountDTO [bankcardDTOs=" + bankcardDTOs + ", bank=" + bank + ", accountNumber="
				+ accountNumber + ", forenames=" + forenames + ", surname=" + surname + "]";
	}

}
