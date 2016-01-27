package io.github.danielm59.fastfood.block;

import java.util.List;
import java.util.Random;

import io.github.danielm59.fastfood.FastFood;
import io.github.danielm59.fastfood.init.ModItems;
import io.github.danielm59.fastfood.item.ItemBlockFF;
import io.github.danielm59.fastfood.reference.GuiId;
import io.github.danielm59.fastfood.tileentity.TileEntityFryer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockFryer extends BlockCounterBase
{
    
    public BlockFryer()
    {
        
        super();
        this.setUnlocalizedName("fryer");
        
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        
        return new TileEntityFryer();
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos p, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        
        if (player.isSneaking())
        {
            return true;
        } else
        {
            if (!world.isRemote && world.getTileEntity(p) instanceof TileEntityFryer)
            {
                player.openGui(FastFood.instance, GuiId.FRYER.ordinal(), world, p.getX(), p.getY(), p.getZ());
            }
            
            return true;
        }
    }
    
    @Override
    public void setBlockBoundsForItemRender()
    {
        
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        
        return false;
    }
    
    @Override
    public boolean isFullCube()
    {
        
        return false;
    }
    
    @Override
    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB>  list, Entity collidingEntity)
    {
        
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        float f = 0.125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBoundsForItemRender();
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        
        return ModItems.fryer;
    }
    
    public static Block getBlockFromItem(Item itemIn)
    {
        
        return (Block) (itemIn instanceof ItemBlockFF ? ((ItemBlockFF) itemIn).getBlock() : null);
    }
}
