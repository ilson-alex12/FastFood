package danielm59.fastfood.block.crops;


import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danielm59.fastfood.init.ModBlocks;
import danielm59.fastfood.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropsFF extends BlockCrops implements IGrowable {
	
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    private Item seed;
    private Item drop;

    public BlockCropsFF() {

        this.setTickRandomly(true);
        this.setCreativeTab((CreativeTabs) null);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        this.disableStats();

    }

    public static boolean func_149887_c(int meta) {

        return (meta & 7) != 0;
    }

    @Override
    public String getUnlocalizedName() {

        return String.format("tile.%s:%s", Reference.MODID, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String name) {

        return name.substring(name.indexOf(".") + 1);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {

        int l = world.getBlockMetadata(x, y, z);
        if (l <= 2) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
        } else if (l <= 4) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        } else if (l <= 6) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        } else {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    protected Item func_149866_i() {

        return seed;
    }

    @Override
    protected Item func_149865_P() {

        return drop;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random random) {

        return random.nextInt(3) + 2;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {

        this.iconArray = new IIcon[8];

        for (int i = 0; i < this.iconArray.length; ++i) {
            int tex = 0;
            if (i == 0 || i == 1) {
                tex = 0;
            } else if (i == 2) {
                tex = 1;
            } else if (i == 3 || i == 4) {
                tex = 2;
            } else if ((i == 5) || (i == 6)) {
                tex = 3;
            } else if (i == 7) {
                tex = 4;
            }

            this.iconArray[i] = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_stage_" + tex);
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {

        if (meta < 0 || meta > 7) {
            meta = 7;
        }

        return this.iconArray[meta];
    }
    
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {

        return super.canPlaceBlockAt(world, x, y, z) && world.isAirBlock(x, y + 1, z);
    }

    /**
     * checks if the block can stay, if not drop as item
     */
    @Override
    protected void checkAndDropBlock(World world, int x, int y, int z) {

        if (!this.canBlockStay(world, x, y, z)) {
            int l = world.getBlockMetadata(x, y, z);
            this.dropBlockAsItem(world, x, y, z, l, 0);
            world.setBlock(x, y, z, Blocks.air, 0, 2);
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
    	return EnumPlantType.Crop;
    }
    
    public void setSeed(Item seed) {
    	
    	this.seed = seed;
    	
    }
    
    public void setDrop(Item drop) {
    	
    	this.drop = drop;
    	
    }
    
}
