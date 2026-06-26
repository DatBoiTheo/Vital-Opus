package net.dbt.vitalopus.item;

import net.minecraft.world.item.*;

public class LightningHarvesterItem extends PickaxeItem {
    public LightningHarvesterItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE;
    }
}
