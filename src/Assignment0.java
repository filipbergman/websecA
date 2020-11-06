import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.digest.DigestUtils;


public class Assignment0 {
	public static void main(String args[]) {
		// Question 1
		String a = "0123456789abcdef";
		byte[] bytes = a.getBytes(); // Convert String to byte array
		//System.out.println(bytes[0]);
		ByteBuffer bbString = ByteBuffer.wrap(a.getBytes()); // 32 / 8 = 4
		
		String v = new String(bbString.array());
		
//		int decimal = Integer.parseInt(a,16);
//		System.out.println("getInt: " + decimal);
		
		
//		StringBuilder sb = new StringBuilder();
//		for(byte b : bbString.array()) {
//			sb.append(String.format("%02x", b));
//			System.out.format("0x%x ", b);
//		}
//		System.out.println("\nSB: " + sb.toString());
		
		// Question 2
		String hashedValue = DigestUtils.sha1Hex(v);
		byte[] newBytes = hashedValue.getBytes(StandardCharsets.UTF_8);
		final int integerOfHash = new BigInteger(newBytes).intValue();
		System.out.println(integerOfHash);
		
		// Question 3
		int x = 2897;
		ByteBuffer bbInt = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE); // 32 / 8 = 4
	    //bb.order(ByteOrder.LITTLE_ENDIAN); leaving this out makes it big endian
		bbInt.putInt(x);
		for(byte b : bbInt.array()) {
			System.out.format("0x%x ", b);
		}
		
		// Question 4
		String hashedInteger = DigestUtils.sha1Hex(bbInt.array());
		System.out.println("\n" + hashedInteger);
		
	}
}
