package com.abhishekshah.railconnect;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.Toast;

        import com.chyrta.onboarder.OnboarderActivity;
        import com.chyrta.onboarder.OnboarderPage;

        import java.util.ArrayList;
        import java.util.List;

public class Intro extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDividerColor(Color.BLACK);

        OnboarderPage onboarderPage1 = new OnboarderPage("Petition Filing\n", "Gain support to bring about a change!\n", R.drawable.petition);
        OnboarderPage onboarderPage2 = new OnboarderPage("Report Missing\n", "Found someone missing? Report it to all the app users at a click!\n", R.drawable.missing);
        OnboarderPage onboarderPage3 = new OnboarderPage("Service Classifieds\n", "Enjoy local services by the people without any hassle!\n", R.drawable.services);
        OnboarderPage onboarderPage4 = new OnboarderPage("Genuine Updates\n", "Tired about fake local alerts? Get genuine news right from Twitter!\n", R.drawable.twitter);
        OnboarderPage onboarderPage5 = new OnboarderPage("Crowd Status\n", "Check how crowded the local is, reported live by the travellers!\n", R.drawable.crowd);

        onboarderPage1.setBackgroundColor(R.color.onboarder_bg_1);
        onboarderPage2.setBackgroundColor(R.color.onboarder_bg_2);
        onboarderPage3.setBackgroundColor(R.color.onboarder_bg_3);
        onboarderPage4.setBackgroundColor(R.color.onboarder_bg_2);
        onboarderPage5.setBackgroundColor(R.color.onboarder_bg_3);

        List<OnboarderPage> pages = new ArrayList<>();

        pages.add(onboarderPage1);
        pages.add(onboarderPage2);
        pages.add(onboarderPage3);
        pages.add(onboarderPage4);
        pages.add(onboarderPage5);

        for (OnboarderPage page : pages) {
            page.setTitleColor(R.color.primary_text);
            page.setDescriptionColor(R.color.primary_text1);
            //page.setMultilineDescriptionCentered(true);
        }

        setSkipButtonTitle("Skip");
        setFinishButtonTitle("Finish");

        setOnboardPagesReady(pages);

    }

    @Override
    public void onSkipButtonPressed() {
        super.onSkipButtonPressed();
        Toast.makeText(this, "Skip button was pressed!", Toast.LENGTH_SHORT).show();
        Intent startIntent=new Intent(getApplicationContext(),menu.class);

        startActivity(startIntent);

    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish button was pressed", Toast.LENGTH_SHORT).show();
        Intent startIntent=new Intent(getApplicationContext(),menu.class);

        startActivity(startIntent);

    }

}