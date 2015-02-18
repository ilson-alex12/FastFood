package danielm59.fastfood.block.crops;


import java.util.ArrayList;
import java.util.Random;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import danielm59.fastfood.init.ModBlocks;
import danielm59.fastfood.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropsFF extends BlockCrops implements IGrowable {

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
    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos p) {

        IBlockState state = world.getBlockState(p);
    	Integer l = (Integer)state.getValue(AGE);
        if (l <= 1) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
        } else if (l <= 2) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        } else if (l <= 3) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        } else {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random random) {

        return random.nextInt(3) + 1;
    }

    
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, p
     */
    @Override
    public boolean canPlaceBlockAt(World world, BlockPos p) {

        return super.canPlaceBlockAt(world, p) && world.isAirBlock(p.add(0,1,0));
    }


    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos p)
    {
    	return EnumPlantType.Crop;
    }
    
    
}
