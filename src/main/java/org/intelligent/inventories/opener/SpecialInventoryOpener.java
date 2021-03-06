package org.intelligent.inventories.opener;

import com.google.common.collect.ImmutableList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.intelligent.inventories.IntelligentInventory;

import java.util.List;

public class SpecialInventoryOpener implements IntelligentInventoryOpener {

    private static final List<InventoryType> SUPPORTED = ImmutableList.of(
            InventoryType.FURNACE,
            InventoryType.WORKBENCH,
            InventoryType.DISPENSER,
            InventoryType.DROPPER,
            InventoryType.ENCHANTING,
            InventoryType.BREWING,
            InventoryType.ANVIL,
            InventoryType.BEACON,
            InventoryType.HOPPER
    );

    @Override
    public Inventory open(Player player, IntelligentInventory inventory) {
        Inventory handle = Bukkit.createInventory(player, inventory.getType(), inventory.getTitle());
        this.fill(handle, inventory.getContents());
        player.openInventory(handle);

        return handle;
    }

    @Override
    public boolean isSupported(InventoryType type) {
        return SUPPORTED.contains(type);
    }
}
