package android.teste.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToCalc(View v){
        String tag = v.getTag().toString();
        System.out.println(tag);
        if(tag.equals("simple")){
            Intent it = new Intent(getBaseContext(), SimpleCalcActivity.class);
            startActivity(it);
        } else if(tag.equals("complete")){
            Intent it = new Intent(getBaseContext(), CompleteCalcActivity.class);
            startActivity(it);
        }
    }
}