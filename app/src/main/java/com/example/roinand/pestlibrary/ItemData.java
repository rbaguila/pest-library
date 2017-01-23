package com.example.roinand.pestlibrary;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by User on 7/25/2016.
 */
public class ItemData {
    public Context context;
    public int[] riceIcons;
    public int[] cornIcons;
    public String[] riceNames;
    public String[] cornNames;
    public String[] riceCommonNames;
    public String[] cornCommonNames;

    public ItemData(Context context){
        this.context = context;
    }

    public void initRiceData(){
        riceIcons = new int[]{
            R.drawable.rice_blackarmywormadult,
            R.drawable.rice_blackarmywormlarva,
            R.drawable.rice_commoncutwormadult,
            R.drawable.rice_commoncutwormlarva,
            R.drawable.rice_earcuttingcaterpillaradult,
            R.drawable.rice_earcuttingcaterpillarlarva,
            R.drawable.rice_greenhornedcaterpillaradult,
            R.drawable.rice_greenhornedcaterpillarlarva,
            R.drawable.rice_ricecasewormadult,
            R.drawable.rice_ricegreensemilooperadult,
            R.drawable.rice_ricegreensemilooperlarva,
            R.drawable.rice_riceleaffolderadult,
            R.drawable.rice_riceleaffolderlarva,
            R.drawable.rice_riceskipperadult,
            R.drawable.rice_riceskipperlarva,
            R.drawable.rice_whitestemborer,
            R.drawable.rice_yellowstemboreradult,
            R.drawable.rice_yellowstemborerlarva
        };

        riceNames = new String[]{
            context.getResources().getStringArray(R.array.BlackArmywormadult)[0],
            context.getResources().getStringArray(R.array.BlackArmywormlarva)[0],
            context.getResources().getStringArray(R.array.CommonCutwormadult)[0],
            context.getResources().getStringArray(R.array.CommonCutwormlarva)[0],
            context.getResources().getStringArray(R.array.EarcuttingCaterpillaradult)[0],
            context.getResources().getStringArray(R.array.EarcuttingCaterpillarlarva)[0],
            context.getResources().getStringArray(R.array.GreenhornedCaterpillaradult)[0],
            context.getResources().getStringArray(R.array.GreenhornedCaterpillarlarva)[0],
            context.getResources().getStringArray(R.array.RiceCasewormadult)[0],
            context.getResources().getStringArray(R.array.RiceGreenSemilooperadult)[0],
            context.getResources().getStringArray(R.array.RiceGreenSemilooperlarva)[0],
            context.getResources().getStringArray(R.array.RiceLeaffolderadult)[0],
            context.getResources().getStringArray(R.array.RiceLeaffolderlarva)[0],
            context.getResources().getStringArray(R.array.RiceSkipperadult)[0],
            context.getResources().getStringArray(R.array.RiceSkipperlarva)[0],
            context.getResources().getStringArray(R.array.WhiteStemborer)[0],
            context.getResources().getStringArray(R.array.YellowStemboreradult)[0],
            context.getResources().getStringArray(R.array.YellowStemborerlarva)[0]
        };

        riceCommonNames = new String[]{
            context.getResources().getStringArray(R.array.BlackArmywormadult)[1],
            context.getResources().getStringArray(R.array.BlackArmywormlarva)[1],
            context.getResources().getStringArray(R.array.CommonCutwormadult)[1],
            context.getResources().getStringArray(R.array.CommonCutwormlarva)[1],
            context.getResources().getStringArray(R.array.EarcuttingCaterpillaradult)[1],
            context.getResources().getStringArray(R.array.EarcuttingCaterpillarlarva)[1],
            context.getResources().getStringArray(R.array.GreenhornedCaterpillaradult)[1],
            context.getResources().getStringArray(R.array.GreenhornedCaterpillarlarva)[1],
            context.getResources().getStringArray(R.array.RiceCasewormadult)[1],
            context.getResources().getStringArray(R.array.RiceGreenSemilooperadult)[1],
            context.getResources().getStringArray(R.array.RiceGreenSemilooperlarva)[1],
            context.getResources().getStringArray(R.array.RiceLeaffolderadult)[1],
            context.getResources().getStringArray(R.array.RiceLeaffolderlarva)[1],
            context.getResources().getStringArray(R.array.RiceSkipperadult)[1],
            context.getResources().getStringArray(R.array.RiceSkipperlarva)[1],
            context.getResources().getStringArray(R.array.WhiteStemborer)[1],
            context.getResources().getStringArray(R.array.YellowStemboreradult)[1],
            context.getResources().getStringArray(R.array.YellowStemborerlarva)[1]
        };
    }

    public void initCornData(){
        cornIcons = new int[]{
            R.drawable.corn_cornsemilooperadult,
            R.drawable.corn_cornsemilooperlarva,
            R.drawable.corn_asiancornboreradult,
            R.drawable.corn_cornearwormadult,
            R.drawable.corn_cornearwormlarva,
            R.drawable.corn_cornfleabeetle
        };

        cornNames = new String[]{
            context.getResources().getStringArray(R.array.CornSemilooperadult)[0],
            context.getResources().getStringArray(R.array.CornSemilooperlarva)[0],
            context.getResources().getStringArray(R.array.AsianCornboreradult)[0],
            context.getResources().getStringArray(R.array.CornEarwormadult)[0],
            context.getResources().getStringArray(R.array.CornEarwormlarva)[0],
            context.getResources().getStringArray(R.array.CornFleaBeetle)[0]
        };

        cornCommonNames = new String[]{
            context.getResources().getStringArray(R.array.CornSemilooperadult)[1],
            context.getResources().getStringArray(R.array.CornSemilooperlarva)[1],
            context.getResources().getStringArray(R.array.AsianCornboreradult)[1],
            context.getResources().getStringArray(R.array.CornEarwormadult)[1],
            context.getResources().getStringArray(R.array.CornEarwormlarva)[1],
            context.getResources().getStringArray(R.array.CornFleaBeetle)[1]
        };
    }

    public List<Item> getRiceItemData(){
        initRiceData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<riceNames.length && i<riceIcons.length; i++) {
            Item current = new Item();
            current.imageId = riceIcons[i];
            current.pestName = riceNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getCornItemData(){
        initCornData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<cornNames.length && i<cornIcons.length; i++) {
            Item current = new Item();
            current.imageId = cornIcons[i];
            current.pestName = cornNames[i];
            data.add(current);
        }
        return data;
    }

    public List<ItemAll> getAllRiceItemData() {
        initRiceData();
        List<ItemAll> data = new ArrayList<>();

        for (int i=0; i<riceNames.length && i<riceIcons.length; i++) {
            ItemAll current = new ItemAll();
            current.imageId = riceIcons[i];
            current.pestName = riceNames[i];
            current.commonNames = riceCommonNames[i];
            data.add(current);
        }
        return data;
    }

    public List<ItemAll> getAllCornItemData() {
        initCornData();
        List<ItemAll> data = new ArrayList<>();

        for (int i=0; i<cornNames.length && i<cornIcons.length; i++) {
            ItemAll current = new ItemAll();
            current.imageId = cornIcons[i];
            current.pestName = cornNames[i];
            current.commonNames = cornCommonNames[i];
            data.add(current);
        }
        return data;
    }

}
