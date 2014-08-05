package danielm59.fastfood.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly; 

public class BlockCounter extends BlockFF{

	protected IIcon blockIconTop;
	protected IIcon blockIconBot;
	
	public BlockCounter(){
		
		super();
		this.setBlockName("counter");
		this.setBlockTextureName("counter");
		
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
    	
    	blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_side"));
    	blockIconTop = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_top"));
    	blockIconBot = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_bottom"));
    	
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata) {
	
		if (side == 1 ) {
	
			return blockIconTop;
			
		} else if (side == 0) {
			
			return blockIconBot;
	
		} else {
			return blockIcon;
			
		}
		
	}
	
}
