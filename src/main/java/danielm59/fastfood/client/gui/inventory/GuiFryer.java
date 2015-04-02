package danielm59.fastfood.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import danielm59.fastfood.inventory.ContainerFryer;
import danielm59.fastfood.tileentity.TileEntityFryer;

public class GuiFryer extends GuiContainer {
    
    public GuiFryer(InventoryPlayer inventory, TileEntityFryer fryer, EntityPlayer player) {
    
        super(new ContainerFryer(inventory, fryer, player));
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    
        // TODO Auto-generated method stub
        
    }
    
}
