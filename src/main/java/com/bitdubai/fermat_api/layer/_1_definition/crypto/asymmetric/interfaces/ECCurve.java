package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces;

import java.math.BigInteger;
import java.security.spec.ECParameterSpec;

public interface ECCurve {
	public BigInteger getA();
	public BigInteger getB();	
	public ECPoint getG();
	public int getH();
	public BigInteger getN();
	public BigInteger getP();
	public ECParameterSpec getParams();	
}
