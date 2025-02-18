package tlh.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import tlh.MockPlayer;

import java.util.UUID;

@Mixin(PlayerTabOverlay.class)
public class MixinPlayerTabOverlay {
    @Unique
    private Player tablistHats$mockPlayer = null;

    @WrapOperation(method = "render", at = @At(
        value = "INVOKE",
        target = "Lnet/minecraft/client/multiplayer/ClientLevel;getPlayerByUUID(Ljava/util/UUID;)Lnet/minecraft/world/entity/player/Player;"
    ))
    public Player enableHats(final ClientLevel instance, final UUID uuid, final Operation<Player> original) {
        Player player = original.call(instance, uuid);
        if (player != null) return player;
        if (tablistHats$mockPlayer == null)
            tablistHats$mockPlayer = new MockPlayer(instance);
        return tablistHats$mockPlayer;
    }
}
