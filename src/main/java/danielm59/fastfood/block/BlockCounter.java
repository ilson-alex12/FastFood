package danielm59.fastfood.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly; 
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class BlockCounter extends BlockCounterBase{

	
	public BlockCounter(){
		
		super();
		this.setBlockName("counter");
		
	}
	
}
