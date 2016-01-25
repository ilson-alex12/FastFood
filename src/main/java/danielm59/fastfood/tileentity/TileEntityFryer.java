package danielm59.fastfood.tileentity;

import danielm59.fastfood.recipe.fryer.FryerRecipe;
import danielm59.fastfood.recipe.fryer.FryerRegistry;
import danielm59.fastfood.recipe.fryer.OilRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;

public class TileEntityFryer extends TileEntityFF implements ITickable 
{
    
    // TODO save/load data
    public int           currentFryerProcessTime;
    public int           currentOilProcessTime;
    public int           oilLevel;
    public double        heat;
    public int           maxBurnTime = 1;
    public int           burnTime;
                         
    private final int    oilTime     = 40;
    private final int    fryerTime   = 100;
                                     
    private final int    maxOil      = 10000;
    private final int    addOil      = 1000;
    private final int    useOil      = 100;
                                     
    private final double minHeat     = 20.0;
    private final double maxHeat     = 200.0;
                                     
    public TileEntityFryer()
    {
        
        super();
        inventory = new ItemStack[5];
        heat = minHeat;
        
    }
    
    @Override
    public String getName()
    {
        
        return "Fryer";
        
    }
    
    @Override
    public void update()
    {
        
        updateOil();
        updateHeat();
        updateFryer();
        
    }
    
    public void updateFryer()
    {
        
        if (!worldObj.isRemote)
        {
            FryerRecipe recipe = FryerRegistry.getInstance().getMatchingFryerRecipe(inventory[0], inventory[4]);
            if (oilLevel >= useOil & heat > 120 & recipe != null)
            {
                
                if (++currentFryerProcessTime >= fryerTime)
                {
                    this.markDirty();
                    currentFryerProcessTime = 0;
                    if (inventory[4] != null)
                    {
                        inventory[4].stackSize += recipe.getOutput().stackSize;
                    } else
                    {
                        inventory[4] = recipe.getOutput().copy();
                    }
                    decrStackSize(0, 1);
                    oilLevel -= useOil;
                    heat -= 10;
                }
            } else
            {
                currentFryerProcessTime = 0;
            }
        }
    }
    
    public void updateHeat()
    {
        
        if (!worldObj.isRemote)
        {
            if (burnTime > 0)
            {
                burnTime--;
                heat += 0.1;
            } else
            {
                if (inventory[1] != null && getItemBurnTime(inventory[1]) > 0)
                {
                    maxBurnTime = burnTime = getItemBurnTime(inventory[1]);
                    decrStackSize(1, 1);
                } else
                {
                    heat -= 0.2;
                }
            }
            if (oilLevel == 0) heat = 0;
            heat = MathHelper.clamp_double(heat, minHeat, maxHeat);
        }
    }
    
    public void updateOil()
    {
        
        if (!worldObj.isRemote)
        {
            
            OilRecipe recipe = FryerRegistry.getInstance().getMatchingOilRecipe(inventory[2], inventory[3]);
            if (recipe != null && oilLevel <= maxOil - addOil)
            {
                if (++currentOilProcessTime >= oilTime)
                {
                    this.markDirty();
                    currentOilProcessTime = 0;
                    if (inventory[3] != null)
                    {
                        inventory[3].stackSize += recipe.getOutput().stackSize;
                    } else
                    {
                        inventory[3] = recipe.getOutput().copy();
                    }
                    decrStackSize(2, 1);
                    oilLevel = oilLevel + addOil;
                    heat -= 20;
                    heat = MathHelper.clamp_double(heat, minHeat, maxHeat);
                }
            } else
            {
                currentOilProcessTime = 0;
            }
        }
    }
    
    public float getFryerProgress()
    {
        
        return (float) currentFryerProcessTime / fryerTime;
        
    }
    
    public float getOilProgress()
    {
        
        return (float) currentOilProcessTime / oilTime;
        
    }
    
    public float getOilLevel()
    {
        
        return (float) oilLevel / maxOil;
        
    }
    
    public float getBurnProgress()
    {
        
        return (float) burnTime / maxBurnTime;
        
    }
    
    public float getHeat()
    {
        
        return (float) (heat / maxHeat);
        
    }
    
    public static int getItemBurnTime(ItemStack stack)
    {
        
        if (stack == null)
        {
            return 0;
        } else
        {
            Item item = stack.getItem();
            
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.wooden_slab) return 150;
                if (block.getMaterial() == Material.wood) return 300;
                if (block == Blocks.coal_block) return 16000;
            }
            
            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
        }
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        
        super.writeToNBT(nbt);
        nbt.setInteger("currentFryerProcessTime", currentFryerProcessTime);
        nbt.setInteger("currentOilProcessTime", currentOilProcessTime);
        nbt.setInteger("oilLevel", oilLevel);
        nbt.setDouble("heat", heat);
        nbt.setInteger("maxBurnTime", maxBurnTime);
        nbt.setInteger("burnTime", burnTime);
        
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        
        super.readFromNBT(nbt);
        currentFryerProcessTime = nbt.getInteger("currentFryerProcessTime");
        currentOilProcessTime = nbt.getInteger("currentOilProcessTime");
        oilLevel = nbt.getInteger("oilLevel");
        heat = nbt.getDouble("heat");
        maxBurnTime = nbt.getInteger("maxBurnTime");
        burnTime = nbt.getInteger("burnTime");
        
    }
    
}
