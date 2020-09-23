package android.teste.simplecalc;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

import androidx.appcompat.app.AppCompatActivity;

public class CompleteCalcActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void changeExpression(View v){
        EditText output = findViewById(R.id.visor);
        String outTxt = output.getText().toString();
        String pressedTag = v.getTag().toString();
        String buttonText = ((Button)v).getText().toString();
        if(pressedTag.equals("Back")){
            if(outTxt.substring(outTxt.length() - 1).equals(" "))
                output.setText(outTxt.substring(0, outTxt.length()-2));
            else output.setText(outTxt.substring(0, outTxt.length()-1));
        } else if(pressedTag.equals("Clear")){
            output.setText("");
        } else output.setText(outTxt + buttonText);
    }

    public void calculateExpression(View v){
        EditText output = findViewById(R.id.visor);
        String outTxt = output.getText().toString().replaceAll("\\s+", "");
        Expression e = new Expression(outTxt);
        String result = String.valueOf(e.calculate());
        output.setText(result);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }
        return true;
    }
}
