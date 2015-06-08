package unit.com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bitdubai.fermat_api.layer._1_definition.crypto.asymmetric.AsymmectricCryptography;

public class CreateMessageSignatureTest extends AsymmetricCryptographyUnitTest {

	@Test
	public void CreateMessageSignature_ValidParameters_NotNull() {
		assertNotNull(AsymmectricCryptography.createMessageSignature(testEncryptedMessage, testPrivateKey));
	}
	
	@Test
	public void CreateMessageSignature_ConsecutiveSignatures_NotEquals() {
		String signature1 = AsymmectricCryptography.createMessageSignature(testEncryptedMessage, testPrivateKey);
		String signature2 = AsymmectricCryptography.createMessageSignature(testEncryptedMessage, testPrivateKey);
		assertNotEquals(signature1, signature2);		
	}	
	
}
