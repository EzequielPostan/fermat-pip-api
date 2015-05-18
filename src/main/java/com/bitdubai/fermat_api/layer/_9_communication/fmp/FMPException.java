package com.bitdubai.fermat_api.layer._9_communication.fmp;

import com.bitdubai.fermat_api.layer._9_communication.CommunicationException;

/*
 * Fermat Messaging Protocol
 * Created by jorgeejgonzalez 
 */
public abstract class FMPException extends Exception {

	public FMPException(){
		super();
	}

	public FMPException(final String message){
		super(message);
	}

}
