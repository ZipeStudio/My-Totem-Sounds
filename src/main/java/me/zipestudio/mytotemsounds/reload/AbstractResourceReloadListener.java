package me.zipestudio.mytotemsounds.reload;

import java.util.concurrent.*;
import net.minecraft.server.packs.resources.*;
import net.minecraft.util.*;
import net.minecraft.util.profiling.*;
import net.minecraft.resources.Identifier;

public abstract class AbstractResourceReloadListener implements PreparableReloadListener {

	public Identifier getId() {
		String modId = this.getModId();
		String path = "%s-reload-listener".formatted(modId);
		//? if >=1.21 {
		return Identifier.fromNamespaceAndPath(modId, path);
		//?} else {
		/*return Identifier.tryBuild(modId, path);
		 *///?}
	}

	public abstract String getModId();

	//? if >=1.21.9 {
	@Override
	public CompletableFuture<Void> reload(SharedState store, Executor prepareExecutor, PreparationBarrier synchronizer, Executor applyExecutor) {
		return synchronizer.wait(Unit.INSTANCE).thenRunAsync(() -> {
			ProfilerFiller profiler = Profiler.get();
			profiler.push("%s-reload-listener".formatted(this.getModId()));
			this.reloadStuff(synchronizer, store.resourceManager(), prepareExecutor, applyExecutor);
			profiler.pop();
		}, applyExecutor);
	}
	//?} else {
	/*@Override
	public CompletableFuture<Void> reload(PreparationBarrier synchronizer, ResourceManager manager, ProfilerFiller profiler, ProfilerFiller applyProfiler, Executor prepareExecutor, Executor applyExecutor) {
		return synchronizer.wait(Unit.INSTANCE).thenRunAsync(() -> {
			applyProfiler.push("%s-reload-listener".formatted(this.getModId()));
			this.reloadStuff(synchronizer, manager, prepareExecutor, applyExecutor);
			applyProfiler.pop();
		}, applyExecutor);
	}
	*///?}

	protected abstract void reloadStuff(PreparationBarrier synchronizer, ResourceManager manager, Executor prepareExecutor, Executor applyExecutor);
}
