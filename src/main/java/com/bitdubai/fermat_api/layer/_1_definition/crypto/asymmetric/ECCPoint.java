package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPoint;

public class ECCPoint extends java.security.spec.ECPoint implements ECPoint {

	private final BigInteger x;
	private final BigInteger y;
	
	public ECCPoint(final BigInteger x, final BigInteger y){
		super(x, y);
		this.x = x;
		this.y = y;
	}

	@Override
	public BigInteger getX(){
		return x;
	}

	@Override
	public BigInteger getY(){
                return y;
	}

	@Override
	public String toUncompressedString(){
		return "04"+String.format("%064X",x)+String.format("%064X",y);
	}
	
	@Override
	public String toCompressedString(){
		String prefix="";
                if(y.mod(new BigInteger("2")).equals(BigInteger.ZERO))
                        prefix = "02";
                else
                        prefix = "03";
                return prefix+String.format("%064x", x);
	}
}
