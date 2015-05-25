package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces;

import java.math.BigInteger;

public interface ECSignature {
	public static String ECSIGNATURE_SEPARATOR = " ";
	public static int ECSIGNATURE_SEPARATOR_PARTS = 2;
	public BigInteger getR();
	public BigInteger getS();
	public boolean verifyMessageSignature(final BigInteger messageHash, final ECPublicKey publicKey);
} 
