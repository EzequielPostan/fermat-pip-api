package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPrivateKey;

public class ECCCipher {

	private SecureRandom randomizer;

	private static final String CIPHER_ALGORITHM = "ECIES";
	
	public ECCCipher(){
		this(new SecureRandom());
	}

	public ECCCipher(SecureRandom randomizer){
		this.randomizer = randomizer;
		Security.addProvider(new BouncyCastleProvider());
	}

	public String encryptWithPublicKey(final String message, final ECCPublicKey publicKey) {
		String encrypted = null;
		try{
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey, randomizer);
			encrypted = Hex.toHexString(cipher.doFinal(message.getBytes(), 0, message.getBytes().length));
		} catch(Exception ex){
			ex.printStackTrace();
		}

		return encrypted;
	}

	public String decryptWithPrivateKey(final String encryptedMessage, final ECPrivateKey privateKey) {
		String decrypted = null;
		try{
			BigInteger encrypted = new BigInteger(encryptedMessage, 16);
			byte[] encryptedBytes = encrypted.toByteArray();
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, privateKey, randomizer);
			decrypted = new String(cipher.doFinal(encryptedBytes, 0, encryptedBytes.length));
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return decrypted;
	}

}
