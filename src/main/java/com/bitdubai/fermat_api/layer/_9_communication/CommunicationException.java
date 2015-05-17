package com.bitdubai.fermat_api.layer._9_communication;

import java.io.IOException;

/**
 * Created by ciencias on 31.12.14.
 */
public class CommunicationException extends IOException {
    
	public CommunicationException(){
		super();
	}

	public CommunicationException(final String message){
		super(message);
	}

}
