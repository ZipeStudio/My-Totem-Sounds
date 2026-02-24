package me.zipestudio.mts.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import me.zipestudio.mts.client.TotemSoundManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ClientPacketListener.class)
public abstract class TotemSoundMixin {

    @Shadow
    private ClientLevel level;

    @ModifyArg(
            method = "handleEntityEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/multiplayer/ClientLevel;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"
            ),
            index = 3
    )
    private SoundEvent modifyTotemSound(SoundEvent original, @Local(argsOnly = true) ClientboundEntityEventPacket packet) {

        if (packet.getEventId() != 35) return original;

        ClientLevel level = this.level;
        if (level == null) return original;
        Entity entity = packet.getEntity(level);

        ItemStack stack = getActiveTotemOfUndying(entity);
        if (stack == null || stack.isEmpty()) {
            return original;
        }

        String rawName = getCustomName(stack);
        if (rawName == null || rawName.trim().isEmpty()) {
            return original;
        }

        var soundId = TotemSoundManager.getSoundId(rawName.trim());
        if (soundId == null || Minecraft.getInstance().getSoundManager().getSoundEvent(soundId) == null) {
            return original;
        }

        return SoundEvent.createVariableRangeEvent(soundId);
    }

    @Unique
    private static ItemStack getActiveTotemOfUndying(Entity entity) {
        if (!(entity instanceof LivingEntity livingEntity)) {
            return ItemStack.EMPTY;
        }
        for (InteractionHand hand : InteractionHand.values()) {

            ItemStack stack = livingEntity.getItemInHand(hand);
            //? if >=1.21.2 {
            if (stack.has(net.minecraft.core.component.DataComponents.DEATH_PROTECTION)) {
                return stack;
            }
            //?} else {
            /*if (stack.is(net.minecraft.world.item.Items.TOTEM_OF_UNDYING)) {
                return stack;
            }
            *///?}
        }
        return ItemStack.EMPTY;
    }

    @Unique
    private static String getCustomName(ItemStack stack) {
        //? if >=1.20.5 {
        var component = stack.get(net.minecraft.core.component.DataComponents.CUSTOM_NAME);
        return component != null ? component.getString() : null;
        //?} else {
        /*return stack.hasCustomHoverName() ? stack.getHoverName().getString() : null;
        *///?}
    }

}