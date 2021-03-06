package com.auramcraft.client.gui.inventory;

import java.util.ArrayList;
import org.lwjgl.opengl.GL11;
import com.auramcraft.inventory.ContainerEmpty;
import com.auramcraft.item.pages.*;
import com.auramcraft.reference.PageIds;
import com.auramcraft.reference.Textures;
import com.auramcraft.stats.AuramcraftPlayerStats;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class GuiBookOfAura extends GuiContainer {
	BookPage page;
	boolean[] pages;
	ArrayList<BookPage> book;
	int currentPage = 0;
	
	public GuiBookOfAura() {
		super(new ContainerEmpty());
		xSize = 146;
		ySize = 180;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
	    int trueRightX, trueLeftX;
	    y += 158;
	    x += 15;
	    trueRightX = x;
	    x += 90;
	    trueLeftX = x;
	    
	    buttonList.add(new ButtonTurnPage(0, trueLeftX, y, false));
	    buttonList.add(new ButtonTurnPage(1, trueRightX, y, true));
	    
	    AuramcraftPlayerStats stats = AuramcraftPlayerStats.get(mc.thePlayer);
	    pages = stats.getPages();
	    book = new ArrayList<BookPage>();
		makeBook(book, pages);
		page = book.get(currentPage);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int var2, int var3) {
		int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
	    
		String researched = researchedPages(pages) + " Entries";
		String page = "p. "+(currentPage+1);
		
		GL11.glScalef(0.75f, 0.75f, 1f);
		
		fontRendererObj.drawString(researched, ((xSize - fontRendererObj.getStringWidth(researched))) + x, y*2 + ySize + fontRendererObj.FONT_HEIGHT, 4210752);
		fontRendererObj.drawString(page, (int) ((xSize - fontRendererObj.getStringWidth(page)) + xSize/2.25) + x, (int) (y*1.5 + fontRendererObj.FONT_HEIGHT), 4210752);
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(page.getTexture());
		
		int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
	    drawTexturedModalRect(x, y, 20, 1, xSize, ySize);
	}
	
	private int researchedPages(boolean[] pages) {
		int researched = 0;
		for(int i = 0; i < pages.length; i++) {
			researched += pages[i] ? 1 : 0;
		}
		return researched;
	}
	
	private BookPage getPageFromSlot(int slot) {
		switch(slot) {
			case PageIds.SHARDS:
				return new PageShards();
			case PageIds.AURACRYSTAL:
				return new PageAuraCrystal();
			case PageIds.INFUSION:
				return new PageInfusion();
			case PageIds.ALCHEMY:
				return new PageAlchemy();
			case PageIds.MAGIKA:
				return new PageMagika();
			case PageIds.INFUSION_TIER_1:
				return new PageInfusionTier1();
			case PageIds.WAND_CAP_IRON:
				return new PageWandCapIron();
		}
		return new PageEmpty();
	}
	
	private void makeBook(ArrayList<BookPage> book, boolean[] pages) {
		for(int i = 0; i < pages.length; i++) {
			if(pages[i])
				book.add(getPageFromSlot(i));
		}
		if(book.isEmpty())
			book.add(new PageEmpty());
	}
	
	private void flipLeft() {
		if(currentPage >= 1) {
			currentPage--;
			page = book.get(currentPage);
		}
	}
	
	private void flipRight() {
		if(currentPage < book.size()-1) {
			currentPage++;
			page = book.get(currentPage);
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id) {
			case 1:
				flipLeft();
				break;
			case 0:
				flipRight();
				break;
		}
	}
}
