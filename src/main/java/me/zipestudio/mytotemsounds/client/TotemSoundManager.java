package me.zipestudio.mytotemsounds.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.GsonHelper;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class TotemSoundManager {

    private static final Map<String, Identifier> MAPPINGS = new HashMap<>();
    private static final String MAPPINGS_PATH = "totem_mappings.json";

    public static void loadMappings(ResourceManager manager) {

        MAPPINGS.clear();
        for (String namespace : manager.getNamespaces()) {

            Identifier path = Identifier.tryBuild(namespace, MAPPINGS_PATH);
            for (Resource resource : manager.getResourceStack(path)) {
                try (InputStreamReader reader = new InputStreamReader(resource.open())) {
                    JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
                    JsonArray array = GsonHelper.getAsJsonArray(root, "totem_mappings");
                    for (JsonElement elem : array) {
                        JsonObject obj = elem.getAsJsonObject();
                        String soundId = GsonHelper.getAsString(obj, "sound");
                        Identifier soundLoc = Identifier.tryParse(soundId);
                        if (soundLoc == null) {
                            MyTotemSoundsClient.LOGGER.warn("Invalid sound identifier: {}", soundId);
                            continue;
                        }

                        JsonElement nameElement = obj.get("name");
                        if (nameElement == null) {
                            MyTotemSoundsClient.LOGGER.warn("Missing 'name' field in mapping entry");
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
                    MyTotemSoundsClient.LOGGER.error("Failed to load totem mappings from {} in a pack", path, e);
                }
            }
        }
        MyTotemSoundsClient.LOGGER.info("Loaded {} totem mappings", MAPPINGS.size());
    }

    public static Identifier getSoundId(String name) {
        return MAPPINGS.get(name);
    }
}