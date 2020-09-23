package android.teste.simplecalc;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SimpleCalcActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void calculate(View v){
        String tag = v.getTag().toString();
        String res = "";

        EditText v1 = findViewById(R.id.valor1);
        EditText v2 = findViewById(R.id.valor2);

        String sv1 = v1.getText().toString();
        String sv2 = v2.getText().toString();

        if(!sv1.matches("")){
            if(!sv2.matches("")){
                int result = 0;
                switch (tag){
                    case "sum":
                        result = Integer.parseInt(sv1) + Integer.parseInt(sv2);
                        break;
                    case "sub":
                        result = Integer.parseInt(sv1) - Integer.parseInt(sv2);
                        break;
                    case "mult":
                        result = Integer.parseInt(sv1) * Integer.parseInt(sv2);
                        break;
                    case "div":
                        result = Integer.parseInt(sv1) / Integer.parseInt(sv2);
                        break;
                }
                res = new Integer(result).toString();
            }
        }

        TextView resView = findViewById(R.id.result);
        resView.setText(resView.getText().toString().substring(0, 15) + res);

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
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