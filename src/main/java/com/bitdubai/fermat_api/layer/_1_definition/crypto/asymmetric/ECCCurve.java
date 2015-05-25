package com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric;

import java.math.BigInteger;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECCurve;
import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.interfaces.ECPoint;

public class ECCCurve extends EllipticCurve implements ECCurve {

	private ECPoint g;
	private int h;
	private BigInteger n;
	private BigInteger p;

	public ECCCurve(ECFieldFp field, BigInteger a, BigInteger b, ECPoint g, int h, BigInteger n) {
		super(field, a, b);
		this.g = g;
		this.h = h;
		this.n = n;
		this.p = field.getP();
	}	

	public static ECCCurve getSecP256K1() { 
		return new ECCCurve.SecP256K1();
	}

	@Override
        public ECPoint getG(){
		return g;		
	}

	@Override
        public int getH(){
		return h;
	}

	@Override
        public BigInteger getN(){
		return n;
	}

	@Override
	public BigInteger getP() {
		return p;
	}

	@Override
	public ECParameterSpec getParams(){
		java.security.spec.ECPoint gPoint = new java.security.spec.ECPoint(g.getX(), g.getY());
		return new ECParameterSpec(this, gPoint, n, h);
	}

	static public class SecP256K1 extends ECCCurve {

		private static final BigInteger A = BigInteger.ZERO;
		private static final BigInteger B = new BigInteger("7",16);
		private static final ECCPoint G = new ECCPoint(new BigInteger("55066263022277343669578718895168534326250603453777594175500187360389116729240", 10), 
							new BigInteger("32670510020758816978083085130507043184471273380659243275938904335757337482424", 10));
		private static final int H = 1;
		private static final BigInteger N = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
		private static final BigInteger P = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);

		public SecP256K1(){
			super(new ECFieldFp(P), A, B, G, H, N);
		}

	}

}
