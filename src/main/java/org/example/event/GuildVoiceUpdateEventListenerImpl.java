package org.example.event;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.common.CommonUtils;
import org.example.common.MemberIOStatus;

@Slf4j
public class GuildVoiceUpdateEventListenerImpl extends ListenerAdapter {

    private final TextChannel textChannel;

    public GuildVoiceUpdateEventListenerImpl(TextChannel textChannel) {
        this.textChannel = textChannel;
    }

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        if (event.getChannelJoined() != null) {
            CommonUtils.sendJoinVoiceChannelMessage(event.getEntity(), MemberIOStatus.IN, event.getChannelJoined(), textChannel);
        } else if (event.getChannelLeft() != null) {
            CommonUtils.sendJoinVoiceChannelMessage(event.getEntity(), MemberIOStatus.OUT, event.getChannelLeft(), textChannel);
        }
    }

}
