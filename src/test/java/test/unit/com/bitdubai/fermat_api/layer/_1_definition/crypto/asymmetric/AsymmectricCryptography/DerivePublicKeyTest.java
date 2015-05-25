package test.unit.com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

public class DerivePublicKeyTest extends AsymmetricCryptographyUnitTest {
	
	
	@Test
	public void DerivePublicKey_ValidPrivateKey_NotNull() {
		assertNotNull(AsymmectricCryptography.derivePublicKey(testPrivateKey));		
	}
	
	@Test
	public void DerivePublicKey_ValidPrivateKey_BigIntegerValue() {
		BigInteger publicKey = new BigInteger(AsymmectricCryptography.derivePublicKey(testPrivateKey),16);
		assertNotNull(publicKey);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=NumberFormatException.class)
	public void DerivePublicKey_ValidPrivateKey_BigIntegerIsHexValue() {
		BigInteger publicKey = new BigInteger(AsymmectricCryptography.derivePublicKey(testPrivateKey));		
	}
	
	@Test
	public void DerivePublicKey_ValidPrivateKey_DerivedValue() {
		String publicKey = AsymmectricCryptography.derivePublicKey(testPrivateKey);
		assertEquals(testPublicKey, publicKey);		
	}
}
