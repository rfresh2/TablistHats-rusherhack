package tlh;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.RemotePlayer;
import net.minecraft.world.entity.player.PlayerModelPart;

import java.util.UUID;

public class MockPlayer extends RemotePlayer {

    public MockPlayer(final ClientLevel clientLevel) {
        super(clientLevel, new GameProfile(UUID.randomUUID(), "mock"));
    }

    @Override
    public boolean isModelPartShown(PlayerModelPart playerModelPart) {
        return true;
    }
}
