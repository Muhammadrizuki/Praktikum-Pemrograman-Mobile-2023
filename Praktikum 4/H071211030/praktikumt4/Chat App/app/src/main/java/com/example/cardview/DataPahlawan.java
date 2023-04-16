package com.example.cardview;

import java.util.ArrayList;

public class DataPahlawan {

    public static String[][] data = new String[][]{
            {"Starbuck", "Ingfokan minuman gratis", "01:10 PM", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHmSzr9S1_lR5mmcSvqm8hmAKrXjORmHeHIA&usqp=CAU.jpg", "08123456789", "Giveaway soon", "17 Maret 2023"},
            {"Lamborghini", "When restock, sir?", "12:10 PM", "https://global-uploads.webflow.com/5e157548d6f7910beea4e2d6/62a201d8ec77ff8124c222a6_V-Cpq-hK0kOJC605waKjYdCHEcVh2fxMxylKH_7lOBFS7HlfKS5UwfR-6vqyxBU5GS9rTpNgMmrIRl1kod4kj8gaS8DswE6NhiKZkKLhxgD61QMDunBxnhM0dXM4ayuEHqnBSRnQ6fqVIwGKrw.png", "08234263273", "Feel the bull", "16 Maret 2023"},
            {"Apple", "Iphone 69 Pro Max Soon ay?", "11:00 AM", "https://99designs-blog.imgix.net/blog/wp-content/uploads/2017/06/apple.png?auto=format&q=60&fit=max&w=930.jpg", "08343528457", "Apple Inc.", "20 April 2023"},
            {"Pepsi", "Mending Sprite ato Fanta?", "09:00 PM", "https://cdn2.hubspot.net/hub/145335/file-407359001-png/blog-files/pepsi.png", "02390131213", "Official PEPSI", "11 Maret 2023"},
            {"LG", "LG ni bos", "08:00 PM", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQo_eY_v3m_vd27ynMtsr1XPw_j0nPaV5DoEiSzyiApp2kIyO7Uxi14jreSFRfAoVKGVvQ&usqp=CAU.jpg", "0934024572045", "LG Afterparty", "29 Maret 2023"},
            {"Louis Vuitton", "More collab soon right?", "06:00 PM", "https://www.gblogodesign.co.uk/wp-content/uploads/2021/05/Louis-Vuitton.png", "0213314142", "LV", "12 Januari 2023"},
            {"Corsair", "Best gaming gear on the Cowboy era", "07:00 PM", "https://cutewallpaper.org/24/corsair-logo-png/dimm-240pin-png-download-corsair-logo-transparent-png--1000x7505989483-pngfind.png", "08114231312", "CORSAIR", "17 Februari 2023"},
            {"Vans", "Looking for shoes? means looking for us", "12:00 PM", "https://logos-world.net/wp-content/uploads/2020/05/Vans-Logo-1966.png", "08114613767", "VANS of the wall", "17 Agustus 2023"},
            {"Lego", "Lego4life", "10:00 PM", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/768px-LEGO_logo.svg.png", "08114613767", "LEGOS AMIGOS", "17 Desember 2023"},
            {"Dove", "Pemutih keputihan", "11:00 AM", "https://www.thelogocreative.co.uk/wp-content/uploads/Dove.png", "0811462313767", "DOVE of LOVE", "17 Mei 2020"},
    };

    public static ArrayList<ModelPahlawan>
    ambilDataPahlawan() {
        ArrayList<ModelPahlawan> dataPahlawan = new ArrayList<>();
        for (String[] varData : data) {
            ModelPahlawan model = new ModelPahlawan();
            model.setNama(varData[0]);
            model.setTentang(varData[1]);
            model.setWaktu(varData[2]);
            model.setFoto(varData[3]);
            model.setNomor(varData[4]);
            model.setStatus(varData[5]);
            model.setTgl_status(varData[6]);
            dataPahlawan.add(model);
        }
        return dataPahlawan;
    }
}
