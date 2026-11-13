package me.zipestudio.mytotemsounds.client;

import me.zipestudio.mytotemsounds.MyTotemSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTotemSoundsClient {

	public static final Logger LOGGER = LoggerFactory.getLogger(MyTotemSounds.MOD_NAME + "/Client");

	public static void onInitializeClient() {
		LOGGER.info("{} Client Initialized", MyTotemSounds.MOD_NAME);
	}

}