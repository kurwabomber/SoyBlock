package markiplites.SoyBlock.ItemClasses;

import markiplites.SoyBlock.Item;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.HashMap;

public class Chestplate extends Item implements Listener
{
	public Chestplate(String itemID, String itemName, Material mat, HashMap<String, Double> attributes, String lore, String rgb)
	{
		super(itemID,itemName,mat,attributes,lore);

		ItemMeta meta = getItemMeta();
		ItemStack stack = getItemStack();
		if(rgb != null)
		{
			int it = 0;
			int red = 0;
			int green = 0;
			int blue = 0;
			for(String color: rgb.split(" "))
			{
				if(it == 0)
				{
					red = Integer.parseInt(color);
				}
				else if(it == 1)
				{
					green = Integer.parseInt(color);
				}
				else if(it == 2)
				{
					blue = Integer.parseInt(color);
				}
				it++;
			}

			Color rgbColor = Color.fromRGB(red, green, blue);
			Bukkit.getLogger().info("Set " + itemID + " RGB value to " + rgbColor.asRGB());
			((LeatherArmorMeta) meta).setColor(rgbColor);
		}
		super.setItemMeta(meta);
		super.setItemStack(stack);
		Bukkit.getLogger().info("Added Chestplate: " + itemID + " to item dictionary.");
	}
}
