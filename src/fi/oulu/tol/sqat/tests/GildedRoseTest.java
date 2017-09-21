package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
	@Test
	public void testIfSellInAvailable() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 3, 10) );

		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(2, itemBrie.getSellIn());
	}
	
	@Test
	public void testIfAgedbrieHaveHigherQualityAsItGetsOlder() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 3, 10) );

		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(15, itemBrie.getQuality());
	}
	
	@Test
	public void testIfAgedbrieQualityNeverPassed50() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 3, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		//already reach 50 
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
		
	}
	
	@Test
	public void testIfSulfuraNeverDecreaseQuality() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
				
		// Assert
		
		List<Item> items2 = store.getItems();
		Item itemSulfura = items2.get(0);
		assertEquals(80, itemSulfura.getQuality());
	}
	
	@Test
	public void testIfBackstagePassesIncreasesQualityAsSellInValueApproaches() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20));
		
		// Act and Assert
		List<Item> items3 = store.getItems();
		Item itemBackstage1 = items3.get(0);
				
		//22 (quality +1)
		store.updateEndOfDay();
		store.updateEndOfDay();
		assertEquals(22, itemBackstage1.getQuality());
				
		//26 (quality +2)
		store.updateEndOfDay();
		store.updateEndOfDay();
		assertEquals(26, itemBackstage1.getQuality());
				
		//30 (quality +2.5)
		store.updateEndOfDay();
		store.updateEndOfDay();
		assertEquals(30, itemBackstage1.getQuality());
			
		//35 (quality +3)
		store.updateEndOfDay();
		store.updateEndOfDay();
		assertEquals(35, itemBackstage1.getQuality());
		
		//41 (quality +4)
		store.updateEndOfDay();
		store.updateEndOfDay();
		assertEquals(41, itemBackstage1.getQuality());
				
		//44
		store.updateEndOfDay();
		assertEquals(44, itemBackstage1.getQuality());
				
	}
	
	@Test
	public void testIfBackstagePassesQualityDropsTo0AfterConcert() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		
		//Act
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items3 = store.getItems();
		Item itemBackstage1 = items3.get(0);
		assertEquals(0, itemBackstage1.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay() {

	}
}
