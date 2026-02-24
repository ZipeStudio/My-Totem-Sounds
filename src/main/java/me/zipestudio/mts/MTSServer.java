package me.zipestudio.mts;

import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.*;

public class MTSServer {

	public static final String MOD_NAME = /*$ mod_name*/ "My Totem Sounds";
	public static final String MOD_ID = /*$ mod_id*/ "my-totem-sounds";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static ResourceLocation id(String path) {
		//? if >=1.21 {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
		//?} else {
		/*return ResourceLocation.tryBuild(MOD_ID, path);
		 *///?}
	}

	public static MutableComponent text(String path, Object... args) {
		return Component.translatable(String.format("%s.%s", MOD_ID, path), args);
	}

	public static void onInitialize() {
		LOGGER.info("{} Initialized", MOD_NAME);
	}

}