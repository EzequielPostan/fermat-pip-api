package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.PrivateKey;

public class AsymmetricCipher {

	private SecureRandom randomizer;

	private static final String CIPHER_ALGORITHM = "ECIES";
	
	public AsymmetricCipher(){
		this(new SecureRandom());
	}

	public AsymmetricCipher(SecureRandom randomizer){
		this.randomizer = randomizer;
		Security.addProvider(new BouncyCastleProvider());
	}

	public String encryptWithPublicKey(final String message, final AsymmetricPublicKey publicKey) {
		String encrypted = null;
		try{
			byte[] messageBytes = message.getBytes(Charset.forName("UTF-8"));
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey, randomizer);
			byte[] encryptedBytes = cipher.doFinal(messageBytes, 0, messageBytes.length);
			encrypted = Hex.toHexString(encryptedBytes);
		} catch(Exception ex){
			ex.printStackTrace();
		}

		return encrypted;
	}

	public String decryptWithPrivateKey(final String encryptedMessage, final PrivateKey privateKey) {
		String decrypted = null;
		try{
			BigInteger encrypted = new BigInteger(encryptedMessage, 16);
			byte[] encryptedBytes = encrypted.toByteArray();
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, privateKey, randomizer);
			byte[] decryptedBytes = cipher.doFinal(encryptedBytes, 0, encryptedBytes.length);
			decrypted = new String(decryptedBytes, Charset.forName("UTF-8"));
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return decrypted;
	}

}
