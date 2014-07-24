package com.auramcraft.inventory;

import com.auramcraft.item.AuraItem;
import com.auramcraft.tileentity.TileEntityAuramcraft;
import com.auramcraft.tileentity.TileEntityAuramcraftInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class SyncedInventory implements IInventory {
	private TileEntityAuramcraftInventory entity;
	private ItemStack[] stackResult = new ItemStack[1];
	private int slot;
	
	public SyncedInventory(TileEntityAuramcraftInventory entity, int slot) {
		this.entity = entity;
		this.slot = slot;
	}
	
	@Override
	public void openInventory() {
		setInventorySlotContents(0, entity.getStackInSlot(slot));
	}
	
	@Override
	public void closeInventory() {
		entity.setInventorySlotContents(slot, getStackInSlot(0));
	}
	
	public int getSizeInventory() {
		return 1;
	}
	
	public ItemStack getStackInSlot(int par1) {
		return this.stackResult[0];
	}
	
	public String getInventoryName() {
		return "Aura Container";
	}
	
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	public ItemStack decrStackSize(int par1, int par2) {
		return getStackInSlotOnClosing(par1);
	}
	
	public ItemStack getStackInSlotOnClosing(int par1) {
		if(this.stackResult[0] != null) {
			ItemStack itemstack = this.stackResult[0];
			this.stackResult[0] = null;
			return itemstack;
		}
		else {
			return null;
		}
	}
	
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.stackResult[0] = par2ItemStack;
	}
	
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public void markDirty() {}
	
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return true;
	}
	
	public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
		return true;
	}
}
