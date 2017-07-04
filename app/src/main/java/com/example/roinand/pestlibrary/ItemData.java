package com.example.roinand.pestlibrary;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ItemData {
    public Context context;
    //pests
    public int[] riceIcons;
    public String[] riceNames;
    public String[] riceCommonNames;

    public int[] cornIcons;
    public String[] cornNames;
    public String[] cornCommonNames;

    public int[] bananaIcons;
    public String[] bananaNames;
    public String[] bananaCommonNames;

    public int[] cacaoIcons;
    public String[] cacaoNames;
    public String[] cacaoCommonNames;

    public int[] coffeeIcons;
    public String[] coffeeNames;
    public String[] coffeeCommonNames;

    public int[] cocoIcons;
    public String[] cocoNames;
    public String[] cocoCommonNames;

    //diseases
    public int[] driceIcons;
    public String[] driceNames;
    public String[] driceCommonNames;

    public int[] dcornIcons;
    public String[] dcornNames;
    public String[] dcornCommonNames;

    public int[] dbananaIcons;
    public String[] dbananaNames;
    public String[] dbananaCommonNames;

    public int[] dcacaoIcons;
    public String[] dcacaoNames;
    public String[] dcacaoCommonNames;

    public int[] dcoffeeIcons;
    public String[] dcoffeeNames;
    public String[] dcoffeeCommonNames;

    public int[] dcocoIcons;
    public String[] dcocoNames;
    public String[] dcocoCommonNames;

    //dynamic
    private static final String TAG = ">";
    public ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();

    public ItemData(Context context){
        this.context = context;
    }

    //initial four items per category
    public void initRiceData(){
        riceIcons = new int[]{
            R.drawable.rice_blackarmywormadult,
            R.drawable.rice_commoncutwormadult,
            R.drawable.rice_earcuttingcaterpillaradult,
            R.drawable.rice_greenhornedcaterpillaradult
        };

        riceNames = new String[]{
            context.getResources().getStringArray(R.array.BlackArmywormadult)[0],
            context.getResources().getStringArray(R.array.CommonCutwormadult)[0],
            context.getResources().getStringArray(R.array.EarcuttingCaterpillaradult)[0],
            context.getResources().getStringArray(R.array.GreenhornedCaterpillaradult)[0]
        };

        riceCommonNames = new String[]{
            context.getResources().getStringArray(R.array.BlackArmywormadult)[1],
            context.getResources().getStringArray(R.array.CommonCutwormadult)[1],
            context.getResources().getStringArray(R.array.EarcuttingCaterpillaradult)[1],
            context.getResources().getStringArray(R.array.GreenhornedCaterpillaradult)[1]
        };
    }

    public void initDriceData(){
        driceIcons = new int[]{
                R.drawable.drice_bacterialleafblight,
                R.drawable.drice_bacterialleafstreak,
                R.drawable.drice_bakanae,
                R.drawable.drice_brownspot
        };

        driceNames = new String[]{
                context.getResources().getStringArray(R.array.BacterialLeafBlight)[0],
                context.getResources().getStringArray(R.array.BacterialLeafStreak)[0],
                context.getResources().getStringArray(R.array.Bakanae)[0],
                context.getResources().getStringArray(R.array.BrownSpot)[0]
        };

        driceCommonNames = new String[]{
                context.getResources().getStringArray(R.array.BacterialLeafBlight)[1],
                context.getResources().getStringArray(R.array.BacterialLeafStreak)[1],
                context.getResources().getStringArray(R.array.Bakanae)[1],
                context.getResources().getStringArray(R.array.BrownSpot)[1]
        };
    }

    public void initCornData(){
        cornIcons = new int[]{
                R.drawable.corn_cornsemilooperadult,
                R.drawable.corn_asiancornboreradult,
                R.drawable.corn_cornearwormadult,
                R.drawable.corn_cornfleabeetle
        };

        cornNames = new String[]{
                context.getResources().getStringArray(R.array.CornSemilooperadult)[0],
                context.getResources().getStringArray(R.array.AsianCornboreradult)[0],
                context.getResources().getStringArray(R.array.CornEarwormadult)[0],
                context.getResources().getStringArray(R.array.CornFleaBeetle)[0]
        };

        cornCommonNames = new String[]{
                context.getResources().getStringArray(R.array.CornSemilooperadult)[1],
                context.getResources(


                ).getStringArray(R.array.AsianCornboreradult)[1],
                context.getResources().getStringArray(R.array.CornEarwormadult)[1],
                context.getResources().getStringArray(R.array.CornFleaBeetle)[1]
        };
    }

    public void initDcornData(){
        dcornIcons = new int[]{
                R.drawable.dcorn_cornrust,
                R.drawable.dcorn_cornsmut,
                R.drawable.dcorn_downymildew,
                R.drawable.dcorn_stalkrot
        };

        dcornNames = new String[]{
                context.getResources().getStringArray(R.array.CornRust)[0],
                context.getResources().getStringArray(R.array.CornSmut)[0],
                context.getResources().getStringArray(R.array.DownyMildew)[0],
                context.getResources().getStringArray(R.array.StalkRot)[0]
        };

        dcornCommonNames = new String[]{
                context.getResources().getStringArray(R.array.CornRust)[1],
                context.getResources().getStringArray(R.array.CornSmut)[1],
                context.getResources().getStringArray(R.array.DownyMildew)[1],
                context.getResources().getStringArray(R.array.StalkRot)[1]
        };
    }

    public void initBananaData(){
        bananaIcons = new int[]{
                R.drawable.ban_bananaaphids,
                R.drawable.ban_lacebug,
                R.drawable.ban_scaleinsects,
                R.drawable.ban_thrips
        };

        bananaNames = new String[]{
                context.getResources().getStringArray(R.array.BananaAphids)[0],
                context.getResources().getStringArray(R.array.LaceBug)[0],
                context.getResources().getStringArray(R.array.ScaleInsects)[0],
                context.getResources().getStringArray(R.array.Thrips)[0]
        };

        bananaCommonNames = new String[]{
                context.getResources().getStringArray(R.array.BananaAphids)[1],
                context.getResources().getStringArray(R.array.LaceBug)[1],
                context.getResources().getStringArray(R.array.ScaleInsects)[1],
                context.getResources().getStringArray(R.array.Thrips)[1]
        };
    }

    public void initDbananaData(){
        dbananaIcons = new int[]{
                R.drawable.dban_bananafreckle,
                R.drawable.dban_bananarust,
                R.drawable.dban_bananastreak,
                R.drawable.dban_bunchytop
        };

        dbananaNames = new String[]{
                context.getResources().getStringArray(R.array.BananaFreckle)[0],
                context.getResources().getStringArray(R.array.BananaRust)[0],
                context.getResources().getStringArray(R.array.BananaStreak)[0],
                context.getResources().getStringArray(R.array.BunchyTop)[0]
        };

        dbananaCommonNames = new String[]{
                context.getResources().getStringArray(R.array.BananaFreckle)[1],
                context.getResources().getStringArray(R.array.BananaRust)[1],
                context.getResources().getStringArray(R.array.BananaStreak)[1],
                context.getResources().getStringArray(R.array.BunchyTop)[1]
        };
    }

    public void initCacaoData(){
        cacaoIcons = new int[]{
                R.drawable.cac_cacaopodborer,
                R.drawable.cac_camelliaaphids,
                R.drawable.cac_carpentermoth,
                R.drawable.cac_miridbug
        };

        cacaoNames = new String[]{
                context.getResources().getStringArray(R.array.CacaoPodBorer)[0],
                context.getResources().getStringArray(R.array.CamelliaAphids)[0],
                context.getResources().getStringArray(R.array.CarpenterMoth)[0],
                context.getResources().getStringArray(R.array.MiridBug)[0]
        };

        cacaoCommonNames = new String[]{
                context.getResources().getStringArray(R.array.CacaoPodBorer)[1],
                context.getResources().getStringArray(R.array.CamelliaAphids)[1],
                context.getResources().getStringArray(R.array.CarpenterMoth)[1],
                context.getResources().getStringArray(R.array.MiridBug)[1]
        };
    }

    public void initDcacaoData(){
        dcacaoIcons = new int[]{
                R.drawable.dcac_blackpodrot,
                R.drawable.dcac_vascularstreakdieback
        };

        dcacaoNames = new String[]{
                context.getResources().getStringArray(R.array.BlackPodRot)[0],
                context.getResources().getStringArray(R.array.VascularStreakDieback)[0]
        };

        dcacaoCommonNames = new String[]{
                context.getResources().getStringArray(R.array.BlackPodRot)[1],
                context.getResources().getStringArray(R.array.VascularStreakDieback)[1]
        };
    }

    public void initCoffeeData(){
        coffeeIcons = new int[]{
                R.drawable.coff_coffeeberryborer,
                R.drawable.coff_coffeemealybug,
                R.drawable.coff_coffeestemborer,
                R.drawable.coff_greenscale
        };

        coffeeNames = new String[]{
                context.getResources().getStringArray(R.array.CoffeeBerryBorer)[0],
                context.getResources().getStringArray(R.array.CoffeeMealybug)[0],
                context.getResources().getStringArray(R.array.CoffeeStemBorer)[0],
                context.getResources().getStringArray(R.array.GreenScale)[0]
        };

        coffeeCommonNames = new String[]{
                context.getResources().getStringArray(R.array.CoffeeBerryBorer)[1],
                context.getResources().getStringArray(R.array.CoffeeMealybug)[1],
                context.getResources().getStringArray(R.array.CoffeeStemBorer)[1],
                context.getResources().getStringArray(R.array.GreenScale)[1]
        };
    }

    public void initDcoffeeData(){
        dcoffeeIcons = new int[]{
                R.drawable.dcoff_browneyespot,
                R.drawable.dcoff_coffeerust,
                R.drawable.dcoff_dieback,
                R.drawable.dcoff_pinkdisease
        };

        dcoffeeNames = new String[]{
                context.getResources().getStringArray(R.array.BrownEyeSpot)[0],
                context.getResources().getStringArray(R.array.CoffeeRust)[0],
                context.getResources().getStringArray(R.array.Dieback)[0],
                context.getResources().getStringArray(R.array.PinkDisease)[0]
        };

        dcoffeeCommonNames = new String[]{
                context.getResources().getStringArray(R.array.BrownEyeSpot)[1],
                context.getResources().getStringArray(R.array.CoffeeRust)[1],
                context.getResources().getStringArray(R.array.Dieback)[1],
                context.getResources().getStringArray(R.array.PinkDisease)[1]
        };
    }

    public void initCocoData(){
        cocoIcons = new int[]{
                R.drawable.coco_coconutleafbeetle,
                R.drawable.coco_coconutscaleinsect,
                R.drawable.coco_falsespidermite,
                R.drawable.coco_rhinocerosbeetle
        };

        cocoNames = new String[]{
                context.getResources().getStringArray(R.array.CoconutLeafBeetle)[0],
                context.getResources().getStringArray(R.array.CoconutScaleInsect)[0],
                context.getResources().getStringArray(R.array.FalseSpiderMite)[0],
                context.getResources().getStringArray(R.array.RhinocerosBeetle)[0]
        };

        cocoCommonNames = new String[]{
                context.getResources().getStringArray(R.array.CoconutLeafBeetle)[1],
                context.getResources().getStringArray(R.array.CoconutScaleInsect)[1],
                context.getResources().getStringArray(R.array.FalseSpiderMite)[1],
                context.getResources().getStringArray(R.array.RhinocerosBeetle)[1]
        };
    }

    public void initDcocoData(){
        dcocoIcons = new int[]{
                R.drawable.dcoco_cadangcadang,
                R.drawable.dcoco_coconutbudandfruitrot,
                R.drawable.dcoco_leafspot,
                R.drawable.dcoco_stembleedingdisease
        };

        dcocoNames = new String[]{
                context.getResources().getStringArray(R.array.CadangCadang)[0],
                context.getResources().getStringArray(R.array.CoconutBudandFruitRot)[0],
                context.getResources().getStringArray(R.array.LeafSpot)[0],
                context.getResources().getStringArray(R.array.StemBleedingDisease)[0]
        };

        dcocoCommonNames = new String[]{
                context.getResources().getStringArray(R.array.CadangCadang)[1],
                context.getResources().getStringArray(R.array.CoconutBudandFruitRot)[1],
                context.getResources().getStringArray(R.array.LeafSpot)[1],
                context.getResources().getStringArray(R.array.StemBleedingDisease)[1]
        };
    }

    public void readCSV(String filename) throws FileNotFoundException {
        String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String pathDir = baseDir + "/Android/data/com.projectsarai.pestlibrary/csv";
        File csvFile = new File(pathDir,filename);
        if (csvFile.exists()) {
            InputStream targetStream = new FileInputStream(csvFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(targetStream));
            try {
                String line;
                line = reader.readLine(); //remove the headers
                while ((line = reader.readLine()) != null) {
                    ArrayList<String> item = new ArrayList<String>();
                    String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    for(String t : tokens) {
                        t = t.replaceAll("^\"|\"$", "");
                        item.add(t);
                    }
                    items.add(item);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Log.d(TAG,"File does not exist");
        }
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

    public List<Item> getDriceItemData(){
        initDriceData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<driceNames.length && i<driceIcons.length; i++) {
            Item current = new Item();
            current.imageId = driceIcons[i];
            current.diseaseName = driceNames[i];
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

    public List<Item> getDcornItemData(){
        initDcornData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<dcornNames.length && i<dcornIcons.length; i++) {
            Item current = new Item();
            current.imageId = dcornIcons[i];
            current.diseaseName = dcornNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getBananaItemData(){
        initBananaData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<bananaNames.length && i<bananaIcons.length; i++) {
            Item current = new Item();
            current.imageId = bananaIcons[i];
            current.pestName = bananaNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getDbananaItemData(){
        initDbananaData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<dbananaNames.length && i<dbananaIcons.length; i++) {
            Item current = new Item();
            current.imageId = dbananaIcons[i];
            current.diseaseName = dbananaNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getCacaoItemData(){
        initCacaoData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<cacaoNames.length && i<cacaoIcons.length; i++) {
            Item current = new Item();
            current.imageId = cacaoIcons[i];
            current.pestName = cacaoNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getDcacaoItemData(){
        initDcacaoData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<dcacaoNames.length && i<dcacaoIcons.length; i++) {
            Item current = new Item();
            current.imageId = dcacaoIcons[i];
            current.diseaseName = dcacaoNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getCoffeeItemData(){
        initCoffeeData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<coffeeNames.length && i<coffeeIcons.length; i++) {
            Item current = new Item();
            current.imageId = coffeeIcons[i];
            current.pestName = coffeeNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getDcoffeeItemData(){
        initDcoffeeData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<dcoffeeNames.length && i<dcoffeeIcons.length; i++) {
            Item current = new Item();
            current.imageId = dcoffeeIcons[i];
            current.diseaseName = dcoffeeNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getCocoItemData(){
        initCocoData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<cocoNames.length && i<cocoIcons.length; i++) {
            Item current = new Item();
            current.imageId = cocoIcons[i];
            current.pestName = cocoNames[i];
            data.add(current);
        }
        return data;
    }

    public List<Item> getDcocoItemData(){
        initDcocoData();
        List<Item> data = new ArrayList<>();

        for (int i=0; i<dcocoNames.length && i<dcocoIcons.length; i++) {
            Item current = new Item();
            current.imageId = dcocoIcons[i];
            current.diseaseName = dcocoNames[i];
            data.add(current);
        }
        return data;
    }

    public List<ItemAll> getPestsData(String filename) {
        try {
            readCSV(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<ItemAll> data = new ArrayList<>();

        for (int i=0; i<items.size(); i++) {
            ItemAll current = new ItemAll();
            ArrayList<String> entry = items.get(i);

            current.name = entry.get(1);
            current.commonNames = entry.get(2);
            current.filName = entry.get(3);
            current.sciName = entry.get(4);
            current.signs = entry.get(5);
            current.mgt = entry.get(6);
            current.imageUrl = entry.get(7);

            data.add(current);
        }
        return data;
    }

    public List<ItemAll> getDiseasesData(String filename) {
        try {
            readCSV(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<ItemAll> data = new ArrayList<>();

        for (int i=0; i<items.size(); i++) {
            ItemAll current = new ItemAll();
            ArrayList<String> entry = items.get(i);

            current.name = entry.get(1);
            current.commonNames = entry.get(2);
            current.filName = entry.get(3);
            current.sciName = entry.get(4);
            current.signs = entry.get(5);
            current.mgt = entry.get(6);
            current.imageUrl = entry.get(7);

            data.add(current);
        }
        return data;
    }

    //all items
    public List<ItemAll> getAllRiceItemData() {
        return getPestsData("pests-rice.csv");
    }

    public List<ItemAll> getAllDriceItemData() {
        return getDiseasesData("diseases-rice.csv");
    }

    public List<ItemAll> getAllCornItemData() {
        return getPestsData("pests-corn.csv");
    }

    public List<ItemAll> getAllDcornItemData() {
        return getDiseasesData("diseases-corn.csv");
    }

    public List<ItemAll> getAllBananaItemData() {
        return getPestsData("pests-banana.csv");
    }

    public List<ItemAll> getAllDbananaItemData() {
        return getDiseasesData("diseases-banana.csv");
    }

    public List<ItemAll> getAllCacaoItemData() {
        return getPestsData("pests-cacao.csv");
    }

    public List<ItemAll> getAllDcacaoItemData() {
        return getDiseasesData("diseases-cacao.csv");
    }

    public List<ItemAll> getAllCoffeeItemData() {
        return getPestsData("pests-coffee.csv");
    }

    public List<ItemAll> getAllDcoffeeItemData() {
        return getDiseasesData("diseases-coffee.csv");
    }

    public List<ItemAll> getAllCocoItemData() {
        return getPestsData("pests-coconut.csv");
    }

    public List<ItemAll> getAllDcocoItemData() {
        return getDiseasesData("diseases-coconut.csv");
    }
}
