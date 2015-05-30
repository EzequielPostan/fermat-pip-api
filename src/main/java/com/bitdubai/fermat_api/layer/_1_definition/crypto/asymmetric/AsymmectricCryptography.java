package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.PrivateKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.PublicKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.Signature;
import com.bitdubai.fermat_api.layer._1_definition.crypto.util.RandomBigIntegerGenerator;

public class AsymmectricCryptography {
	
	public static String createMessageSignature(final String messageHash, final String hexPrivateKey){
		PrivateKey privateKey = new AsymmetricPrivateKey(new BigInteger(hexPrivateKey,16));
		BigInteger message = new BigInteger(messageHash, 16);
		RandomBigIntegerGenerator randomizer = new RandomBigIntegerGenerator();
		Signature signature = new AsymmetricSignature(privateKey, message, randomizer.generateRandom());
		return signature.toString();
	}
	
	public static boolean verifyMessageSignature(final String signature, final String encryptedMessage, final String hexPublicKey){
		Signature ecSignature = new AsymmetricSignature(signature);
		BigInteger messageHash = new BigInteger(encryptedMessage, 16);
		PublicKey publicKey = new AsymmetricPublicKey(hexPublicKey);
		return ecSignature.verifyMessageSignature(messageHash, publicKey);			
	}
	
	public static String encryptMessagePublicKey(final String plainMessage, final String hexPublicKey){
		AsymmetricCipher cipher = new AsymmetricCipher();
		AsymmetricPublicKey publicKey = new AsymmetricPublicKey(hexPublicKey);
		return cipher.encryptWithPublicKey(plainMessage, publicKey);
	}
	
	public static String decryptMessagePrivateKey(final String encryptedMessage, final String hexPrivateKey){
		AsymmetricCipher cipher = new AsymmetricCipher();
		AsymmetricPrivateKey privateKey = new AsymmetricPrivateKey(new BigInteger(hexPrivateKey,16));
		return cipher.decryptWithPrivateKey(encryptedMessage, privateKey);
	}
	
	public static String createPrivateKey(){
		AsymmetricKeyCreator keyCreator = new AsymmetricKeyCreator();
		return keyCreator.createPrivateKey().toString();		
	}
	
	public static String derivePublicKey(final String hexPrivateKey){
		AsymmetricPrivateKey privateKey = new AsymmetricPrivateKey(new BigInteger(hexPrivateKey, 16));
		AsymmetricKeyCreator keyCreator = new AsymmetricKeyCreator();
		return keyCreator.createPublicKey(privateKey).toString();
	}
	
}
