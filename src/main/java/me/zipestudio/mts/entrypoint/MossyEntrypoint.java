package me.zipestudio.mts.entrypoint;

import me.zipestudio.mts.MTSServer;
import net.fabricmc.api.ModInitializer;

public class MossyEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		MTSServer.onInitialize();
	}
}
