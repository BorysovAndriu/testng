package com.lits.borysov.assignment.BookTests;

import com.lits.borysov.assignment.Models.SearchBookModel;
import com.lits.borysov.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchBook extends UserService {

    @Test
    public void searchBookTest(){

        //Get user token after login
        String userToken = userLogin(passwordFromEmail_1, email_1)
                .getR().getAccess_token();

        //Search book with search word Boni
        SearchBookModel bookSearch = searchBook(userToken, "Boni");

       //Verify some params
        Assert.assertEquals(bookSearch.getHits().get(0).getAuthor(),"Boni Boni");
        Assert.assertEquals(bookSearch.getHits().get(0).getObjectID(),"testBookISBN");
        Assert.assertEquals(bookSearch.getHits().get(0).getHighlightResult()
                .getAuthor().getMatchedWords().get(0),"boni");
        Assert.assertEquals(bookSearch.getHits().get(0).getHighlightResult()
                .getIsbn().getValue(),"testBookISBN");
    }
}