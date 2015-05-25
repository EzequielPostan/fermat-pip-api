package test.unit.com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

public class VerifyMessageSignatureTest extends AsymmetricCryptographyUnitTest {

	@Test
	public void VerifyMessageSignature_ValidParameters_ReturnsTrue() {
		assertTrue(AsymmectricCryptography.verifyMessageSignature(testSignature, testEncryptedMessage, testPublicKey));
	}
	
	@Test
	public void VerifyMessageSignature_DifferentSignature_ReturnsFalse() {
		assertFalse(AsymmectricCryptography.verifyMessageSignature(testSignature+"0", testEncryptedMessage, testPublicKey));
	}
	
	@Test
	public void VerifyMessageSignature_DifferentMessage_ReturnsFalse() {
		assertFalse(AsymmectricCryptography.verifyMessageSignature(testSignature, testEncryptedMessage+"0", testPublicKey));
	}
	
	@Test
	public void VerifyMessageSignature_DifferentPublicKey_ReturnsFalse() {
		assertFalse(AsymmectricCryptography.verifyMessageSignature(testSignature, testEncryptedMessage, testPublicKey+"0"));
	}

}
