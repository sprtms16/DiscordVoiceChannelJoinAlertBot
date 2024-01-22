package kr.sprtms16.common;

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
        textChannel.sendMessageFormat("%s님 %s %s 에서 %s", member.getEffectiveName(), status.getMessage(), audioChannelUnion.getAsMention(), status.getStatusMessage()).queue();
    }
}
