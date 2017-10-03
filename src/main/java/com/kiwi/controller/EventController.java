package com.kiwi.controller;


import com.linecorp.bot.model.event.*;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@LineMessageHandler
public class EventController {

    @Autowired
    private BeaconController beaconController;

    @EventMapping
    public void eventHandle(Event event) throws Exception {

        if (event instanceof MessageEvent) {
            final MessageEvent<?> messageEvent = (MessageEvent<?>) event;

        } else if (event instanceof UnfollowEvent) {
            UnfollowEvent unfollowEvent = (UnfollowEvent) event;
            //handleUnfollowEvent(unfollowEvent);

        } else if (event instanceof FollowEvent) {
            FollowEvent followEvent = (FollowEvent) event;
            //reply(handleFollowEvent(followEvent));

        } else if (event instanceof JoinEvent) {
            final JoinEvent joinEvent = (JoinEvent) event;
            //reply(handleJoinEvent(joinEvent));

        } else if (event instanceof LeaveEvent) {
            final LeaveEvent leaveEvent = (LeaveEvent) event;
            //handleLeaveEvent(leaveEvent);

        } else if (event instanceof PostbackEvent) {
            final PostbackEvent postbackEvent = (PostbackEvent) event;

        } else if (event instanceof BeaconEvent) {
            final BeaconEvent beaconEvent = (BeaconEvent) event;
            beaconController.eventHandle(beaconEvent);
        }
    }
}
