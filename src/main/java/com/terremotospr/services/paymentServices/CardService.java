package com.terremotospr.services.paymentServices;

import com.terremotospr.beans.paymentBeans.CardBean;
import com.terremotospr.database.entities.paymentEntities.Card;
import com.terremotospr.database.entities.paymentEntities.Cash;
import com.terremotospr.database.repositories.paymentRepositories.CardRepository;
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

    public Card findById(Integer id) { return cardRepository.findByPmId(id); }
}
