package me.zipestudio.mts.entrypoint;

import net.fabricmc.api.ClientModInitializer;
import me.zipestudio.mts.MTSClient;

public class MossyClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		MTSClient.onInitializeClient();
	}
}