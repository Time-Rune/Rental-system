package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.entity.Word;
import com.example.rentalsystem.repository.UserSQL;
import com.example.rentalsystem.repository.WordSQL;
import com.example.rentalsystem.utils.UserContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceWord {
    @Resource
    WordSQL wordSQL;
    @Resource
    UserSQL userSQL;

    public List<Word> getAllWords(){
        return wordSQL.getWords();
    }

    public List<Word> getPerPageWords(int pageNumber, int wordsNumberPerPage){
        List<Word> wordList = getAllWords();
        System.out.println("wordList_size = " + wordList.size());
        List<Word> res = new ArrayList<>();
        for(int i = (pageNumber-1)*wordsNumberPerPage; i < Math.min(wordList.size(), pageNumber*wordsNumberPerPage); i++)
            res.add(wordList.get(i));
        return res;
    }

    public void insertWord(String Wtext){
        User currentUser = UserContext.getCurrentUser();
        int WID = wordSQL.getMaxWID() + 1;
//        int Wpost = currentUser.getUID();
        int Wpost = 0;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Wdate = simpleDateFormat.format(date.getTime());
        wordSQL.insertWord(WID, Wtext, Wpost, Wdate, 0);
    }

    public User getPosterByID(){
//        User currentUser = UserContext.getCurrentUser();
//        int id = currentUser.getUID();
        int id = 0;
        List<User> list = userSQL.getUserByID(id);
        System.out.println("list_size = " + list.size());
        return list.get(0);
    }
}
