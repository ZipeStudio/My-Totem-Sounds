package me.zipestudio.mytotemsounds.reload;

//? if fabric {
import net.minecraft.server.packs.PackType;
//? if >=1.21.9 {
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
//?} else {
/*import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resources.Identifier;
*///?}

public class MTSReloadListeners {

	public static void register() {
		//? if >=26.1 {
		MTSReloadListener listener = new MTSReloadListener();
		ResourceLoader.get(PackType.CLIENT_RESOURCES).registerReloadListener(listener.getId(), listener);
		//?} elif >=1.21.9 {
		/*MTSReloadListener listener = new MTSReloadListener();
		ResourceLoader.get(PackType.CLIENT_RESOURCES).registerReloader(listener.getId(), listener);
		*///?} else {
		/*ResourceManagerHelper.get(PackType.CLIENT_RESOURCES).registerReloadListener(new IdentifiableListener());
		*///?}
	}

	//? if <=1.21.8 {
	/*private static class IdentifiableListener extends MTSReloadListener implements IdentifiableResourceReloadListener {

		@Override
		public Identifier getFabricId() {
			return this.getId();
		}

	}
	*///?}

}
//?} elif neoforge {
/*import net.neoforged.bus.api.IEventBus;
//? if >=1.21.4 {
import net.neoforged.neoforge.client.event.AddClientReloadListenersEvent;
//?} else {
/^import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
^///?}

public class MTSReloadListeners {

	public static void register(IEventBus modBus) {
		//? if >=1.21.4 {
		modBus.addListener(AddClientReloadListenersEvent.class, event -> {
			MTSReloadListener listener = new MTSReloadListener();
			event.addListener(listener.getId(), listener);
		});
		//?} else {
		/^modBus.addListener(RegisterClientReloadListenersEvent.class, event -> event.registerReloadListener(new MTSReloadListener()));
		^///?}
	}

}
*///?} elif forge {
/*import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class MTSReloadListeners {

	public static void register(IEventBus modBus) {
		modBus.addListener((RegisterClientReloadListenersEvent event) -> event.registerReloadListener(new MTSReloadListener()));
	}

}
*///?}
