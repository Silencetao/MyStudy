package com.silencetao.exception;

/**
 * catch��throwһ��ʹ��
 * @author Silence
 *
 */
public class AuctionTest {
	private double initPrice = 30.0;
	
	public void bid(String bidPrice) throws AuctionException {
		double d = 0.0;
		try {
			d = Double.parseDouble(bidPrice);
		} catch (Exception e) {
			throw new AuctionException("���ļ۸��������ֵ�����ܰ��������ַ�");
		}
		if (initPrice > d) {
			throw new AuctionException("���ļ۸�����ļ۸�ͣ���������");
		}
		initPrice = d;
	}
	
	public static void main(String[] args) {
		AuctionTest at = new AuctionTest();
		try {
			at.bid("23");
		} catch (AuctionException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
