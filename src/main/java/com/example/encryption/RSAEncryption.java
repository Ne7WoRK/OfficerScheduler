package com.example.encryption;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


//RSA secure implementation.
public class RSAEncryption {

	// Converting String of public key to PublicKey object.
	private PublicKey getPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		
		//PUBLIC KEY STRING
		final String publicKey = "-----BEGIN PUBLIC KEY-----\n"
				+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjqhVePrwHBsKjaRKAFBP\n"
				+ "PGrVQEd22VmqCx52mhJPdNXeiq/Tw1TNq6D+ZMyUvQ248C4qnIuFLBGqD49yYYgv\n"
				+ "DO8Uo3a3eZe52bsAeWlr3po5w0GSOkzG6IzKkmUnI1nY9Wlgwo0rJmRX4PvdJa6C\n"
				+ "tzV/nTb0aqfN/WmhoskIwNmmD56AqG65XKssYAcZWOSPN/3Da5Ev8aqbVyv8QfbS\n"
				+ "UYA5nZIsbJD5lK7ykGAwGRNImEOCUpmRC6jzzONZZavXwzk8t5wWSxPDDnpbKx1o\n"
				+ "skvwbEZC/dsto5rejFsuIOySr9pYreRqZV2pGusNNcmtAB3tuawt6NapbkkhWPVQ\n" + "wwIDAQAB\n"
				+ "-----END PUBLIC KEY-----";

