package net.dbt.vitalopus.mining;

/**
 * Implement this on any Block to declare what harvester tier is needed to mine it.
 * Blocks without this interface are treated as tier 0 (mineable by anyone).
 */
public interface LightningHarvesterTier {
    int getRequiredHarvesterTier();
}