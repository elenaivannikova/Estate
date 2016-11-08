package ua.nure.ivannikova.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Password {

	private static final Logger logger = LoggerFactory.getLogger(Password.class);

	private static final String ALGORITHM = "SHA";
	private static final String CHARSET = "UTF-8";
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	/**
	 * Method for hashing information using specified {@code algorithm}.
	 * 
	 * @param input
	 *            string to hash.
	 * 
	 * @return the result of hashing representing a {@code String} of hexal
	 *         numbers (every byte matches two hexal numbers).
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String hash(String str) {
		MessageDigest digest;
		StringBuffer hexString = new StringBuffer();
		try {
			digest = MessageDigest.getInstance(ALGORITHM);
			digest.update(str.getBytes(CHARSET));
			for (byte d : digest.digest()) {
				hexString.append(getFirstHexDigit(d)).append(getSecondHexDigit(d));
			}
		} catch (NoSuchAlgorithmException e1) {
			logger.error(e1.getLocalizedMessage());
		} catch (UnsupportedEncodingException e2) {
			logger.error(e2.getLocalizedMessage());
		}
		return hexString.toString();
	}

	private static char getFirstHexDigit(byte x) {
		return HEX_DIGITS[(0xFF & x) / 16];
	}

	private static char getSecondHexDigit(byte x) {
		return HEX_DIGITS[(0xFF & x) % 16];
	}
}
