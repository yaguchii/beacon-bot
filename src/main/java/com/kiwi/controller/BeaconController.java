package com.kiwi.controller;

import com.kiwi.util.MessagingUtil;
import com.linecorp.bot.model.event.BeaconEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
class BeaconController {

    @Autowired
    private MessagingUtil messagingUtil;

    private static final String HWID = "010a15a01a";

    void eventHandle(BeaconEvent event) throws Exception {

        if (event.getBeacon().getHwid().equals(HWID)) {
            if (event.getBeacon().getType().equals("enter")) {
                // enter
                messagingUtil.replyText(event.getReplyToken(), "おかえりなさい。");
            }
            if (event.getBeacon().getType().equals("leave")) {
                // leave
                messagingUtil.replyText(event.getReplyToken(), "いってらっしゃい。");
            }
        }
    }
}
