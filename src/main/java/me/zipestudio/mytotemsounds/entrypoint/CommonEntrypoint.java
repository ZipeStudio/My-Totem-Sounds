package me.zipestudio.mytotemsounds.entrypoint;

//? if fabric {
import me.zipestudio.mytotemsounds.MyTotemSounds;

import net.fabricmc.api.ModInitializer;

public class CommonEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		MyTotemSounds.onInitialize();
	}

}
//?} elif neoforge {
/*import me.zipestudio.mytotemsounds.MyTotemSounds;

import net.neoforged.fml.common.Mod;

@Mod(MyTotemSounds.MOD_ID)
public class CommonEntrypoint {

	public CommonEntrypoint() {
		MyTotemSounds.onInitialize();
	}

}
*///?} elif forge {
/*import me.zipestudio.mytotemsounds.MyTotemSounds;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(MyTotemSounds.MOD_ID)
public class CommonEntrypoint {

	public CommonEntrypoint() {
		MyTotemSounds.onInitialize();
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientEntrypoint::onInitializeClient);
	}

}
*///?}
