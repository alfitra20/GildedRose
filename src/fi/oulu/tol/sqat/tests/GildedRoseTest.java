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
	//Aged Brie
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
		//Aged Brie - quality never negative
		@Test
		public void AgedBrieQualityNeverNegativeTest() {
			GildedRose store = new GildedRose();
			store.addItem(new Item("Aged Brie", 0, 0) );

			// Act
			store.updateEndOfDay();
			
			// Assert
			List<Item> items = store.getItems();
			Item itemBrie = items.get(0);
			assertEquals(2, itemBrie.getQuality());
		}
		//Dexterity Vest - quality never negative
		@Test
		public void DexterityVestQualityNeverNegativeTest() {
			GildedRose store = new GildedRose();
			store.addItem(new Item("+5 Dexterity Vest", 0, 0));

			// Act
			store.updateEndOfDay();
			
			// Assert
			List<Item> items = store.getItems();
			Item itemBrie = items.get(0);
			assertEquals(0, itemBrie.getQuality());
		}
		// Elixir - quality never negative
		@Test
		public void ElixirQualityNeverNegativeTest() {
			GildedRose store = new GildedRose();
			store.addItem(new Item("Elixir of the Mongoose", 0, 0));

			// Act
			store.updateEndOfDay();
			
			// Assert
			List<Item> items = store.getItems();
			Item itemBrie = items.get(0);
			assertEquals(0, itemBrie.getQuality());
		}
		// Sulfuras - quality never negative
		@Test
		public void SulfurasQualityNeverNegativeTest() {
			GildedRose store = new GildedRose();
			store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 0));

			// Act
			store.updateEndOfDay();
			
			// Assert
			List<Item> items = store.getItems();
			Item itemBrie = items.get(0);
			assertEquals(0, itemBrie.getQuality());
		}
		// Backstage passes - quality never negative
		@Test
		public void BackstagePassesQualityNeverNegativeTest() {
			GildedRose store = new GildedRose();
			store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0));
			// Act
			store.updateEndOfDay();
			
			// Assert
			List<Item> items = store.getItems();
			Item itemBrie = items.get(0);
			assertEquals(0, itemBrie.getQuality());
		}
		// Conjured - quality never negative
		@Test
		public void ConjuredQualityNeverNegativeTest() {
			GildedRose store = new GildedRose();
			store.addItem(new Item("Conjured Mana Cake", 0, 0));
			// Act
			store.updateEndOfDay();
			
			// Assert
			List<Item> items = store.getItems();
			Item itemBrie = items.get(0);
			assertEquals(0, itemBrie.getQuality());
		}
		
	//Quality never gets more than 50 except Sulfura
		//Aged Brie - Quality never gets more than 50
				@Test
				public void AgedBrieQualityNeverMoreThan50Test() {
					GildedRose store = new GildedRose();
					store.addItem(new Item("Aged Brie", 1, 50) );

					// Act
					store.updateEndOfDay();
					
					// Assert
					List<Item> items = store.getItems();
					Item itemBrie = items.get(0);
					assertEquals(50, itemBrie.getQuality());
				}
				//Dexterity Vest - Quality never gets more than 50
				@Test
				public void DexterityVestQualityNeverMoreThan50Test() {
					GildedRose store = new GildedRose();
					store.addItem(new Item("+5 Dexterity Vest", 1, 50));

					// Act
					store.updateEndOfDay();
					
					// Assert
					List<Item> items = store.getItems();
					Item itemBrie = items.get(0);
					assertEquals(49, itemBrie.getQuality());
				}
				// Elixir - Quality never gets more than 50
				@Test
				public void ElixirQualityNeverMoreThan50Test() {
					GildedRose store = new GildedRose();
					store.addItem(new Item("Elixir of the Mongoose", 1, 50));

					// Act
					store.updateEndOfDay();
					
					// Assert
					List<Item> items = store.getItems();
					Item itemBrie = items.get(0);
					assertEquals(49, itemBrie.getQuality());
				}
				// Sulfuras - Quality never gets more than 80
				@Test
				public void SulfurasQualityNeverMoreThan80Test() {
					GildedRose store = new GildedRose();
					store.addItem(new Item("Sulfuras, Hand of Ragnaros", 1, 80));

					// Act
					store.updateEndOfDay();
					
					// Assert
					List<Item> items = store.getItems();
					Item itemBrie = items.get(0);
					assertEquals(80, itemBrie.getQuality());
				}
				// Backstage passes - Quality never gets more than 50
				@Test
				public void BackstagePassesQualityNeverMoreThan50Test() {
					GildedRose store = new GildedRose();
					store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50));
					// Act
					store.updateEndOfDay();
					
					// Assert
					List<Item> items = store.getItems();
					Item itemBrie = items.get(0);
					assertEquals(50, itemBrie.getQuality());
				}
				// Conjured - Quality never gets more than 50
				@Test
				public void ConjuredQualityNeverMoreThan50Test() {
					GildedRose store = new GildedRose();
					store.addItem(new Item("Conjured Mana Cake", 2, 50));
					// Act
					store.updateEndOfDay();
					
					// Assert
					List<Item> items = store.getItems();
					Item itemBrie = items.get(0);
					assertEquals(49, itemBrie.getQuality());
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
	
	//@Test
	//public void testIfAgedbrieQualityNeverPassed50() {
	//	GildedRose store = new GildedRose();
	//	store.addItem(new Item("Aged Brie", 3, 10) );
		
		// Act
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
		//already reach 50 
	//	store.updateEndOfDay();
	//	store.updateEndOfDay();
		
		// Assert
	//	List<Item> items = store.getItems();
	//	Item itemBrie = items.get(0);
	//	assertEquals(50, itemBrie.getQuality());
		
	//}
	
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