		String strip = publicKey.replaceAll("\\n", "").replace("-----BEGIN PUBLIC KEY-----", "")
				.replace("-----END PUBLIC KEY-----", "");
		KeyFactory kf = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(strip));
		PublicKey key = kf.generatePublic(keySpec);

		return key;
	}

	private PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		//PRIVATE KEY STRING.
		final String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n"
				+ "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCOqFV4+vAcGwqN\n"
				+ "pEoAUE88atVAR3bZWaoLHnaaEk901d6Kr9PDVM2roP5kzJS9DbjwLiqci4UsEaoP\n"
				+ "j3JhiC8M7xSjdrd5l7nZuwB5aWvemjnDQZI6TMbojMqSZScjWdj1aWDCjSsmZFfg\n"
				+ "+90lroK3NX+dNvRqp839aaGiyQjA2aYPnoCobrlcqyxgBxlY5I83/cNrkS/xqptX\n"
				+ "K/xB9tJRgDmdkixskPmUrvKQYDAZE0iYQ4JSmZELqPPM41llq9fDOTy3nBZLE8MO\n"
				+ "elsrHWiyS/BsRkL92y2jmt6MWy4g7JKv2lit5GplXaka6w01ya0AHe25rC3o1qlu\n"
				+ "SSFY9VDDAgMBAAECggEAB6su5REARVKCz7hsLfYjPEk1632r+uUiCfT6RTAEy3AP\n"
				+ "xX7MMGznnXlLE5oXyM3rCiZBLicl4oeUj7+TU4Dhnp1fi6X/GO86E2VFEkHDhbTe\n"
				+ "tAtbU/z6mFexMAt1/iV/Tzn59JtoHWk5fCOt8K+f4T9j+8yPeQhKP3wlLz4FVXCJ\n"
				+ "OpNDCG4OWnKMKRVoSclN6lVgbWQ41g+8HRTebZzOD+Nt81Iu/NHqIJ4QFrTgHt8l\n"
				+ "ChU9kdPgQGOEvYnMSa4gKUqMzQHaXdx8Egt2Gdxgs+pZK+uErPp6qzgaqovyEjzz\n"
				+ "DLGErDX1Qu8maOjGIgrhjEaBv1edpCjsxJMWan80aQKBgQDDgS/UND0lzwsvnHym\n"
				+ "GmybkEg5w0Igi18PnGuuULxQdegfz+3ZYwY08/IaOsD6ScHePF9LyqD5ywnQf3DB\n"
				+ "AW0HMkXVpRg0ztOVVu7xA5wKhl5bZoFb5zbdUNAvHAXkxzHUwtb999tgMY6cAow8\n"
				+ "CiHJlynVpmcOLf6JRfJdFGtJtQKBgQC6zOOMSRi9lwGIYXlYx54fbQwG4G6UkxaP\n"
				+ "YEi7ocnTs4US/an4RytcwB2C5ZMWb9EFs27Poc661tZtRY+HWmfPOlrMeP+aS0j5\n"
				+ "3jyP6rjqd5GndcTcAdkqxwAHrg3iXtCFRddwGCkNC03mXDn5ASVECyN4Xild8pwu\n"
				+ "lOlVVoPblwKBgCjBX5UfJrghBzXvq1R9IbL0SvovqDNcmn6InzIBhqBHVBJ9qBmv\n"
				+ "OPYE/K1XHi+O/Kk1cLA+F3y7RNqAFqNFhtL/OeultPwdOaJiMwFvPTI8fKMVJVZh\n"
				+ "RuCwHhYUA26Dz/GIhIUBDGxrKE2BgnZprk12A7SUMduU3wEC4dlhjlQZAoGBAIfs\n"
				+ "JDrkyVrS8SuSeaCvB5CoYVLzpaL4cDb9gY7+B4TCoLcT2sSszJGdvRuM/v0Zecej\n"
				+ "K6NrgqiTQM2cCvcbQmQYew9DkAFufHhMTFcQHWOGg3aNjCPmOGYXDR+Jd9La2PHQ\n"
				+ "wxVujxhNvG49d3WHbt1XGYUxRvp0WU7PzgTpgeKbAoGBAJ5B6RPJZcnD+w4QTUK3\n"
				+ "V3Mn3st57GU0nNIvKJBMIGIzArIEkuVDUK7MhIaOEaG31NWDcLDAdkmYpCW54Ta1\n"
				+ "PG7XhX33aQhVco7Q/Goh4IKDs38m8E8G6Jmjm84itsPLFIn+z/baT9Me082KNYal\n"
				+ "ZYJLt2LucFBwpRtKOFIo6HLJ\n" 
				+ "-----END RSA PRIVATE KEY-----";

		String strip = privateKey.replaceAll("\\n", "").replace("-----BEGIN RSA PRIVATE KEY-----", "")
				.replace("-----END RSA PRIVATE KEY-----", "");
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(strip));
		PrivateKey key = kf.generatePrivate(keySpecPKCS8);

		return key;
	}

	public String encrypt(String data) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException,
			NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, IOException {

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKey());
			
		byte[] cipherText = cipher.doFinal(data.getBytes());

		return Base64.getEncoder().encodeToString(cipherText);

	}

	public String decrypt(String cipherText)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, InvalidKeySpecException, IOException {
		
		byte[] bytes = Base64.getDecoder().decode(cipherText);
		
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, getPrivateKey());

		return new String(cipher.doFinal(bytes));
	}
	
	public static void main (String[] args) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException, IOException {
		RSAEncryption rsa = new RSAEncryption();
		String cipherText = "UnaxbZWUq1ztqiisXqiyh6xV4tOvuwF6/7dyyDpvxoO1o70e4UXO/K9Q6btL2CmtlTIuOw3ogv+DjFZkraU5YxWmWy+OPXZ1CB+KrxNoGAI3HeECRLoO3ya0IMB2Yb1oX2JOzVOwdED1Yl8AVTGbLr4HqlzROQS6ka7lksks39FtYZJBd/F3qO9bl6Ry/mqQX6fWpkYdBfjTxDqv+anZaTTSufaaXkY+ZLjJYEfJJuawit8v+bUEYbwf6hKHpFd37JQGnNBFPRliykkErDsMfg5FJiLWx+0mAMHYwu/s6N4dEF4I7xQyK4ygnHQ/Vb5uEiBx1kcYmv68GUlbDdQncw==";
		System.out.println("Decryption value: " + rsa.decrypt(cipherText));
	}

}
