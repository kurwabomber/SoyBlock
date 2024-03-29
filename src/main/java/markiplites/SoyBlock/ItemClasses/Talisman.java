package markiplites.SoyBlock.ItemClasses;

import com.jeff_media.morepersistentdatatypes.DataType;
import markiplites.SoyBlock.Item;
import markiplites.SoyBlock.Main;
import markiplites.SoyBlock.attr;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Talisman extends Item
{
	public Talisman(String itemID, String itemName, Material mat, HashMap<attr, Double> attributes, String lore, String family)
	{
		super(itemID,itemName,mat,attributes,lore,200.0);
		ItemStack stack = super.getItemStack();
		ItemMeta meta = super.getItemMeta();

		meta.getPersistentDataContainer().set(Main.attributeKeys.get( "talismanFamily"), DataType.STRING, family);
		stack.setItemMeta(meta);

		super.setItemMeta(meta);
		super.setItemStack(stack);

		Bukkit.getLogger().info("Added Talisman: " + itemID + " to item dictionary.");
		this.finalizeItem(itemID);
	}
}
