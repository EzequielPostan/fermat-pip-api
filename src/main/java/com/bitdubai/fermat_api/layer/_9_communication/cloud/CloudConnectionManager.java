package com.bitdubai.fermat_api.layer._9_communication.cloud;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/*
 *	created by jorgeejgonzalez
 */
public interface CloudConnectionManager extends ConnectionAgent {
	public void iterateSelectedKeys(final Selector selector) throws CloudConnectionException;
	public void acceptKey(final SelectionKey key) throws CloudConnectionException;
	public void connectToKey(final SelectionKey key) throws CloudConnectionException;
	public void readFromKey(final SelectionKey key) throws CloudConnectionException;
	public void writeToKey(final SelectionKey key) throws CloudConnectionException;
}
