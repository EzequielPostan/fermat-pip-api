package com.bitdubai.fermat_api.layer._10_communication.cloud;

import com.bitdubai.fermat_api.layer._10_communication.fmp.FMPPacketHandler;
import java.nio.channels.SelectionKey;

/*
 *	created by jorgeejgonzalez
 */
public interface CloudFMPConnectionManager extends CloudConnectionManager, FMPPacketHandler {

	public void processDataPacket(final String data, final SelectionKey key) throws CloudConnectionException;
	
}
