package me.zipestudio.mts.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.zipestudio.mts.MTSClient;
import me.zipestudio.mts.MTSServer;
import me.zipestudio.mts.reload.MTSReloadListener;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.NotNull;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;


public class TotemSoundManager {

    private static final Map<String, ResourceLocation> MAPPINGS = new HashMap<>();
    private static final String MAPPINGS_PATH = "totem_mappings.json";

    public static void init() {
        ResourceManagerHelper.get(PackType.CLIENT_RESOURCES).registerReloadListener(new MTSReloadListener());
    }

    public static void loadMappings(ResourceManager manager) {

        MAPPINGS.clear();
        for (String namespace : manager.getNamespaces()) {

            ResourceLocation path = ResourceLocation.tryBuild(namespace, MAPPINGS_PATH);
            for (Resource resource : manager.getResourceStack(path)) {
                try (InputStreamReader reader = new InputStreamReader(resource.open())) {
                    JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
                    JsonArray array = GsonHelper.getAsJsonArray(root, "totem_mappings");
                    for (JsonElement elem : array) {
                        JsonObject obj = elem.getAsJsonObject();
                        String soundId = GsonHelper.getAsString(obj, "sound");
                        ResourceLocation soundLoc = ResourceLocation.tryParse(soundId);
                        if (soundLoc == null) {
                            MTSClient.LOGGER.warn("Invalid sound identifier: {}", soundId);
                            continue;
                        }

                        JsonElement nameElement = obj.get("name");
                        if (nameElement == null) {
                            MTSClient.LOGGER.warn("Missing 'name' field in mapping entry");
                            continue;
                        }

                        if (nameElement.isJsonArray()) {
                            JsonArray namesArray = nameElement.getAsJsonArray();
                            for (JsonElement n : namesArray) {
                                MAPPINGS.put(n.getAsString(), soundLoc);
                            }
                        } else {
                            MAPPINGS.put(nameElement.getAsString(), soundLoc);
                        }
                    }
                } catch (Exception e) {
                    MTSClient.LOGGER.error("Failed to load totem mappings from {} in a pack", path, e);
                }
            }
        }
        MTSClient.LOGGER.info("Loaded {} totem mappings", MAPPINGS.size());
    }

    public static ResourceLocation getSoundId(String name) {
        return MAPPINGS.get(name);
    }
}