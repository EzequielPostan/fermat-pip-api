package com.bitdubai.fermat_api.layer._10_communication.cloud;

import com.bitdubai.fermat_api.layer._10_communication.CommunicationException;


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
