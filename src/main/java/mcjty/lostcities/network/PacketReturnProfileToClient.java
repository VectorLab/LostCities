package mcjty.lostcities.network;

import io.netty.buffer.ByteBuf;
import mcjty.lostcities.LostCities;
import mcjty.lostcities.config.LostCityProfile;
import mcjty.lostcities.dimensions.world.WorldTypeTools;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketReturnProfileToClient implements IMessage {

    private int dimension;
    private LostCityProfile profile;

    @Override
    public void fromBytes(ByteBuf buf) {
        dimension = buf.readInt();
        //profile = NetworkTools.readString(buf);
        String name=NetworkTools.readString(buf);
        profile=new LostCityProfile(name,buf.readBoolean());
        
        profile.HORIZON=buf.readFloat();
        profile.FOG_RED=buf.readFloat();
        profile.FOG_GREEN=buf.readFloat();
        profile.FOG_BLUE=buf.readFloat();
        profile.FOG_DENSITY=buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(dimension);
        //NetworkTools.writeString(buf, profile);
        NetworkTools.writeString(buf, profile.getName());
        buf.writeBoolean(profile.isPublic());

        buf.writeFloat(profile.HORIZON);
        buf.writeFloat(profile.FOG_RED);
        buf.writeFloat(profile.FOG_GREEN);
        buf.writeFloat(profile.FOG_BLUE);
        buf.writeFloat(profile.FOG_DENSITY);
    }

    public PacketReturnProfileToClient() {
    }

    public PacketReturnProfileToClient(int dimension, LostCityProfile profile) {
        this.dimension = dimension;
        this.profile = profile;
    }

    public static class Handler implements IMessageHandler<PacketReturnProfileToClient, IMessage> {
        @Override
        public IMessage onMessage(PacketReturnProfileToClient message, MessageContext ctx) {
            LostCities.proxy.addScheduledTaskClient(() -> handle(message, ctx));
            return null;
        }

        private void handle(PacketReturnProfileToClient message, MessageContext ctx) {
            WorldTypeTools.setProfileFromServer(message.dimension, message.profile);
        }
    }

}
