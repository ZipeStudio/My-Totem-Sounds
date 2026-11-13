package me.zipestudio.mytotemsounds.reload;

import java.util.concurrent.Executor;

import me.zipestudio.mytotemsounds.MyTotemSounds;
import me.zipestudio.mytotemsounds.client.TotemSoundManager;
import net.minecraft.server.packs.resources.ResourceManager;

public class MTSReloadListener extends AbstractResourceReloadListener {

    @Override
    public String getModId() {
        return MyTotemSounds.MOD_ID;
    }

    @Override
    protected void reloadStuff(PreparationBarrier synchronizer, ResourceManager manager, Executor prepareExecutor, Executor applyExecutor) {
        TotemSoundManager.loadMappings(manager);
    }

}