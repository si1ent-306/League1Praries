package com.example.elliottwagner.league;

import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elliottwagner.R;

import java.util.Objects;

public class LeagueNewsPage extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //will hide the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_league_news_page);
        //get the view
        webView = findViewById(R.id.wvLeagueNews);
        //load the html
        String data = "";
        data = "<HTML> " +
                "<BODY> " +
                "<H1>League Preview</H1> " +
                "<IMG SRC='https://images2.minutemediacdn.com/image/upload/c_crop,w_4515,h_2539,x_0,y_183/c_fill,w_720,ar_16:9,f_auto,q_auto,g_auto/images/GettyImages/mmsport/90min_en_international_web/01ghvfc0eqe3qaz4remn.jpg'> " +
                "<P>The Canadian soccer landscape is about to expand with the much-anticipated launch of League1 Prairies! This brand new pro-am league, kicking off its inaugural season in Spring 2025, will bring high-level competition to Manitoba, Saskatchewan, and Alberta.\n" +
                "\n" +
                "League1 Prairies follows the successful model established by League1 Ontario, League1 British Columbia, and Ligue1 Québec. It will feature both men's and women's divisions, offering a platform for talented players to develop their skills and potentially climb the ranks of Canadian soccer.\n" +
                "\n" +
                "Building a Prairie Powerhouse\n" +
                "\n" +
                "While the official team announcements are yet to come, anticipation is high. Cities like Winnipeg, Regina, Saskatoon, Calgary, and Edmonton are all potential contenders for hosting franchises. Each team will undoubtedly build a passionate fanbase, fostering a strong sense of community spirit.\n" +
                "\n" +
                "A League Rooted in Community\n" +
                "\n" +
                "League1 Prairies isn't just about the beautiful game; it's about creating a vibrant soccer culture in the Prairies. The league aims to inspire youth participation, provide role models, and become a source of local pride.\n" +
                "\n" +
                "A Glimpse into the Future\n" +
                "\n" +
                "With the inaugural season on the horizon, questions abound. Which cities will secure teams? Who will be the star players to watch? How will rivalries develop? One thing is certain: League1 Prairies promises to be an exciting addition to the Canadian soccer scene.\n" +
                "\n" +
                "Get Ready to Cheer!\n" +
                "\n" +
                "Mark your calendars, soccer fans! League1 Prairies is gearing up to be an unforgettable experience. With passionate supporters, talented players, and a commitment to community, " +
                "this league is poised to become a pillar of Canadian soccer for years to come. Stay tuned for further announcements on teams, schedules, and how you can be part of the action!.</P> " +
                "</BODY> " +
                "</HTML>";
        //load the html
        webView.loadData(data, "text/html", "UTF-8");

    }
}