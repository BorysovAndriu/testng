package com.lits.borysov.assignment;

import com.lits.borysov.assignment.Models.BookModel;
import com.lits.borysov.assignment.Models.SearchBookModel;
import com.lits.borysov.assignment.Models.UserModel;
import com.lits.borysov.litsHTTPClient.LitsHTTPClient;
import okhttp3.Headers;
import okhttp3.Response;
import org.testng.Assert;

import java.util.HashMap;

public class UserService extends LitsHTTPClient {

    //User constants
    public static final String email_1 = "rejodor398@repshop.net";
    public static final String passwordFromEmail_1 = "192837465";
    public static final String idUser_1 = "ym9IqM6YabwJfgQRnnPH";

    //Book constants
    public static final String isbn = "test0.3153752069807947";
    public static final String isbnRandom = "test" + Math.random();


    public UserModel userLogin(String userPassword, String userEmail) {

        //Create body
        HashMap<String, String> body = new HashMap<>();
        body.put("email", userEmail);
        body.put("password", userPassword);

        //Send POST for login
        Response userLogin = POST(baseUrl + pathUser, Headers.of(), body);

        //Verify status code
        Assert.assertEquals(userLogin.code(), 200);

        //Get response
        return convert(userLogin, UserModel.class);
    }

    public UserModel.UserInfoModel getUserInfo(String userToken){

        //GET user info
        System.out.println(baseUrl + pathUserInfo + idUser_1);
        Response userInfo = GET(baseUrl + pathUserInfo + idUser_1, Headers.of(createHeaders(userToken)));

        //Verify status code
        Assert.assertEquals(userInfo.code(), 200);

        //Get response
        return convert(userInfo, UserModel.UserInfoModel.class);
    }

    public HashMap createHeaders (String userToken){
        //Create headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + userToken);
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public BookModel createBook(String userToken) {

        //Create body
        HashMap<String, String> body = new HashMap<>();
        body.put("isbn", isbnRandom);
        body.put("name", "Andrew");
        body.put("description", "test description");
        body.put("author", "Boni Boni");
        body.put("publishDate", "2020");
        body.put("publisher", "self-published");

        //Send POST for login
        System.out.println(baseUrl + pathBook);
        Response userLogin = POST(baseUrl + pathBook, Headers.of(createHeaders(userToken)), body);

        //Verify status code
        Assert.assertEquals(userLogin.code(), 200);

        //Get response
        return convert(userLogin, BookModel.class);
    }

    public BookModel getBookByISBN(String userToken){

        //GET book info
        Response bookInfo = GET(baseUrl + pathBook + pathBookISBN, Headers.of(createHeaders(userToken)));

        //Verify status code
        Assert.assertEquals(bookInfo.code(), 200);

        //Get response
        return convert(bookInfo, BookModel.class);
    }

    public SearchBookModel searchBook(String userToken, String searchKey){

        //GET book info
        Response bookInfo = GET(baseUrl + pathSearchBook + searchKey, Headers.of(createHeaders(userToken)));

        //Verify status code
        Assert.assertEquals(bookInfo.code(), 200);

        //Get response
        return convert(bookInfo, SearchBookModel.class);
    }
}
