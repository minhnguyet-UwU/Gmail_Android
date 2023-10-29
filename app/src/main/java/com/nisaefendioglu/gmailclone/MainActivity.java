package com.nisaefendioglu.gmailclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView gmailListView;
    final ArrayList<MailList> mailList = new ArrayList<>();
    FloatingActionButton sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendMessage = findViewById(R.id.sendMessage);
        sendMessage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(),SendMessage.class);
            startActivity(intent);
        });

        gmailListView = findViewById(R.id.gmailListView);

        mailList.add(new MailList("Edurila.com","$19 Only (First 10 spots) - Bestselling...\n"+"Are you looking to Learn Web Designing...","E",R.menu.circle));
        mailList.add(new MailList("Chris Abad","Help make Campaign Monitor better\n" +
                "Let us know your thoughts! No Images...\n","C",R.menu.circle2));
        mailList.add(new MailList("Tuto.com","8h de formation gratuite et les nouvea...\n"+"Photoshop, SEO, Blender, CSS, Wordpress,...","T",R.menu.circle3));
        mailList.add(new MailList("Support","Société Ovh: suivi de vos services","S",R.menu.circle4));
        mailList.add(new MailList("Matt from Iconic","The New Iconic Creator Is Here!\n"+"Announcing the all-new Creator...\n","M",R.menu.circle5));
        mailList.add(new MailList("Josh Hamid","Web scraping does not have to break the bank\n" +
                "Hi user, I hope you are doing great. How is your scraping...","J",R.menu.circle2));
        mailList.add(new MailList("Google","It is a long established fact that a reader will be distracted by a readable content of a page when looking at its layout...","G",R.menu.circle));
        mailList.add(new MailList("Analytics Vidhya","Master tha Art of Full Stack Data Science: Your guide to success", "A",R.menu.circle3));

        MailAdapter mailAdapter = new MailAdapter(this, mailList);
        if (gmailListView != null) {
            gmailListView.setAdapter(mailAdapter);
        }

        gmailListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplication(),MailDetails.class);
            startActivity(intent);
        });

    }
}