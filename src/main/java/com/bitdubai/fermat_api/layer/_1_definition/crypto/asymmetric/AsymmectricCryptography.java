package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPrivateKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPublicKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECSignature;
import com.bitdubai.fermat_api.layer._1_definition.crypto.util.RandomBigIntegerGenerator;

public class AsymmectricCryptography {
	
	public static String createMessageSignature(final String messageHash, final String hexPrivateKey){
		ECPrivateKey privateKey = new ECCPrivateKey(new BigInteger(hexPrivateKey,16));
		BigInteger message = new BigInteger(messageHash, 16);
		RandomBigIntegerGenerator randomizer = new RandomBigIntegerGenerator();
		ECSignature signature = new ECCSignature(privateKey, message, randomizer.generateRandom());
		return signature.toString();
	}
	
	public static boolean verifyMessageSignature(final String signature, final String encryptedMessage, final String hexPublicKey){
		ECSignature ecSignature = new ECCSignature(signature);
		BigInteger messageHash = new BigInteger(encryptedMessage, 16);
		ECPublicKey publicKey = new ECCPublicKey(hexPublicKey);
		return ecSignature.verifyMessageSignature(messageHash, publicKey);			
	}
	
	public static String encryptMessagePublicKey(final String plainMessage, final String hexPublicKey){
		ECCCipher cipher = new ECCCipher();
		ECCPublicKey publicKey = new ECCPublicKey(hexPublicKey);
		return cipher.encryptWithPublicKey(plainMessage, publicKey);
	}
	
	public static String decryptMessagePrivateKey(final String encryptedMessage, final String hexPrivateKey){
		ECCCipher cipher = new ECCCipher();
		ECCPrivateKey privateKey = new ECCPrivateKey(new BigInteger(hexPrivateKey,16));
		return cipher.decryptWithPrivateKey(encryptedMessage, privateKey);
	}
	
	public static String createPrivateKey(){
		ECCKeyCreator keyCreator = new ECCKeyCreator();
		return keyCreator.createPrivateKey().toString();		
	}
	
	public static String derivePublicKey(final String hexPrivateKey){
		ECCPrivateKey privateKey = new ECCPrivateKey(new BigInteger(hexPrivateKey, 16));
		ECCKeyCreator keyCreator = new ECCKeyCreator();
		return keyCreator.createPublicKey(privateKey).toString();
	}
	
}
