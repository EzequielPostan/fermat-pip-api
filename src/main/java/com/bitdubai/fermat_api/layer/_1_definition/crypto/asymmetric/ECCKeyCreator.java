package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;
import java.security.InvalidParameterException;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECCurve;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPoint;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPrivateKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPublicKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.util.ECMath;
import com.bitdubai.fermat_api.layer._1_definition.crypto.util.Base58;
import com.bitdubai.fermat_api.layer._1_definition.crypto.util.CryptoHasher;
import com.bitdubai.fermat_api.layer._1_definition.crypto.util.RandomBigIntegerGenerator;

public class ECCKeyCreator {

	public ECCKeyCreator(){

	}
	
	public ECPrivateKey createPrivateKey(){
		return new ECCPrivateKey(new RandomBigIntegerGenerator().generateRandom());
	}

	public ECPublicKey createPublicKey(final ECPrivateKey privateKey) throws InvalidParameterException{
		ECCurve curve = ECCCurve.getSecP256K1();
		if(privateKey.getS().compareTo(BigInteger.ZERO) <= 0 || privateKey.getS().compareTo(curve.getN()) >= 0)
			throw new InvalidParameterException();
		
		ECPoint point = ECMath.multiplyPointScalar(curve.getG(), privateKey.getS(), curve);		
		return  new ECCPublicKey(point.toUncompressedString());
	}

	/*
	 *	Address generation following the procedure described in https://en.bitcoin.it/wiki/Technical_background_of_Bitcoin_addresses
	 */
	public String createPublicAddress(final ECCPublicKey publicKey) throws InvalidParameterException{
		if(publicKey == null)
			throw new InvalidParameterException();
		//1: uncompressed public key
		String publicAddress = publicKey.toUncompressedString();
		//2: sha-256
		publicAddress = CryptoHasher.performSha256(new BigInteger(publicAddress,16));
		//3: ripemd-160
		publicAddress = CryptoHasher.performRipemd160(new BigInteger(publicAddress,16));
		//4: version byte 00
		publicAddress = "00" + publicAddress;
		//5: Stat checksum sha-256
		String checksum = CryptoHasher.performSha256(new BigInteger(publicAddress,16));
		//6: sha-256
		checksum = CryptoHasher.performSha256(new BigInteger(checksum,16));
		//7: first 4 bytes checksum
		checksum = checksum.substring(0,8);
		//8: checksum at end of 4
		publicAddress = publicAddress + checksum;
		//9: base58 string encoding
		publicAddress = Base58.encode(publicAddress);

		return publicAddress;
	}
}
