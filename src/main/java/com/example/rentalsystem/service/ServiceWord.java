package com.example.rentalsystem.service;

import com.example.rentalsystem.entity.User;
import com.example.rentalsystem.entity.Word;
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

    List<Word> getAllWords(){
        return wordSQL.getWords();
    }

    List<Word> getPerPageWords(int pageNumber, int wordsNumberPerPage){
        List<Word> wordList = getAllWords();
        List<Word> res = new ArrayList<>();
        for(int i = (pageNumber-1)*wordsNumberPerPage; i < pageNumber*wordsNumberPerPage; i++)
            res.add(wordList.get(i));
        return res;
    }

    void insertWord(String Wtext){
        User currentUser = UserContext.getCurrentUser();
        int WID = wordSQL.getMaxWID() + 1;
        int Wpost = currentUser.getUID();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Wdate = simpleDateFormat.format(date.getTime());
        wordSQL.insertWord(WID, Wtext, Wpost, Wdate, 0);
    }
}
