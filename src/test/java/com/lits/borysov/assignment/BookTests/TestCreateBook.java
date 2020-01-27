package com.lits.borysov.assignment.BookTests;

import com.lits.borysov.assignment.Models.BookModel;
import com.lits.borysov.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateBook extends UserService {

    @Test()
    public void createBook(){

        //Get user token after login
        String userToken = userLogin(passwordFromEmail_1, email_1)
                .getR().getAccess_token();

        //Get response after create book
        BookModel book = createBook(userToken);

        //Verify ibsn
        Assert.assertEquals(book.getIsbn(), isbnRandom);
    }
}
