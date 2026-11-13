package me.zipestudio.mytotemsounds.entrypoint;

//? if fabric {
import me.zipestudio.mytotemsounds.client.MyTotemSoundsClient;
import me.zipestudio.mytotemsounds.reload.MTSReloadListeners;

import net.fabricmc.api.ClientModInitializer;

public class ClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		MyTotemSoundsClient.onInitializeClient();
		MTSReloadListeners.register();
	}

}
//?} elif neoforge {
/*import me.zipestudio.mytotemsounds.client.MyTotemSoundsClient;
import me.zipestudio.mytotemsounds.MyTotemSounds;
import me.zipestudio.mytotemsounds.reload.MTSReloadListeners;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = MyTotemSounds.MOD_ID, dist = Dist.CLIENT)
public class ClientEntrypoint {

	public ClientEntrypoint(IEventBus modBus) {
		MyTotemSoundsClient.onInitializeClient();
		MTSReloadListeners.register(modBus);
	}

}
*///?} elif forge {
/*import me.zipestudio.mytotemsounds.client.MyTotemSoundsClient;
import me.zipestudio.mytotemsounds.reload.MTSReloadListeners;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientEntrypoint {

	public static void onInitializeClient() {
		MyTotemSoundsClient.onInitializeClient();
		MTSReloadListeners.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

}
*///?}
