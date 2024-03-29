package markiplites.SoyBlock;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Commands implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		if(!sender.hasPermission("soyblock.giveitems"))
			sender.sendMessage("Insufficient permission to give items.");
		
		if(sender instanceof Player p) {
			Player target = Bukkit.getPlayer(args[0]);
			if(ItemListHandler.getItemMap().containsKey(args[1]) && !Objects.equals(args[1], "")) {
				ItemStack leItem = ItemListHandler.generateItem(args[1]);
				target.getInventory().addItem(leItem);
				target.updateInventory();
				target.sendMessage(String.format("%s gave you %s", p.getName(), args[1]));
				p.sendMessage(String.format("You gave %s %s", target.getName(), args[1]));
				return true;
			}else {
				p.sendMessage("Item does not exist.");
			}
		}
		
		return false;
	}
}