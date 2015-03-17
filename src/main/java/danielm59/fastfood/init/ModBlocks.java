package danielm59.fastfood.init;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danielm59.fastfood.block.BlockChurn;
import danielm59.fastfood.block.BlockCounter;
import danielm59.fastfood.block.BlockFF;
import danielm59.fastfood.block.BlockGrinder;
import danielm59.fastfood.block.BlockMill;
import danielm59.fastfood.block.BlockPress;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks {

	public static final BlockFF counter = 	new BlockCounter();
	public static final BlockFF grinder = 	new BlockGrinder();
	public static final BlockFF churn =		new BlockChurn();
	public static final BlockFF press = 	new BlockPress();
	public static final BlockFF mill =   	new BlockMill();
	
	public static void init(){
		
		GameRegistry.registerBlock(counter, 	"counter");
		GameRegistry.registerBlock(grinder, 	"grinder");
		GameRegistry.registerBlock(churn, 		"churn");
		GameRegistry.registerBlock(press, 		"press");
		GameRegistry.registerBlock(mill, 		"mill");
	
	}
	
	
}
