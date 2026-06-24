package net.dbt.vitalopus.block;

import net.dbt.vitalopus.VitalOpus;
import net.dbt.vitalopus.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VitalOpus.MOD_ID);

    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.VAULT)));


//    public static final DeferredBlock<Block> NEUTRONIUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CORIUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> ENRICHED_URANIUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> RADIUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> FULLERENE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> DEPLETED_URANIUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> ETHANOL = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> TUNGSTEN = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> WOLFRAMITE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> URANIUM_ORE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> ABYSSALITE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> THERMIUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> COBALT = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> NIOBIUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CERAMIC = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> STEEL = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> BLEACH_STONE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> LIME = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> IRON = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> FOSSIL = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> BRINE_ICE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> COBALT_ORE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> PHOSPHORITE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CHLORINE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> IGNEOUS_ROCK = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> RUST = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> ALUMINUM_ORE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CRUSHED_ICE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> ISORESIN = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CRUSHED_ROCK = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> LEAD = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> PROPANE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> POLLUTED_DIRT = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> POLLUTED_MUD = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> MUD = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> GENETIC_OOZE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> OXYLITE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> RESIN = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> POLLUTED_ICE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> SUCROSE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> SULFUR = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> SALT = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> ALGAE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> FERTILIZER = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CRUDE_OIL = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> NAPHTHA = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> REFINED_CARBON = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> HYDROGEN = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> PETROLEUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> ELECTRUM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CARBON_DIOXIDE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> SEDIMENTARY_ROCK = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> GOLD_AMALGAM = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> OXYGEN = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> METHANE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> MAFIC_ROCK = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> REGOLITH = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> BITUMEN = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> SOLID_NUCLEAR_WASTE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> PHOSPHORUS = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> GRAPHITE = registerBlock("neutronium",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()));


    private static <T extends Block> DeferredBlock<T> registerBlock (String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}