package danielm59.fastfood.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import danielm59.fastfood.inventory.ContainerFryer;
import danielm59.fastfood.reference.Reference;
import danielm59.fastfood.tileentity.TileEntityFryer;

public class GuiFryer extends GuiContainer {
    
    private TileEntityFryer tileEntityFryer;
    
    public GuiFryer(InventoryPlayer inventory, TileEntityFryer Fryer, EntityPlayer player) {
    
        super(new ContainerFryer(inventory, Fryer, player));
        tileEntityFryer = Fryer;
        xSize = 176; 
        ySize = 166;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
    
        fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityFryer.getName()), 24, 6, 4210752);
        
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID.toLowerCase(), "textures/gui/fryer.png"));
        
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        
        //TODO add progress and status bars
        
    }
    
}
