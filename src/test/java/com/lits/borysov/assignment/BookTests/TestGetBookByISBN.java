package com.lits.borysov.assignment.BookTests;

import com.lits.borysov.assignment.Models.BookModel;
import com.lits.borysov.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetBookByISBN extends UserService {

    @Test()
    public void getBookBbyISBN(){

        //Get user token after login
        String userToken = userLogin(passwordFromEmail_1, email_1)
                .getR().getAccess_token();

        //Get book via isbn
        BookModel book = getBookByISBN(userToken);

        //Verify response
        Assert.assertEquals(book.getIsbn(), isbn);
        Assert.assertEquals(book.getAuthor(), "Boni Boni");
        Assert.assertEquals(book.getDescription(), "test description");
        Assert.assertEquals(book.getPublishDate(), "2020");
    }
}
