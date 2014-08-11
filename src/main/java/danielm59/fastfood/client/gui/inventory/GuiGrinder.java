package danielm59.fastfood.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import danielm59.fastfood.inventory.ContainerGrinder;
import danielm59.fastfood.reference.Reference;
import danielm59.fastfood.tileentity.TileEntityGrinder;

public class GuiGrinder extends GuiContainer {

	private TileEntityGrinder tileEntityGrinder;
	
    public GuiGrinder(InventoryPlayer inventoryPlayer, TileEntityGrinder grinder)
    {
        super(new ContainerGrinder(inventoryPlayer, grinder));
        tileEntityGrinder = grinder;
        xSize = 175;
        ySize = 165;
		
	}

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
            
    	fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityGrinder.getInventoryName()), 8, 6, 4210752); 
        
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID.toLowerCase(),"textures/gui/grinder.png"));
        
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

}
