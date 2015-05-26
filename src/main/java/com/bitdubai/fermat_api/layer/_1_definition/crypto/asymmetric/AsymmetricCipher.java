package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.ECPrivateKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.jce.interfaces.ECKey;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.JCEECPrivateKey;
import org.bouncycastle.jce.provider.JCEECPublicKey;
import org.bouncycastle.util.encoders.Hex;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.PrivateKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.PublicKey;

//TODO Solve the Illegal Key Size Restriction
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

	public String encryptWithPublicKey(final String message, final PublicKey publicKey) {
		String encrypted = null;
		try{
			byte[] messageBytes = message.getBytes(Charset.forName("UTF-8"));
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			ECPublicKey ecPublicKey = new JCEECPublicKey(publicKey);
			cipher.init(Cipher.ENCRYPT_MODE, ecPublicKey, randomizer);
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
			System.out.println(Cipher.getMaxAllowedKeyLength(CIPHER_ALGORITHM));
			ECPrivateKey ecPrivateKey = new JCEECPrivateKey(privateKey);
			cipher.init(Cipher.DECRYPT_MODE, ecPrivateKey, randomizer);
			byte[] decryptedBytes = cipher.doFinal(encryptedBytes, 0, encryptedBytes.length);
			decrypted = new String(decryptedBytes, Charset.forName("UTF-8"));
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return decrypted;
	}

}
