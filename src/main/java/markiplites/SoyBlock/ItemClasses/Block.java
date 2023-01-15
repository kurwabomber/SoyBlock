package markiplites.SoyBlock.ItemClasses;

import com.jeff_media.morepersistentdatatypes.DataType;
import markiplites.SoyBlock.Item;
import markiplites.SoyBlock.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Block extends Item implements Listener
{
	public Block(String itemID, String itemName, Material mat, HashMap<String, Double> attributes, String lore, ItemStack[] itemArray)
	{
		super(itemID,itemName,mat,attributes,lore);
		ItemStack stack = super.getItemStack();
		ItemMeta meta = super.getItemMeta();

		meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "blockLoot"), DataType.ITEM_STACK_ARRAY, itemArray.clone());
		stack.setItemMeta(meta);

		super.setItemMeta(meta);
		super.setItemStack(stack);
		Bukkit.getLogger().info("Added Block: " + itemID + " to item dictionary.");
	}
}