package org.example.common;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;

@Slf4j
public class CommonUtils {

    private CommonUtils() {
        log.info("CommonUtils");
    }

    public static void sendJoinVoiceChannelMessage(Member member, MemberIOStatus status, AudioChannelUnion audioChannelUnion, TextChannel textChannel) {
        textChannel.sendMessage(String.format("%s님 %s %s에서 %s", member.getEffectiveName(), status.getMessage(), audioChannelUnion.getName(), status.getStatusMessage())).queue();
    }
}
