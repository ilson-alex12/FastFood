package danielm59.fastfood.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import danielm59.fastfood.inventory.ContainerChurn;
import danielm59.fastfood.reference.Reference;
import danielm59.fastfood.tileentity.TileEntityChurn;

public class GuiChurn extends GuiContainer {
    
    private TileEntityChurn tileEntityChurn;
    
    public GuiChurn(InventoryPlayer inventory, TileEntityChurn Churn, EntityPlayer player) {
    
        super(new ContainerChurn(inventory, Churn, player));
        tileEntityChurn = Churn;
        xSize = 175;
        ySize = 165;
        
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
    
        fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityChurn.getName()), 8, 6, 4210752);
        
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {
    
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID.toLowerCase(), "textures/gui/1to1Gui.png"));
        
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        
        int processPogress = (int) (tileEntityChurn.getProgress() * 22);
        drawTexturedModalRect(xStart + 80, yStart + 35, 176, 0, processPogress, 15);
        
    }
    
}
