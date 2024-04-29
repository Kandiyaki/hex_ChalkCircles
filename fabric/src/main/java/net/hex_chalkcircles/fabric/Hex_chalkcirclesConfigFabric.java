package net.hex_chalkcircles.fabric;

import at.petrak.hexcasting.api.misc.MediaConstants;
import dev.architectury.platform.Platform;
import net.hex_chalkcircles.Hex_chalkcircles;
import net.hex_chalkcircles.api.config.Hex_chalkcirclesConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.EnvType;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
@Config(name = Hex_chalkcircles.MOD_ID)
public class Hex_chalkcirclesConfigFabric extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.TransitiveObject
    public final Common common = new Common();
    @ConfigEntry.Category("client")
    @ConfigEntry.Gui.TransitiveObject
    public final Client client = new Client();
    @ConfigEntry.Category("server")
    @ConfigEntry.Gui.TransitiveObject
    public final Server server = new Server();

    public static void init() {
        AutoConfig.register(Hex_chalkcirclesConfigFabric.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        var instance = AutoConfig.getConfigHolder(Hex_chalkcirclesConfigFabric.class).getConfig();

        Hex_chalkcirclesConfig.setCommon(instance.common);

        if (Platform.getEnv().equals(EnvType.CLIENT)) {
            Hex_chalkcirclesConfig.setClient(instance.client);
        }

        // Needed for logical server in singleplayer, do not access server configs from client code
        Hex_chalkcirclesConfig.setServer(instance.server);
    }


    @Config(name = "common")
    private static class Common implements ConfigData, Hex_chalkcirclesConfig.CommonConfigAccess {
    }

    @Config(name = "client")
    private static class Client implements ConfigData, Hex_chalkcirclesConfig.ClientConfigAccess {
    }


    @Config(name = "server")
    private static class Server implements ConfigData, Hex_chalkcirclesConfig.ServerConfigAccess {

        @ConfigEntry.Gui.CollapsibleObject
        private Costs costs = new Costs();

        @Override
        public void validatePostLoad() throws ValidationException {
            this.costs.signumCost = Hex_chalkcirclesConfig.bound(this.costs.signumCost, DEF_MIN_COST, DEF_MAX_COST);
            this.costs.congratsCost = Hex_chalkcirclesConfig.bound(this.costs.congratsCost, DEF_MIN_COST, DEF_MAX_COST);
        }

        @Override
        public int getSignumCost() {
            return (int) (costs.signumCost * MediaConstants.DUST_UNIT);
        }

        @Override
        public int getCongratsCost() {
            return (int) (costs.congratsCost * MediaConstants.DUST_UNIT);
        }

        static class Costs {
            // costs of actions
            double signumCost = DEFAULT_SIGNUM_COST;
            double congratsCost = DEFAULT_CONGRATS_COST;
        }
    }
}