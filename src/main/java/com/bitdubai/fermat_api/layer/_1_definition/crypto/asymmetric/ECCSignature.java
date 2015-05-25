package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECCurve;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPoint;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPrivateKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPublicKey;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECSignature;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.util.ECMath;

public class ECCSignature implements ECSignature {

	private static final ECCurve SECP256K1 = ECCCurve.getSecP256K1();
	
	private final BigInteger r;
	private final BigInteger s;	

	
	public ECCSignature(final ECPrivateKey privateKey, final BigInteger messageHash, final BigInteger randomNumber){
		r = calculateR(randomNumber);
		s = calculateS(privateKey, messageHash, randomNumber);
	}

	public ECCSignature(final BigInteger r, final BigInteger s){
		this.r = r;
		this.s = s;
	}
	
	public ECCSignature(final String signature){
		String[] values = signature.split(ECSIGNATURE_SEPARATOR);
		this.r = new BigInteger(values[0], 16);
		this.s = new BigInteger(values[1], 16);
	}
	
	@Override
	public BigInteger getR() {
		return r;
	}

	@Override
	public BigInteger getS() {
		return s;
	}

	@Override
	public boolean verifyMessageSignature(final BigInteger messageHash, final ECPublicKey publicKey){		
		BigInteger w = ECMath.modinv(s, SECP256K1.getN());
		ECPoint p1 = ECMath.multiplyPointScalar(SECP256K1.getG(), messageHash.multiply(w).mod(SECP256K1.getN()), SECP256K1);
		ECPoint p2 = ECMath.multiplyPointScalar(publicKey, r.multiply(w).mod(SECP256K1.getN()), SECP256K1);
		ECPoint p3 = ECMath.addPoint(p1, p2, SECP256K1);
		return r.equals(p3.getX()); 
	}

	@Override
	public String toString(){
		return r.toString(16) + ECSIGNATURE_SEPARATOR + s.toString(16);
	}


	private BigInteger calculateR(final BigInteger randomNumber){
		ECPoint randomPoint = ECMath.multiplyPointScalar(SECP256K1.getG(), randomNumber, SECP256K1);
		return randomPoint.getX().mod(SECP256K1.getN());
	}

	private BigInteger calculateS(final ECPrivateKey privateKey, final BigInteger messageHash, final BigInteger randomNumber){
		BigInteger value = messageHash.add(r.multiply(privateKey.getS()));
		value = value.multiply(ECMath.modinv(randomNumber, SECP256K1.getN()));
		value = value.mod(SECP256K1.getN());
		return value;
	}

}
