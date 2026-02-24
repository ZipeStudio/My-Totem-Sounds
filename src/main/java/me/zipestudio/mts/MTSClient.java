package me.zipestudio.mts;

import me.zipestudio.mts.client.TotemSoundManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MTSClient {

	public static final Logger LOGGER = LoggerFactory.getLogger(MTSServer.MOD_NAME + "/Client");

	public static void onInitializeClient() {

		LOGGER.info("{} Client Initialized", MTSServer.MOD_NAME);
		TotemSoundManager.init();

	}

}