package ohtu.takarivi.lukuvinkit.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ohtu.takarivi.lukuvinkit.domain.ReadingTipCategory;

public class ReadingTipCategoryTest {

    @Test
    public void readingTipCategoryGetByNameReturnsCorrectForSingular() throws Exception {
        assertEquals(ReadingTipCategory.BOOK, ReadingTipCategory.getByName("book"));
        assertEquals(ReadingTipCategory.ARTICLE, ReadingTipCategory.getByName("article"));
        assertEquals(ReadingTipCategory.VIDEO, ReadingTipCategory.getByName("video"));
        assertEquals(ReadingTipCategory.LINK, ReadingTipCategory.getByName("link"));
    }

    @Test
    public void readingTipCategoryGetByNameReturnsCorrectEvenForPlural() throws Exception {
        assertEquals(ReadingTipCategory.BOOK, ReadingTipCategory.getByName("books"));
        assertEquals(ReadingTipCategory.ARTICLE, ReadingTipCategory.getByName("articles"));
        assertEquals(ReadingTipCategory.VIDEO, ReadingTipCategory.getByName("videos"));
        assertEquals(ReadingTipCategory.LINK, ReadingTipCategory.getByName("links"));
    }

}
