package com.terremotospr.services;

import com.terremotospr.beans.CardBean;
import com.terremotospr.database.entities.Card;
import com.terremotospr.database.repositories.CardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public Boolean addCard(CardBean bean){
        if(bean == null) return false;

        Card entity = new Card();
        BeanUtils.copyProperties(bean, entity);
        cardRepository.save(entity);
        return true;

    }

    public List<CardBean> fetchAllCard(){
        List<CardBean> card;

        Iterable<Card> iter =cardRepository.findAll();

        card = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return card;
    }

    private CardBean copyProperties(Card entity){
        CardBean bean = new CardBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }
}
