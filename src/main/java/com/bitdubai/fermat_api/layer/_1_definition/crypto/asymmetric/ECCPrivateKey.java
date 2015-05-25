package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;
import java.security.spec.ECParameterSpec;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECCurve;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPrivateKey;


@SuppressWarnings("serial")
public class ECCPrivateKey implements ECPrivateKey {

	private static final String ECC_ALGORITHM = "ECIES";

	private final BigInteger s;
	private final ECCurve curve;

	public ECCPrivateKey(final BigInteger s){
		this.s = s;
		curve = ECCCurve.getSecP256K1();	
	}

	/*
	 *	implementation of ECPrivateKey interface
	 */ 
	@Override
	public BigInteger getS(){
		return s;
	}

	/*
	 *	implementation of ECKey interface
	 */ 
	@Override
	public ECParameterSpec getParams(){
		return curve.getParams();
	}

	/*
	 *	implementation of PrivateKey interface
	 */
	@Override
	public String getAlgorithm() {
		return ECC_ALGORITHM;
	}
	
	@Override
	public byte[] getEncoded() {
		return s.toByteArray();
	}

	@Override
	public String getFormat() {
		return null;
	}

	@Override
	public String toHexString() {
		return s.toString(16);
	}
	
	@Override
	public String toString() {
		return toHexString();
	}

}
