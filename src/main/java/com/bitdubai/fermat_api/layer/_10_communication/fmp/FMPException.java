package com.bitdubai.fermat_api.layer._10_communication.fmp;

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
