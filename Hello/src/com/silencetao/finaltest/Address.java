package com.silencetao.finaltest;

/**
 * final类
 * @author Silence
 *
 */
public class Address {

	private final String detail;
	private final String postCode;
	
	public Address() {
		detail = "";
		postCode = "";
	}
	
	public Address(String detail, String postCode) {
		this.detail = detail;
		this.postCode = postCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == Address.class) {
			Address address = (Address) obj;
			if (this.detail.equals(address.detail) && this.postCode.equals(address.postCode)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return detail.hashCode() + postCode.hashCode() * 31;
	}
	
	@Override
	public String toString() {
		return "detail:" + detail + "," + "postCode:" + postCode + ".";
	}
	
	public static void main(String[] args) {
		Address address = new Address("上海市", "200000");
		System.out.println(address);
	}
}
