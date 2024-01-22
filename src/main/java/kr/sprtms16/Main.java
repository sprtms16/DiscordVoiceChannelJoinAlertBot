package kr.sprtms16;

import kr.sprtms16.event.SettingTextChannelEventListenerImpl;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

@Slf4j
public class Main {

    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault(args[0])
                .setStatus(OnlineStatus.ONLINE)
                .setAutoReconnect(true)
                .enableIntents(GatewayIntent.GUILD_VOICE_STATES)
                .build();

        jda.updateCommands()
                .addCommands(
                        Commands.slash("set", "메시지를 띄울 채널이 설정됩니다.")
                                .addOption(OptionType.CHANNEL, "target", "선택하고 싶은 채널을 골라주세요(미 입력시 현재 채널)"),
                        Commands.slash("unset", "메시지를 띄울 채널이 해제 합니다.")
                                .addOption(OptionType.CHANNEL, "target", "선택하고 싶은 채널을 골라주세요(미 입력시 현재 채널)")
                ).queue();
        jda.addEventListener(new SettingTextChannelEventListenerImpl());

    }
}
