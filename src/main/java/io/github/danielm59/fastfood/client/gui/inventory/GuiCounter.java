package io.github.danielm59.fastfood.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import io.github.danielm59.fastfood.inventory.ContainerCounter;
import io.github.danielm59.fastfood.reference.Reference;
import io.github.danielm59.fastfood.tileentity.TileEntityCounter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiCounter extends GuiContainer
{
    
    private TileEntityCounter tileEntityCounter;
    
    public GuiCounter(InventoryPlayer inventoryPlayer, TileEntityCounter counter, EntityPlayer player)
    {
        
        super(new ContainerCounter(inventoryPlayer, counter, player));
        tileEntityCounter = counter;
        xSize = 176;
        ySize = 166;
        
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        
        fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityCounter.getName()), 8, 6, 4210752);
        
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID.toLowerCase(), "textures/gui/counter.png"));
        
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
    
}
