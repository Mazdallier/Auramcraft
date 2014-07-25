package com.auramcraft.client.gui.inventory;

import org.lwjgl.opengl.GL11;
import com.auramcraft.Auramcraft;
import com.auramcraft.api.Auras;
import com.auramcraft.inventory.ContainerInfusionTable;
import com.auramcraft.item.AuraItem;
import com.auramcraft.reference.Reference;
import com.auramcraft.reference.Textures;
import com.auramcraft.tileentity.TileEntityInfusionTable;
import com.auramcraft.util.LogHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiInfusionTable extends GuiContainer {
	private TileEntityInfusionTable tileEntityInfusionTable;
	private int[] slotX = new int[] {
			15, 49, 82, 115, 148
	};
	private int slotY = 59;
	private Auras[] auras = Auras.values();
	private ResourceLocation[] auraTex = new ResourceLocation[] {
		Textures.GUI.GUI_AURA_FIRE,
		Textures.GUI.GUI_AURA_EARTH,
		Textures.GUI.GUI_AURA_WATER,
		Textures.GUI.GUI_AURA_AIR,
		Textures.GUI.GUI_AURA_AURAM
	};
	
	public GuiInfusionTable(InventoryPlayer inventoryPlayer, World world, int x, int y, int z) {
		super(new ContainerInfusionTable(inventoryPlayer, world, x, y, z));
		this.tileEntityInfusionTable = (TileEntityInfusionTable) world.getTileEntity(x, y, z);
		xSize = 191;
		ySize = 179;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(Textures.GUI.GUI_INFUSION_TABLE);
		int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
	    drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	    
	    for(int i = 0; i < slotX.length; i++) {
	    	if(tileEntityInfusionTable.getStackInSlot(10) != null) {
	    		LogHelper.info("Item found");
	    		if(AuraItem.getAuraContainer(tileEntityInfusionTable.getStackInSlot(10)).containsAura(auras[i])) {
		    		LogHelper.info("Drawing...");
		    		mc.getTextureManager().bindTexture(auraTex[i]);
		    		drawTexturedModalRect(x+slotX[i], y+slotY, 0, 0, 32, 32);
	    		}
	    	}
	    }
	}
}
