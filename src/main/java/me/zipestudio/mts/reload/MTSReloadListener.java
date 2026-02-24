package me.zipestudio.mts.reload;

import java.util.concurrent.Executor;

import me.zipestudio.mts.MTSServer;
import me.zipestudio.mts.client.TotemSoundManager;
import net.minecraft.server.packs.resources.ResourceManager;

public class MTSReloadListener extends AbstractResourceReloadListener {

    @Override
    public String getModId() {
        return MTSServer.MOD_ID;
    }

    @Override
    protected void reloadStuff(PreparationBarrier synchronizer, ResourceManager manager, Executor prepareExecutor, Executor applyExecutor) {
        TotemSoundManager.loadMappings(manager);
    }

}