package com.silencetao.exception;

/**
 * catch和throw一起使用
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
			throw new AuctionException("竞拍价格必须是数值，不能包含其他字符");
		}
		if (initPrice > d) {
			throw new AuctionException("竞拍价格比起拍价格低，不允许竞拍");
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
