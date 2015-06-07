/*
 * @#IncomingNetworkServiceConnectionRequestEvent.java - 2015
 * Copyright bitDubai.com., All rights reserved.
 * You may not modify, use, reproduce or distribute this software.
 * BITDUBAI/CONFIDENTIAL
 */
package com.bitdubai.fermat_api.layer._3_platform_service.event_manager.events;

import com.bitdubai.fermat_api.layer._10_communication.CommunicationChannels;
import com.bitdubai.fermat_api.layer._1_definition.event.PlatformEvent;
import com.bitdubai.fermat_api.layer._3_platform_service.event_manager.EventSource;
import com.bitdubai.fermat_api.layer._3_platform_service.event_manager.EventType;

import java.util.UUID;

/**
 * The Class <code>com.bitdubai.fermat_api.layer._3_platform_service.event_manager.events.IncomingNetworkServiceConnectionRequestEvent</code>
 * <p/>
 * Created by Roberto Requena - (rart3001@gmail.com) on 07/06/15.
 *
 * @version 1.0
 * @since Java JDK 1.7
 */
public class IncomingNetworkServiceConnectionRequestEvent implements PlatformEvent {

    private EventType eventType;

    private EventSource eventSource;

    private UUID remoteNetworkService;

    private CommunicationChannels communicationChannels;

    public IncomingNetworkServiceConnectionRequestEvent(EventType eventType){
        this.eventType = eventType;
    }

    @Override
    public EventType getEventType() {
        return this.eventType;
    }

    @Override
    public void setSource(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    @Override
    public EventSource getSource() {
        return this.eventSource;
    }

    public UUID getRemoteNetworkService() {
        return remoteNetworkService;
    }

    public CommunicationChannels getCommunicationChannels() {
        return communicationChannels;
    }
}
