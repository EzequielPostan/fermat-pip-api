package test.unit.com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

public class DecryptMessagePrivateKey extends AsymmetricCryptographyUnitTest {

	@Test
	public void DecryptMessagePrivateKey_ValidParameters_NotNull() {
		assertNotNull(AsymmectricCryptography.decryptMessagePrivateKey(testEncryptedMessage, testPrivateKey));
	}
	
	@Test
	public void DecryptMessagePrivateKey_ValidParameters_ReturnsPlainMessage() {
		String decryptedMessage = AsymmectricCryptography.decryptMessagePrivateKey(testEncryptedMessage, testPrivateKey);
		assertEquals(testPlainMessage, decryptedMessage);		
	}

}
