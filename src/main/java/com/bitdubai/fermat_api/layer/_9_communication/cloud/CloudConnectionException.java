package com.bitdubai.fermat_api.layer._9_communication.cloud;

import java.io.IOException;

import com.bitdubai.fermat_api.layer._9_communication.CommunicationException;


/**
 * Created by jorgeejgonzalez
 */
public class CloudConnectionException extends CommunicationException {

	public CloudConnectionException(){
		super();
	}

	public CloudConnectionException(final String message){
		super(message);
	}

}
