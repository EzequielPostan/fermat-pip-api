package com.bitdubai.fermat_api.layer._10_communication.cloud;

import java.net.InetSocketAddress;

import com.bitdubai.fermat_api.layer._10_communication.CommunicationChannelAddress;

/**
 * Created by jorgeejgonzalez
 */
public interface CloudConnectionAddress extends CommunicationChannelAddress {

	public InetSocketAddress getSocketAddress();	

}
