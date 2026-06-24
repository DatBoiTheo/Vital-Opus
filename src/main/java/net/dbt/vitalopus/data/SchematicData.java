package net.dbt.vitalopus.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public record SchematicData(List<BlockInfo> blocks) {

    public record BlockInfo(BlockPos relativePos, BlockState state) {
        public static final Codec<BlockInfo> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        BlockPos.CODEC.fieldOf("pos").forGetter(BlockInfo::relativePos),
                        BlockState.CODEC.fieldOf("state").forGetter(BlockInfo::state)
                ).apply(instance, BlockInfo::new)
        );
    }

    public static final Codec<SchematicData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    BlockInfo.CODEC.listOf().fieldOf("blocks").forGetter(SchematicData::blocks)
            ).apply(instance, SchematicData::new)
    );
}