package rachael.murtagh.radiobuttontipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tip_amount;
    private TextView total_bill_amount;

    private EditText bill_amount_number;

    private RadioButton tip_10;
    private RadioButton tip_15;
    private RadioButton tip_20;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_bill_amount = findViewById(R.id.total_bill_amount);
        tip_amount = findViewById(R.id.tip_amount);
        bill_amount_number = findViewById(R.id.bill_amount_number);
        button = findViewById(R.id.button);

        button.setVisibility(View.INVISIBLE);
    }

    public void onRadioButtonClicked(View view){

        tip_10 = findViewById(R.id.tip_10);
        tip_15 = findViewById(R.id.tip_15);
        tip_20 = findViewById(R.id.tip_20);

        boolean tip10checked = tip_10.isChecked();
        boolean tip15checked = tip_15.isChecked();
        boolean tip20checked = tip_20.isChecked();

        double billAmount = Double.parseDouble(bill_amount_number.getText().toString());
        double tipPercentage = 0;

        button.setVisibility(View.VISIBLE);

        switch (view.getId())
        {
            case R.id.tip_10:
                tipPercentage = 0.1;
                if (tip15checked || tip20checked)
                {
                    tip_15.setChecked(false);
                    tip_20.setChecked(false);
                }
                break;

            case R.id.tip_15:
                tipPercentage = 0.15;
                if (tip10checked || tip20checked)
                {
                    tip_10.setChecked(false);
                    tip_20.setChecked(false);
                }
                break;

            case R.id.tip_20:
                tipPercentage = 0.20;
                if (tip10checked || tip15checked)
                {
                    tip_10.setChecked(false);
                    tip_15.setChecked(false);
                }
                break;
        }

        double tipAmount = billAmount * tipPercentage;
        double totalAmount = billAmount + tipAmount;

        tip_amount.setText(String.format("£%.2f", tipAmount));
        total_bill_amount.setText(String.format("£%.2f", totalAmount));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tip10checked || tip15checked || tip20checked)
                {
                    bill_amount_number.getText().clear();
                    tip_10.setChecked(false);
                    tip_15.setChecked(false);
                    tip_20.setChecked(false);
                    tip_amount.setText("");
                    total_bill_amount.setText("");
                    button.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}