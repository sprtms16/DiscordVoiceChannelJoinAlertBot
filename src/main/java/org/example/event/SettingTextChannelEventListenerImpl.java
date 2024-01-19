package org.example.event;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.Map;

public class SettingTextChannelEventListenerImpl extends ListenerAdapter {

    private final Map<TextChannel, ListenerAdapter> textChannelEventListener = new HashMap<>();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if ("set".equals(event.getName()) && event.getChannel().getType().isMessage()) {
            TextChannel textChannel = event.getChannel().asTextChannel();
            if(textChannelEventListener.containsKey(textChannel)) {
                event.reply("이미 알림이 등록되어있습니다.").complete();
            } else {
                textChannelEventListener.put(textChannel, new GuildVoiceUpdateEventListenerImpl(textChannel));
                event.getJDA().addEventListener(textChannelEventListener.get(textChannel));
                event.reply("이제 이 채널에서 알림이 울립니다.").complete();
            }
        } else if("unset".equals(event.getName()) && event.getChannel().getType().isMessage()) {
            TextChannel textChannel = event.getChannel().asTextChannel();
            if (textChannelEventListener.containsKey(textChannel)) {
                event.getJDA().removeEventListener(textChannelEventListener.remove(textChannel));
                event.reply("이제 이 채널에서 알림이 울리지 않습니다.").complete();
            } else {
                event.reply("이 채널에 등록된 알림이 존재하지 않습니다.").complete();
            }
        } else {
            event.deferReply().complete();
        }
    }

}
