package com.example.mrsnack.mrtrip.Data;

import com.example.mrsnack.mrtrip.Moduls.Guide;
import com.example.mrsnack.mrtrip.Moduls.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripsData {
    ArrayList<Trip> trips = new ArrayList<Trip>();

    public TripsData(){

        Guide guide = new Guide(100 ,
                "Rahaf Altaher" ,
                "05990000");


        Trip trip = new Trip("احراش السعادة",
                "٢٠ - ١ -٢٠١٨  ",
               "يوم واحد ",
        70.0,
        "جنين مدينة فلسطينية، ومركز محافظة جنين وأكبر مدنها، تقع في شمال الضفة الغربية التابعة للسلطة الفلسطينية. تعتبر تاريخيا، إحدى مدن المثلث في شمال فلسطين، وتبعد عن القدس مسافة 75 كيلومترا إلى الشمال. تطل جنين على غور الأردن من ناحية الشرق، ومرج بن عامر إلى جهة الشمال.\n" +
                "\n" +
                "بالرغم من قلة عدد سكانها حتى تاريخ وقوع النكبة مقارنة بالمدن الفلسطينية الأخرى، إلا أن لها ثقلا اقتصاديا أكبر بكثير من حجمها السكاني. يبلغ عدد سكان المدينة 39,000 نسمة، أما المحافظة فيقطنها حوالي 256,000 نسمة.",
                guide,
        100,
                "مشي على الاقدام",
                " رحلة شوي ",
                " شوي بالاحراش",
                "https://cdn.thecrazytourist.com" +
                        "/wp-content/uploads/2018/05/" +
                        "ccimage-shutterstock_228813178-770x430.jpg");



        Guide guide1 = new Guide(100 ,
                "Rahaf Altaher" ,
                "05990000");


        Trip trip1 = new Trip("Brussels",
                "2 - Feb - 2019 ",
                "2 weeks",
                700.0,
                "Nice trip to brussels",
                guide1,
                100,
                "Air",
                "Education Trip",
                "Brussels Trip",
                "https://media-cdn.tripadvisor.com/media/" +
                        "photo-s/0d/f4/de/28/amsterdam-day-trip-from.jpg"
                );

        trips.add(trip);
        trips.add(trip1);

    }

    public ArrayList<Trip> getTrips(){
        return trips;
    }


}
