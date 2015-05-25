package test.unit.com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

public class CreatePrivateKeyTest extends AsymmetricCryptographyUnitTest {

	@Test
	public void CreatePrivateKey_Default_NotNull() {
		assertNotNull(AsymmectricCryptography.createPrivateKey());
	}
	
	@Test
	public void CreatePrivateKey_Default_BigIntegerValue(){		
		BigInteger privateKey = new BigInteger(AsymmectricCryptography.createPrivateKey(),16);
		assertNotNull(privateKey);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=NumberFormatException.class)
	public void CreatePrivateKey_Default_BigIntegerIsHexValue(){		
		BigInteger privateKey = new BigInteger(AsymmectricCryptography.createPrivateKey());		
	}
	
	@Test
	public void CreatePrivateKey_Repeated_ValuesNotEquals(){		
		BigInteger privateKey1 = new BigInteger(AsymmectricCryptography.createPrivateKey(),16);
		BigInteger privateKey2 = new BigInteger(AsymmectricCryptography.createPrivateKey(),16);
		assertNotEquals(privateKey1, privateKey2);
	}

}
