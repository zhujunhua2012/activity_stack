package com.junhua.app1

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.Arrays

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel(this)
    }

    private fun createNotificationChannel(context: Context) {
        Log.d("zjh", "#createNotificationChannel...");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                getChannelId(context),
                "notification name",
                NotificationManager.IMPORTANCE_HIGH
            );
            channel.enableLights(true);
            channel.setLightColor(Color.WHITE);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            channel.enableVibration(true);
            channel.setDescription("channel description");
            // todo
            val channelAudioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION_COMMUNICATION_INSTANT)
//                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build();
            val channelSound = Uri.parse(
                ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.packageName
                    + "/raw/notice_04_tararan");
//            channel.setSound(channelSound, channelAudioAttributes);

            // variant of channel, notice sound is different
            val noticeSounds = arrayOf(
                "notice sound 0", "notice sound 1", "notice sound 2", "notice sound 3", "notice sound 4")
//            String[] noticeSounds = context.getResources().getStringArray(R.array.chat_notice_sound);
//            NotificationChannel noticeSoundTararanChannel =
//                    buildNoticeSoundChannel(context, ChatNoticeSoundType.TARARAN, noticeSounds[4], "notice_04_tararan");
//            NotificationChannel noticeSoundPowaChannel =
//                    buildNoticeSoundChannel(context, ChatNoticeSoundType.POWA, noticeSounds[1], "notice_04_tararan");

            val noticeSoundPowaChannel = buildNoticeSoundChannel(context, 1, noticeSounds[1], "notice_01_powa")
            val noticeSoundTurinChannel = buildNoticeSoundChannel(context, 2, noticeSounds[2], "notice_02_turin")
            val noticeSoundTeenChannel = buildNoticeSoundChannel(context, 3, noticeSounds[3], "notice_03_teen")
            val noticeSoundTararanChannel = buildNoticeSoundChannel(context, 4, noticeSounds[4], "notice_04_tararan")

            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannels(
                Arrays.asList(channel,
                    noticeSoundPowaChannel,
                    noticeSoundTurinChannel,
                    noticeSoundTeenChannel,
                    noticeSoundTararanChannel))

            manager.notificationChannels.forEach {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    Log.d("zjh", "#createNotificationChannel, channelId " + it.id
                            + ", parentChannelId " + it.parentChannelId
                            + ", channelName " + it.name
                            + ", channelGroup " + it.group
                            + ", conversationId " + it.conversationId
                            + ", hasUserSetSound " + it.hasUserSetSound()
                            + ", sound " + it.sound
                    )
                } else {
                    Log.d("zjh", "#createNotificationChannel, channelId " + it.id
                            + ", channelName " + it.name
                            + ", channelGroup " + it.group
                            + ", sound " + it.sound
                    );
                }
            }
        }
    }

    fun getChannelId(context: Context): String? {
        return context.packageName
//        return context.getPackageName() + ".default";
    }

    fun getChannelIdOfSound(context: Context, soundType: Int): String? {
//        String channelId = switch (soundType) {
//            case DEFAULT -> ".default-1";
//            case POWA -> ".music-1";
//            case TURIN -> ".sound-1";
//            case TEEN -> ".teen-1";
//            case TARARAN -> ".taran-1";
//        };
//        channelId = context.getPackageName() + channelId;
//        String channelId = context.getPackageName() + ".sound-1-" + soundType;

        // todo package-name + ".sound-1", works fine on xiaomi !!!
        // todo package-name + ".sound-2", failed to work on xiaomi
        // todo package-name + ".soul-1", failed to work on xiaomi
        // todo package-name + ".notify-sound-1", failed to work on xiaomi
        // todo
//        String channelId = context.getPackageName() + "." + soundType.name().toLowerCase();
        // powa
//        String channelId = context.getPackageName() + ".sound-" + soundType.value();
        val channelId = context.packageName + ".sound-" + soundType
        // none
//        String channelId = context.getPackageName() + "." + soundType.name() + "." + soundType.value();
//        String channelId = context.getPackageName() + "-sound-" + soundType.value();
//        String channelId = context.getPackageName() + ".sound_" + soundType.value();
//        String channelId = context.getPackageName() + ".sound-" + soundType;
//        String channelId = context.getPackageName() + "." + soundType;
//        String channelId = context.getPackageName() + "." + soundType.name();
//        String channelId = context.getPackageName() + "." + soundType.value();
//        String channelId = "sound-" + soundType.value();
//        String channelId = soundType.name();
        Log.d("zjh", "#getChannelIdOfSound, channelId $channelId, soundType $soundType")
        return channelId
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun buildNoticeSoundChannel(
        context: Context, soundType: Int, nameSuffix: String, rawResFileName: String
    ): NotificationChannel? {
        val noticeSoundChannel = NotificationChannel(
            getChannelIdOfSound(context, soundType),
            "channelName-$nameSuffix",
            NotificationManager.IMPORTANCE_HIGH
        )
        noticeSoundChannel.enableLights(true)
        noticeSoundChannel.lightColor = Color.WHITE
        noticeSoundChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        noticeSoundChannel.enableVibration(true)
        noticeSoundChannel.description = "channelDescription-$nameSuffix"
        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION) //                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            //                .setUsage(AudioAttributes.USAGE_NOTIFICATION_COMMUNICATION_INSTANT)
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()
        val sound = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.packageName
                    + "/raw/" + rawResFileName
        )
        noticeSoundChannel.setSound(sound, audioAttributes)
        return noticeSoundChannel
    }

}