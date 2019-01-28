package com.example.dagger2_rxjava_mvp.mapper;

import com.example.dagger2_rxjava_mvp.mvp.model.Cake;
import com.example.dagger2_rxjava_mvp.mvp.model.CakeResponse;
import com.example.dagger2_rxjava_mvp.mvp.model.CakesItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CakeMapper {
    @Inject
    public CakeMapper(){

    }
    public List<Cake> mapCakes(CakeResponse response){
        List<Cake> cakeList=new ArrayList<>();
        if(response!=null){
 List<CakesItem> cakesItemsList= response.getCakes();
            if(cakesItemsList!=null){
                for(CakesItem cake: cakesItemsList){
                  Cake myCake=new Cake();
                  myCake.setId(cake.getId());
                  myCake.setDetailDescription(cake.getDetailDescription());
                  myCake.setPreviewDescription(cake.getPreviewDescription());
                  myCake.setImageUrl(cake.getImage());
                  cakeList.add(myCake);

                }

            }

        }
    return cakeList;
    }

}
